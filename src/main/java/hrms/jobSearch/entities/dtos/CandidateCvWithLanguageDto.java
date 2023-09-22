package hrms.jobSearch.entities.dtos;

import org.springframework.data.jpa.repository.Query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvWithLanguageDto {
	
	
	private int candidateCvId;
	private int candidateId;
	private String languageName;
	private int languageLevel;

}
