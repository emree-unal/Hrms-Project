package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CvSkillService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvSkillDao;
import project.hrms.entities.concretes.CVSkill;

@Service
public class CvSkillManager implements CvSkillService {
	
	

	private CvSkillDao _cvSkillDao;
	
	@Autowired
	public CvSkillManager(CvSkillDao cvSkillDao) {
		this._cvSkillDao=cvSkillDao;
	}

	@Override
	public Result add(CVSkill skill) {
		this._cvSkillDao.save(skill);
		return new SuccessResult("Yetenekler eklendi.");
	}

	@Override
	public DataResult<List<CVSkill>> getAll() {
		
		return new SuccessDataResult<List<CVSkill>>(this._cvSkillDao.findAll(), "Yetenekler listelendi.");
	}

}
