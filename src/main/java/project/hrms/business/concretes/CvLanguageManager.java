package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CvLanguageService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvLanguageDao;
import project.hrms.entities.concretes.CVLanguage;

@Service
public class CvLanguageManager implements CvLanguageService {

private CvLanguageDao _cvDaoLanguage;
	
	@Autowired
	public CvLanguageManager(CvLanguageDao cvDaoLanguage) {
		this._cvDaoLanguage=cvDaoLanguage;
	}
	
	
	
	@Override
	public Result add(CVLanguage language) {
	this._cvDaoLanguage.save(language);
		return new SuccessResult("Yabancı diller eklendi.");
	}

	@Override
	public DataResult<List<CVLanguage>> getAll() {
		return new SuccessDataResult<List<CVLanguage>>(this._cvDaoLanguage.findAll(),"Yabancı diller listelendi.");
	}

}
