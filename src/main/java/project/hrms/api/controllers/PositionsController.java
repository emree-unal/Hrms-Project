package project.hrms.api.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.PositionService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Position;


@RestController
@RequestMapping("/api/positions")
public class PositionsController {
	
	private PositionService positionService;
	
	@Autowired
	public PositionsController(PositionService positionService) {
		super();
		this.positionService = positionService;
	}

	@GetMapping("/getall")
	public DataResult<List<Position>> getAll(){
			return this.positionService.getAll();
		}
	
	@PostMapping("/add")
	public Result add(@RequestBody Position position) {
		return this.positionService.add(position);
	}
}
