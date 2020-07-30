package com.rubix.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.expense_tracker.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
