package hrms.jobSearch.entities.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithEmployerDto {
	
	private int employerId;
	private int jobAdvertId;
	private String companyName;
	private String jobName;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private double maxSalary;
	private double minSalary;
	private int freePositionAmount;
	private boolean status;

}
