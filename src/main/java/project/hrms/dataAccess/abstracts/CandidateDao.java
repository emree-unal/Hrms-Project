package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	boolean existsByEmail(String email);
	boolean existsByNationalIdentity(String nationalIdentity);
}
