package hrms.jobSearch.entities.dtos;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvWithSkillDto {
	
    private int candidateCvId;
    private int candidateId;
    private String skillName;
    //private List<String> skills;
	
	

}
