package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.CandidateService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;



@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	
	private CandidateService _candidateService;
	
	@Autowired
	public  CandidatesController(CandidateService candidateService) {
		this._candidateService=candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
			return this._candidateService.getAll();
		}
	
	@PostMapping("/register")
	public Result register(@RequestBody Candidate candidate){
			return this._candidateService.register(candidate);
		}
}
