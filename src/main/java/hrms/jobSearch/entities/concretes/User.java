package hrms.jobSearch.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //add this since we use inheritance
//@Inheritance(strategy = InheritanceType.JOINED)

public class User {

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
}
