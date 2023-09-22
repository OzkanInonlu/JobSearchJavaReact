package hrms.jobSearch.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"}) 
//@PrimaryKeyJoinColumn(name = "employer_id")
public class Employer {
/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.TABLE)

	@Column(name = "id")
	private int id;

	@Email
	@NotBlank
	@NotNull
	@Column(name = "email")
	private String email;

	@NotBlank
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotBlank
	@NotNull
	@Column(name = "company_name")
	private String companyName;

	@NotBlank
	@NotNull
	@Column(name = "web_address")
	private String webAddress;

	@NotBlank
	@NotNull
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;

}
