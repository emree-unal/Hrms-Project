package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.hrms.entities.concretes.CVWorkExperience;

public interface CvWorkExperienceDao extends JpaRepository<CVWorkExperience, Integer> {
	
	@Query("Select new project.hrms.entities.concretes.CVWorkExperience (e.id,e.companyName,e.position,e.startDate,e.releaseDate) from CVWorkExperience e inner join e.cv c Where c.candidate.id=:candidateId order by e.releaseDate desc")
	List<CVWorkExperience> getAllWorkExperiencesByEndDate(@Param("candidateId") int candidateId);
}
