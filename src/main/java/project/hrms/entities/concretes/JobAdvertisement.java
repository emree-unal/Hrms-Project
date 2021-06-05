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




import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisements")

public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	
	private int id;
	
	//@Column(name="employer_id")
	//private int employerId;
	
	
	
	@Column(name="description")
	private String description;

	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="number_of_personnel")
	private int personelAmount;
	
	@Column(name="application_deadline")

	private LocalDateTime applicationDeadline;

	
	@Column(name="publication_date")
	private LocalDateTime publicationDate;
	
	@Column(name="advertisement_status")
	private boolean status;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private Position jobTitle;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="employer_id",referencedColumnName = "id", nullable = false)
	private Employer employer;
	
	
}
