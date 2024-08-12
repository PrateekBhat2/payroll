package com.ukg.payroll.dto;

import lombok.*;

@Getter
@Setter @NoArgsConstructor @AllArgsConstructor
public class PayrollDto {
    private Long transactionId;
    private Long employeeId;
    private String payrollDate;
    private Long finalAmount;
}
