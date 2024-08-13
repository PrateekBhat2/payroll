package com.ukg.payroll.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payroll")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Payroll extends BaseEntity{
    @Id
    @NotNull(message = "transactionId cannot be null")
    private Long transactionId;

    @NotNull(message = "employeeId cannot be null")
    private Long employeeId;

    private String payrollDate;

    @PositiveOrZero
    private Long finalAmount;
}
