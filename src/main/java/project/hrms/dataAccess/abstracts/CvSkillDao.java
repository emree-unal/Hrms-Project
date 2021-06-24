package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.CVSkill;

public interface CvSkillDao extends JpaRepository<CVSkill, Integer> {

}
