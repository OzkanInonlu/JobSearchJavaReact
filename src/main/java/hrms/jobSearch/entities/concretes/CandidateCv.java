package hrms.jobSearch.entities.concretes;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_cvs")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "skills", "schools", "jobExperiences", "languages", "webaddresses"})
public class CandidateCv {

	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createdAt = LocalDateTime.now();

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "cover_letter")
	private String coverLetter;

//	@JsonIgnore
//	@OneToMany(mappedBy = "candidateCv")
//	private List<School> schools;
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
	  name = "candidate_cv_schools", 
	  joinColumns = @JoinColumn(name = "candidate_cv_id", referencedColumnName = "id"), 
	  inverseJoinColumns = @JoinColumn(name = "school_id", referencedColumnName = "id"))
	
	private Set<School> schools= new HashSet<School>();
	
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "candidateCv")
//	private List<JobExperience> jobExperiences;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
	  name = "candidate_cv_job_experiences", 
	  joinColumns = @JoinColumn(name = "candidate_cv_id", referencedColumnName = "id"), 
	  inverseJoinColumns = @JoinColumn(name = "job_experience_id", referencedColumnName = "id"))
	private Set<JobExperience> jobExperiences= new HashSet<JobExperience>();
	
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "candidateCv")
//	private List<Language> languages;
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
	  name = "candidate_cv_languages", 
	  joinColumns = @JoinColumn(name = "candidate_cv_id", referencedColumnName = "id"), 
	  inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName = "id"))
	private Set<Language> languages= new HashSet<Language>();

	
	@JsonIgnore
    @OneToOne
    @JoinColumn(name = "candidate_image_id")
    private CandidateImage candidateImage;
	
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "candidateCv")
//	private List<WebAddress> webaddresses;
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
	  name = "candidate_cv_webaddresses", 
	  joinColumns = @JoinColumn(name = "candidate_cv_id", referencedColumnName = "id"), 
	  inverseJoinColumns = @JoinColumn(name = "web_address_id", referencedColumnName = "id"))
	private Set<WebAddress> webaddresses = new HashSet<WebAddress>();
	

//	@JsonIgnore
//	@OneToMany(mappedBy = "candidateCv")
//	private List<Skill> skills;
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
	  name = "candidate_cv_skills", 
	  joinColumns = @JoinColumn(name = "candidate_cv_id", referencedColumnName = "id"), 
	  inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"))
	private Set<Skill> skills = new HashSet<Skill>();
	

	@NotNull
	@JoinColumn(name = "candidate_id")
	@OneToOne
	private Candidate candidate;
	
	
//	public void addSkill(Skill skill) {
//		this.skills.add(skill);
//		skill.getCandidateCv().add(this);
//	}
//	
//	  public void removeSkill(int skillId) {
//		    Skill skill = this.skills.stream().filter(t -> t.getId() == skillId).findFirst().orElse(null);
//		    if (skill != null) {
//		      this.skills.remove(skill);
//		      skill.getCandidateCv().remove(this);
//		    }
//		  }
	
}
