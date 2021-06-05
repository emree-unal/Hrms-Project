package project.hrms.entities.dtos;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDetailDto {
	
	private int id;
	
	private String companyName;

	private String jobTitle;
	
	private int personelAmount;

	private LocalDateTime applicationDeadline;
	
	private LocalDateTime publicationDate;

	
	
	

}
