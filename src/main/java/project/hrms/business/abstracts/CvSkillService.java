package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.concretes.CVSkill;

public interface CvSkillService {
	Result add(CVSkill skill);
	DataResult<List<CVSkill>> getAll();
}
