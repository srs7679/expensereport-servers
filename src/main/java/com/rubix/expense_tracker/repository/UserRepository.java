package com.rubix.expense_tracker.repository;




import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rubix.expense_tracker.model.User;
import org.springframework.data.jpa.repository.Query;

/* The UserRepository  is used as a interface
 *  where JpaRepository is extended which helps to use CRUD operations  */

/**
 * @author  handles the repository 
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByEmail(String email);
//  @Query(value = "delete  from t_user_roles where users_id= :user_id", nativeQuery = true)
//  void deleteRelation(@Param("user_id") Long user_id);
//  @Query("from User where id= :id")
// User  findByUserId(@Param("id") Long id);
  @Query(value = "select * from t_user", nativeQuery = true)
  List<User> findAllByUserId();
	

}