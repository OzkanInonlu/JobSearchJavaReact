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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "web_addresses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WebAddress {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Column(name = "name")
	private String name;
	
	//@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name = "candidate_cv_id")
//	private CandidateCv candidateCv;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "webaddresses")
	private Set<CandidateCv> candidateCv = new HashSet<CandidateCv>();
}
