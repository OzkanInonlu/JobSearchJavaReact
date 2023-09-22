package hrms.jobSearch.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvWithSchoolDto {
	
	private int candidateCvId;
	private int candidateId;
	private String schoolName;
	private String departmentName;
	private LocalDate educationStartDate;
	private LocalDate graduateDate;
	private boolean isGraduate;

}
