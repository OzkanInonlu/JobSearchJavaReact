package hrms.jobSearch.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.jobSearch.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer>{
	
	List<Skill> findAllByCandidateCv_Id(int candidateCvId);
	Skill findById(int skillId);


}
