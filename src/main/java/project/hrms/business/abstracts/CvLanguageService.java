package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CVLanguage;


public interface CvLanguageService {
	Result add(CVLanguage language);
	DataResult<List<CVLanguage>> getAll();
}
