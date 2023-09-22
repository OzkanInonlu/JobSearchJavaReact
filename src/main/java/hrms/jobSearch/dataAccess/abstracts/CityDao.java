package hrms.jobSearch.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.jobSearch.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
	
	City findByName(String name);

}
