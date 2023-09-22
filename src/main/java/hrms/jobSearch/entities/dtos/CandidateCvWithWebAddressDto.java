package hrms.jobSearch.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvWithWebAddressDto {
	
	private int candidateCvId;
	private int candidateId;
	private String webAddress;

}
