package hrms.jobSearch.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
//@PrimaryKeyJoinColumn(name = "employee_id")
public class Employee{
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
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank
	@NotNull
	@Column(name = "last_name")
	private String lastName;
}
