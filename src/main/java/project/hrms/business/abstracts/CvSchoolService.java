package project.hrms.business.abstracts;

import java.util.List;



import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.concretes.CVSchool;

public interface CvSchoolService {
	Result add(CVSchool school);
	DataResult<List<CVSchool>> getAll();
	DataResult<List<CVSchool>>  getAllSchoolsByEndDate(int candidateId);
}
