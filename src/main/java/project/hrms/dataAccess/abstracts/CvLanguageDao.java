package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.CVLanguage;

public interface CvLanguageDao extends JpaRepository<CVLanguage, Integer> {

}
