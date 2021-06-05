package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import project.hrms.business.abstracts.JobAdvertisementService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobAdvertisementDao;
import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDetailDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao _jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao ) {
		this._jobAdvertisementDao=jobAdvertisementDao;
	}
	
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this._jobAdvertisementDao.findAll(),"İş ilanları listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobDetails) {
		this._jobAdvertisementDao.save(jobDetails);
		return new SuccessResult("İş ilanı eklendi.");
	}


	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getAllActiveJobAdvertisements() {
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(this._jobAdvertisementDao.getAllActiveJobAdvertisements(),"Aktif iş ilanları listelendi.");
	}


	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getAllActiveJobAdvertisementsByPublicationDate() {
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(this._jobAdvertisementDao.getAllActiveJobAdvertisementsByPublicationDate(),"Aktif iş ilanları yayınlanma tarihine göre listelendi.");
	}


	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getAllActiveJobAdvertisementsByCompanyId(int id) {
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(this._jobAdvertisementDao.getAllActiveJobAdvertisementsByCompanyId(id),"İş ilanları firma ismine göre listelendi.");
	}


	@Override
	public Result updateStatusOfJobAdvertisement(int jobAdvertisementId, int employerId) {
		this._jobAdvertisementDao.updateStatusOfJobAdvertisement(jobAdvertisementId, employerId);
		return new SuccessResult("İlan aktiflik durumu güncellendi.");
	}

}
