package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CvSchoolService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvSchoolDao;
import project.hrms.entities.concretes.CVSchool;

@Service
public class CvSchoolManager implements CvSchoolService {

	private CvSchoolDao _cvSchoolDao;
	
	@Autowired
	public CvSchoolManager(CvSchoolDao cvSchoolDao) {
		this._cvSchoolDao=cvSchoolDao;
	}
	
	
	@Override
	public Result add(CVSchool school) {
		
		this._cvSchoolDao.save(school);
		return new SuccessResult("Okullar eklendi");
	}

	@Override
	public DataResult<List<CVSchool>> getAll() {
		return new SuccessDataResult<List<CVSchool>>(this._cvSchoolDao.findAll(), "Okullar listelendi.");
	}


	@Override
	public DataResult<List<CVSchool>> getAllSchoolsByEndDate(int candidateId) {
		
		return new SuccessDataResult<List<CVSchool>>(this._cvSchoolDao.getAllSchoolsByEndDate(candidateId),"Okullar mezuniyet tarihine göre listelendi.");
	}

}
