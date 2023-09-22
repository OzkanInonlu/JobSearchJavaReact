package hrms.jobSearch.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvWithJobExperienceDto {
	
	private int candidateCvId;
	private int candidateId;
	private String companyName;
	private LocalDate jobStartDate;
	private LocalDate jobEndDate;
	private String jobName;

}
