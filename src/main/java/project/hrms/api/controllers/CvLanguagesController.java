package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.CvLanguageService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.concretes.CVLanguage;


@RestController
@RequestMapping("/api/cvlanguages")
public class CvLanguagesController {
	
	private CvLanguageService _cvLanguageService;
	
	@Autowired
	public CvLanguagesController(CvLanguageService cvLanguageService) {
		this._cvLanguageService=cvLanguageService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CVLanguage cvLanguage) {
		return this._cvLanguageService.add(cvLanguage);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<CVLanguage>> getAll() {
		return this._cvLanguageService.getAll();
		
	}
}
