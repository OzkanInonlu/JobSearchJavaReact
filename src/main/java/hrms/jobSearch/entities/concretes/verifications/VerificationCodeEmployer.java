package hrms.jobSearch.entities.concretes.verifications;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hrms.jobSearch.entities.concretes.Employer;

public class VerificationCodeEmployer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "verification_code_id", nullable = false, referencedColumnName = "id")
    private VerificationCode verificationCode;

}
