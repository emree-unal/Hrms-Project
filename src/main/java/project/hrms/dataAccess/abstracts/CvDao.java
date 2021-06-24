package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.hrms.entities.concretes.CV;

public interface CvDao extends JpaRepository<CV,Integer>{
	
	@Query("From CV c Where c.candidate.id=:candidateId")
	List<CV> getAllCvByCandidateId(@Param("candidateId")int candidateId);
}
