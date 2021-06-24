package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.CvSkillService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.concretes.CVSkill;

@RestController
@RequestMapping("/api/cvskills")
public class CvSkillsController {

	
	private CvSkillService _cvSkillService;
	
	@Autowired
	public CvSkillsController(CvSkillService cvSkillService) {
		this._cvSkillService=cvSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CVSkill cvSkill) {
		return this._cvSkillService.add(cvSkill);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<CVSkill>> getAll() {
		return this._cvSkillService.getAll();
		
	}
}
