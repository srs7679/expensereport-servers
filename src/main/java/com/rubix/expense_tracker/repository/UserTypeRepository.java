package com.rubix.expense_tracker.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rubix.expense_tracker.model.UserType;

import java.util.Optional;
/**
 * @author  handles the repository 
 *
 */
@Repository
public interface UserTypeRepository extends JpaRepository<UserType,Integer>{

	Optional<UserType> findByName(String name);
	

}