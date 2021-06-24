package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import project.hrms.business.abstracts.CvWorkExperienceService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CVWorkExperience;

@RestController
@RequestMapping("/api/cvworkexperiences")
public class CvWorkExperiencesController  {


	private CvWorkExperienceService _cvWorkExperienceService;
	
	@Autowired
	public CvWorkExperiencesController(CvWorkExperienceService cvWorkExperienceService) {
		this._cvWorkExperienceService=cvWorkExperienceService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody CVWorkExperience workExperience) {
		return this._cvWorkExperienceService.add(workExperience);
	}

	@GetMapping("getall")
	public DataResult<List<CVWorkExperience>> getAll() {
		return this._cvWorkExperienceService.getAll();
	}

	@GetMapping("getAllExperienceByEndDate")
	public DataResult<List<CVWorkExperience>> getAllWorkExperiencesByEndDate(@RequestParam int candidateId) {
		
		return this._cvWorkExperienceService.getAllWorkExperiencesByEndDate(candidateId);
	}

}
