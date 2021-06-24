package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.CvSchoolService;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;


import project.hrms.entities.concretes.CVSchool;



@RestController
@RequestMapping("/api/cvschools")
public class CvSchoolsController  {

	private CvSchoolService _cvSchoolService;
	
	@Autowired
	public CvSchoolsController(CvSchoolService cvSchoolService) {
		this._cvSchoolService=cvSchoolService;
	}
	
	
	
	@PostMapping("add")
	public Result add(@RequestBody CVSchool school) {
		return 	this._cvSchoolService.add(school);
	
	}

	@GetMapping("getall")
	public DataResult<List<CVSchool>> getAll() {
		return this._cvSchoolService.getAll();
		
	}



	@GetMapping("getallschoolorderbyendDate")
	public DataResult<List<CVSchool>> getAllSchoolsByEndDate(@RequestParam int candidateId) {
		
		return this._cvSchoolService.getAllSchoolsByEndDate(candidateId);
	}



}
