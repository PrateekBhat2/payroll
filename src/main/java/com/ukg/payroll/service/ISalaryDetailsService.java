package com.ukg.payroll.service;

import com.ukg.payroll.dto.PayrollDetailsDto;

import java.util.List;

public interface ISalaryDetailsService {
    List<PayrollDetailsDto> fetchSalaryDetails(long empId, String dateFrom, String dateTo);
}
