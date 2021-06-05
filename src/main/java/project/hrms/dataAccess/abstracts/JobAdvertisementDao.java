package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDetailDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	@Query("Select new project.hrms.entities.dtos.JobAdvertisementDetailDto(j.id,e.companyName,p.positionName,j.personelAmount,j.applicationDeadline,j.publicationDate) From JobAdvertisement j Inner Join j.employer e Inner Join j.jobTitle p where j.status='true' ")
	List<JobAdvertisementDetailDto>  getAllActiveJobAdvertisements();
	
	@Query("Select new project.hrms.entities.dtos.JobAdvertisementDetailDto(j.id,e.companyName,p.positionName,j.personelAmount,j.applicationDeadline,j.publicationDate) From JobAdvertisement j Inner Join j.employer e Inner Join j.jobTitle p where j.status='true' order by j.publicationDate Desc ")
	List<JobAdvertisementDetailDto>  getAllActiveJobAdvertisementsByPublicationDate();
	
	@Query("Select new project.hrms.entities.dtos.JobAdvertisementDetailDto(j.id,e.companyName,p.positionName,j.personelAmount,j.applicationDeadline,j.publicationDate) From JobAdvertisement j Inner Join j.employer e Inner Join j.jobTitle p where (j.status='true' and e.id=:id)")
	List<JobAdvertisementDetailDto>  getAllActiveJobAdvertisementsByCompanyId(@Param("id") int id);
	
	@Modifying
	@Query("Update JobAdvertisement set status='false' where id=:jobAdvertisementId and employer.id=:employerId")
	void updateStatusOfJobAdvertisement(@Param("jobAdvertisementId") int jobAdvertisementId,@Param("employerId") int employerId);
}
