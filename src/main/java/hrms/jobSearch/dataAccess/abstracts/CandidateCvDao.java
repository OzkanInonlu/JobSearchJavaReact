package hrms.jobSearch.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import hrms.jobSearch.entities.concretes.Candidate;
import hrms.jobSearch.entities.concretes.CandidateCv;
import hrms.jobSearch.entities.dtos.CandidateCvWithJobExperienceDto;
import hrms.jobSearch.entities.dtos.CandidateCvWithLanguageDto;
import hrms.jobSearch.entities.dtos.CandidateCvWithSchoolDto;
import hrms.jobSearch.entities.dtos.CandidateCvWithSkillDto;
import hrms.jobSearch.entities.dtos.CandidateCvWithWebAddressDto;

@Transactional
public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer>{
	
	CandidateCv findById(int candidateCvId);
	CandidateCv findByCandidate_Id(int candidateId);
	
	//skills
	//check if the skill is already in cv
    @Query(
    		value = "SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END "
    		+ "FROM candidate_cv_skills e "
    		+ "WHERE e.skill_id = :skillId", nativeQuery = true)
    boolean existsSkillInCv(int skillId);
	
	@Modifying//EĞER SELECT DIŞINDA BİR SORGU YAPACAKSAK VERİ TABANINDAKİ BİLGİYİ MODİFY EDECEK BUNU KULLANMALIYIZ
    @Query(
            value = "INSERT INTO candidate_cv_skills(candidate_cv_id, skill_id)" +
                    "VALUES(:candidateCvId, :skillId)", nativeQuery = true
    )
    void addSkillToCv(int candidateCvId, int skillId);
	
	
	//schools
	//check if the school is already in cv
    @Query(
    		value = "SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END "
    		+ "FROM candidate_cv_schools e "
    		+ "WHERE e.school_id = :schoolId", nativeQuery = true)
    boolean existsSchoolInCv(int schoolId);
	
	@Modifying//EĞER SELECT DIŞINDA BİR SORGU YAPACAKSAK VERİ TABANINDAKİ BİLGİYİ MODİFY EDECEK BUNU KULLANMALIYIZ
    @Query(
            value = "INSERT INTO candidate_cv_schools(candidate_cv_id, school_id)" +
                    "VALUES(:candidateCvId, :schoolId)", nativeQuery = true
    )
    void addSchoolToCv(int candidateCvId, int schoolId);
	
	
	
	//jobExperiences
	//check if the school is already in cv
    @Query(
    		value = "SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END "
    		+ "FROM candidate_cv_job_experiences e "
    		+ "WHERE e.job_experience_id = :jobExperienceId", nativeQuery = true)
    boolean existsJobExperienceInCv(int jobExperienceId);
	
	@Modifying//EĞER SELECT DIŞINDA BİR SORGU YAPACAKSAK VERİ TABANINDAKİ BİLGİYİ MODİFY EDECEK BUNU KULLANMALIYIZ
    @Query(
            value = "INSERT INTO candidate_cv_job_experiences(candidate_cv_id, job_experience_id)" +
                    "VALUES(:candidateCvId, :jobExperienceId)", nativeQuery = true
    )
    void addJobExperienceToCv(int candidateCvId, int jobExperienceId);
	

	
	
	
	
	
	
	
	
	
	//inner join
	@Query("SELECT NEW hrms.jobSearch.entities.dtos.CandidateCvWithSchoolDto(" +
		       "cv.id, cv.candidate.id, s.schoolName, s.departmentName, s.educationStartDate, s.graduateDate, s.isGraduate) " +
		       "FROM CandidateCv cv " +
		       "INNER JOIN cv.schools s")
	List<CandidateCvWithSchoolDto> getCandidateCvWithSchoolDetails(); 
	
	
	@Query("SELECT NEW hrms.jobSearch.entities.dtos.CandidateCvWithJobExperienceDto(" +
		       "cv.id, cv.candidate.id, je.companyName, je.startDate, je.endDate, je.jobPosition.title ) " +
		       "FROM CandidateCv cv " +
		       "INNER JOIN cv.jobExperiences je")
	List<CandidateCvWithJobExperienceDto> getCandidateCvWithJobExperienceDetails(); 
	
	
	@Query("SELECT NEW hrms.jobSearch.entities.dtos.CandidateCvWithLanguageDto(" +
		       "cv.id, cv.candidate.id, l.languageName, l.languageLevel ) " +
		       "FROM CandidateCv cv " +
		       "INNER JOIN cv.languages l")
	List<CandidateCvWithLanguageDto> getCandidateCvWithLanguageDetails(); 
	
	
	@Query("SELECT NEW hrms.jobSearch.entities.dtos.CandidateCvWithSkillDto(" +
		       "cv.id, cv.candidate.id, s.skillName ) " +
		       "FROM CandidateCv cv " +
		       "INNER JOIN cv.skills s "
		       + "where cv.id=:candidateCvId")
//	@Query("SELECT NEW hrms.jobSearch.entities.dtos.CandidateCvWithSkillDto(" +
//		       "cv.id, cv.candidate.id, " +
//		       "STRING_AGG(s.skillName, ', ') as skills) " +
//		       "FROM CandidateCv cv " +
//		       "INNER JOIN cv.skills s " +
//		       "WHERE cv.id = :candidateCvId " +
//		       "GROUP BY cv.id, cv.candidate.id")
	List<CandidateCvWithSkillDto> getCandidateCvWithSkillDetails(int candidateCvId); 
	
	
	@Query("SELECT NEW hrms.jobSearch.entities.dtos.CandidateCvWithWebAddressDto(" +
		       "cv.id, cv.candidate.id, w.name) " +
		       "FROM CandidateCv cv " +
		       "INNER JOIN cv.webaddresses w")
	List<CandidateCvWithWebAddressDto> getCandidateCvWithWebAddressDetails(); 
	
	


}
