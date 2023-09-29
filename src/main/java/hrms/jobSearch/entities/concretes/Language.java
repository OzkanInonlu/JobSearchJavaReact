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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "languages")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@NotBlank
	@NotNull
	@Column(name = "language_name", unique = true)
	private String languageName;
	
	@NotBlank
	@NotNull
	@Column(name = "language_level")
	@Range(min=1, max=6)
	private int languageLevel;
	
	//@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name = "candidate_cv_id")
//	private CandidateCv candidateCv;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "languages")
	private Set<CandidateCv> candidateCv = new HashSet<CandidateCv>();
	

}
