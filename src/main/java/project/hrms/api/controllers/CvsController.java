package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.CvService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CV;

@RestController
@RequestMapping("/api/cvs")
public class CvsController  {
	
	private CvService _cvService;
	
	@Autowired
	public CvsController(CvService cvService) {
		this._cvService=cvService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CV cv) {
		return this._cvService.add(cv);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<CV>> getAll() {
		return this._cvService.getAll();
		
	}


	@GetMapping("/getAllCvByCandidateId")
	public DataResult<List<CV>> getAllCvByCandidateId(@RequestParam int candidateId) {
		
		return this._cvService.getAllCvByCandidateId(candidateId);
	}

}
