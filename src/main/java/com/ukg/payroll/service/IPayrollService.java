package com.ukg.payroll.service;

import com.ukg.payroll.dto.PayrollDto;

import java.util.List;

public interface IPayrollService {
    void createPayroll(PayrollDto payrollDto);

    List<PayrollDto> fetchDetails(Long employeeId);

    boolean updateDetails(PayrollDto payrollDto);

    boolean deletePayroll(Long transactionId);
}
