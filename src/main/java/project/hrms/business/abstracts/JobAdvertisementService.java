package project.hrms.business.abstracts;

import java.util.List;


import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDetailDto;


public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisementDetailDto>>  getAllActiveJobAdvertisements();
	DataResult<List<JobAdvertisementDetailDto>>  getAllActiveJobAdvertisementsByPublicationDate();
	DataResult<List<JobAdvertisementDetailDto>>  getAllActiveJobAdvertisementsByCompanyId(int id);
	Result updateStatusOfJobAdvertisement(int jobAdvertisementId,int employerId);
	
}
