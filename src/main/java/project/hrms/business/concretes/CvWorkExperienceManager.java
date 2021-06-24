package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CvWorkExperienceService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvWorkExperienceDao;
import project.hrms.entities.concretes.CVWorkExperience;

@Service
public class CvWorkExperienceManager implements CvWorkExperienceService {

	private CvWorkExperienceDao _cvWorkExperienceDao;
	
	@Autowired
	public CvWorkExperienceManager(CvWorkExperienceDao cvWorkExperienceDao) {
		this._cvWorkExperienceDao=cvWorkExperienceDao;
	}
	
	@Override
	public Result add(CVWorkExperience workExperience) {
		this._cvWorkExperienceDao.save(workExperience);
		return new SuccessResult("İş tecrübeleri eklendi.");
	}

	@Override
	public DataResult<List<CVWorkExperience>> getAll() {
		
		return new SuccessDataResult<List<CVWorkExperience>>(this._cvWorkExperienceDao.findAll(), "İş tecrübeleri listelendi");
	}

	@Override
	public DataResult<List<CVWorkExperience>> getAllWorkExperiencesByEndDate(int candidateId) {
		
		return new SuccessDataResult<List<CVWorkExperience>>(this._cvWorkExperienceDao.getAllWorkExperiencesByEndDate(candidateId),"İş tecrübeleri tarihe göre listelendi.");
	}

}
