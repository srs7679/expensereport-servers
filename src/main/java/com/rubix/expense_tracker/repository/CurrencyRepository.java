package com.rubix.expense_tracker.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubix.expense_tracker.model.Currency;


@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    List<Currency> findByExpenseId(Long expenseId);
    Optional<Currency> findByIdAndExpenseId(Long id, Long expenseId);
	Currency findByCodeAndExpenseId(String code, Long expenseId);
}
