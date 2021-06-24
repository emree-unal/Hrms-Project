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
@Table(name="cv_schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CVSchool {
	
	
	
	public CVSchool(int id, String schoolName, String department, LocalDateTime startDate, LocalDateTime endDate) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.department = department;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="start_date")
	private LocalDateTime startDate;
	
	@Column(name="end_date")
	private LocalDateTime endDate;
	
	@ManyToOne
	@JoinColumn(name="cv_id")
	private CV cv;
}
