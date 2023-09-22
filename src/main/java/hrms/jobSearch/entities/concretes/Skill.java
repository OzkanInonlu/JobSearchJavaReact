package hrms.jobSearch.entities.concretes;

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
@Table(name = "skills")

public class Skill {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "skill_name", unique = true)
	private String skillName;
	
	//@JsonIgnore
	
//	@ManyToOne
//	@JoinColumn(name = "candidate_cv_id")
//	private CandidateCv candidateCv;
	//manytomany için
	@JsonIgnore
	@ManyToMany(mappedBy = "skills")
	private Set<CandidateCv> candidateCv = new HashSet<CandidateCv>();

}
