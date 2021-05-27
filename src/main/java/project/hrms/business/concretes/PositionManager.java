package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.PositionService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.PositionDao;
import project.hrms.entities.concretes.Position;


@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}


	@Override
	public DataResult<List<Position>> getAll() {
		
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(),"Pozisyonlar listelendi.");
	}

	@Override
	public Result add(Position position) {
		if(!this.positionDao.existsByPositionName(position.getPositionName())) {
			this.positionDao.save(position);
			return new SuccessResult("Pozisyon eklendi.");
		}else {
			return new ErrorResult("Bu pozisyon ismi zaten bulunmaktadır.");
		}
		
	}

}
