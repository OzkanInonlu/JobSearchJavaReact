package hrms.jobSearch.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.jobSearch.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
