package project.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cvs")
public class CV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@Column(name="github_adress")
	private String githubAdress;
	
	@Column(name="linkedin_adress")
	private String linkedinAdress;
	
	@Column(name="summary")
	private String coverLetter;
	
	@Column(name="image")
	private String image;
	
	
	@OneToMany(mappedBy = "cv")
	private List<CVWorkExperience> workExperience;
	
	
	@OneToMany(mappedBy = "cv")
	private List<CVLanguage> language;
	
	
	@OneToMany(mappedBy = "cv")
	private List<CVSchool> school;
	
	
	@OneToMany(mappedBy = "cv")
	private List<CVSkill> skill;
}
