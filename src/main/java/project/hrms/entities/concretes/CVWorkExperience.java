package project.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data

@NoArgsConstructor
@Table(name="cv_work_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CVWorkExperience {
	
	public CVWorkExperience(int id, String companyName, String position, LocalDateTime startDate,
			LocalDateTime releaseDate) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.position = position;
		this.startDate = startDate;
		this.releaseDate = releaseDate;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="start_date")
	private LocalDateTime startDate;
	
	@Column(name="release_date")
	private LocalDateTime releaseDate;
	
	@ManyToOne
	@JoinColumn(name="cv_id")
	private CV cv;
}
