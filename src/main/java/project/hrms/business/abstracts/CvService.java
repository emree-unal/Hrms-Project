package project.hrms.business.abstracts;

import java.util.List;



import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CV;


public interface CvService {
	Result add(CV cv);
	DataResult<List<CV>> getAll();
	DataResult<List<CV>> getAllCvByCandidateId(int candidateId);
}
