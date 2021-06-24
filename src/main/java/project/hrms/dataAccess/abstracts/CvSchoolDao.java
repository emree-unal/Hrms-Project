package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.hrms.entities.concretes.CVSchool;


public interface CvSchoolDao extends JpaRepository<CVSchool, Integer> {

	
	@Query("select new project.hrms.entities.concretes.CVSchool(s.id,s.schoolName,s.department,s.startDate,s.endDate) from CVSchool s inner join s.cv c  where c.candidate.id=:candidateId order by s.endDate desc")
	List<CVSchool>  getAllSchoolsByEndDate(@Param("candidateId") int candidateId);
}
