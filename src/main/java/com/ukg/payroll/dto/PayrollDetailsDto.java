package com.ukg.payroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayrollDetailsDto {
    private Long transactionId;
    private Long employeeId;
    private String payrollDate;
    private Long finalAmount;
    private SalaryDto salaryDto;
}
