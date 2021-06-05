package project.hrms.business.abstracts;

import project.hrms.entities.concretes.Candidate;


public interface UserCheckService {
	boolean checkIfRealPerson(Candidate candidate);
}
