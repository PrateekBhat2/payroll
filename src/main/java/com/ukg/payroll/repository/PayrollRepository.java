package com.ukg.payroll.repository;

import com.ukg.payroll.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll,Long> {
    List<Payroll> findByEmployeeId(Long employeeId);
    Optional<Payroll> findByTransactionId(Long transactionId);
}
