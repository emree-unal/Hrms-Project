package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CvService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvDao;
import project.hrms.entities.concretes.CV;

@Service
public class CvManager implements CvService {

	private CvDao _cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		this._cvDao=cvDao;
	}
	
	
	@Override
	public Result add(CV cv) {
		this._cvDao.save(cv);
		return new SuccessResult("Cv ekleme işlemi başarılı");
	}


	@Override
	public DataResult<List<CV>> getAll() {
	return new SuccessDataResult<List<CV>>(this._cvDao.findAll(),"CV ler listelendi.");
	}


	@Override
	public DataResult<List<CV>> getAllCvByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CV>>(this._cvDao.getAllCvByCandidateId(candidateId),"Adaya göre CV'ler listelendi");
	}

}
