package com.rubix.expense_tracker.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.expense_tracker.model.ExpenseCurrency;


@Repository
public interface ExpenseCurrencyRepository extends JpaRepository<ExpenseCurrency, Long> {
    List<ExpenseCurrency> findByEmployeeId(Long employeeId);
    Optional<ExpenseCurrency> findByIdAndEmployeeId(Long id, Long employeeId);
	ExpenseCurrency findByCurrencyAndEmployeeId(String currency, Long employeeId);
}
