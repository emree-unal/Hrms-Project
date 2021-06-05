package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.JobAdvertisementService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDetailDto;


@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementController {
	
	private JobAdvertisementService _jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this._jobAdvertisementService=jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this._jobAdvertisementService.add(jobAdvertisement);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>>  getAllJobAdvertisements(){
		return this._jobAdvertisementService.getAll();
	};
	
	
	@GetMapping("/getAllActive")
	public DataResult<List<JobAdvertisementDetailDto>>  getAllActiveJobAdvertisements(){
		return this._jobAdvertisementService.getAllActiveJobAdvertisements();
	};
	
	@GetMapping("/getAllActiveOrderByDate")
	public DataResult<List<JobAdvertisementDetailDto>> getAllActiveJobAdvertisementsByPublicationDate(){
		return this._jobAdvertisementService.getAllActiveJobAdvertisementsByPublicationDate();
	}
	
	@GetMapping("/getAllActiveByCompanyId")
	public DataResult<List<JobAdvertisementDetailDto>> getAllActiveJobAdvertisementsByCompanyId(@RequestParam int CompanyId){
		return this._jobAdvertisementService.getAllActiveJobAdvertisementsByCompanyId(CompanyId);
	}
	
	@Transactional
	@PutMapping("/updateJobAdvertisementStatus")
	public Result updateStatusOfJobAdvertisement(@RequestParam int jobAdvertisementId,@RequestParam int employerId) {
		return this._jobAdvertisementService.updateStatusOfJobAdvertisement(jobAdvertisementId, employerId);
	}
}
