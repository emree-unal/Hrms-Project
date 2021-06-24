package project.hrms.business.abstracts;

import java.util.List;



import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.concretes.CVWorkExperience;

public interface CvWorkExperienceService {
	Result add(CVWorkExperience workExperience);
	DataResult<List<CVWorkExperience>> getAll();
	DataResult<List<CVWorkExperience>> getAllWorkExperiencesByEndDate(int candidateId);
}
