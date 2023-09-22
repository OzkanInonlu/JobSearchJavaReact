package hrms.jobSearch.entities.concretes;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "job_experiences")
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "company_name")
	private String companyName;        //burayı Employer ile bağlardım da oralar çok karışık...
	
/*	@Column(name = "job_position")
	private String jobPosition;
*/
	@Column(name = "date_of_start")
	private LocalDate startDate;
	
	@Column(name = "is_leave")
	private boolean isLeave;
	
	@Column(name = "date_of_end")
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	
//	@ManyToOne
//	@JoinColumn(name = "candidate_cv_id")
//	private CandidateCv candidateCv;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "jobExperiences")
	private Set<CandidateCv> candidateCv = new HashSet<CandidateCv>();

}
