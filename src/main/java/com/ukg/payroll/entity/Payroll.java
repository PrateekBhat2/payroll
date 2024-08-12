package com.ukg.payroll.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payroll")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Payroll extends BaseEntity{
    @Id
    private Long transactionId;
    private Long employeeId;
    private String payrollDate;
    private Long finalAmount;
}
