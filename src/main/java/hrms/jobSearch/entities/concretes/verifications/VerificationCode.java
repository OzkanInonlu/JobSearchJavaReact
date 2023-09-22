package hrms.jobSearch.entities.concretes.verifications;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "verification_codes")
public class VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    @Column(name = "code", unique = true, nullable = false, length = 38)
    private String code;

    @Column(name = "is_verified", nullable = false)
    private boolean isVerified;

    @Column(name = "verified_date")
    private LocalDate verifiedDate;
}
