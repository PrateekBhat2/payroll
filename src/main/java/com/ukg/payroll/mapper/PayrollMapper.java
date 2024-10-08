package com.ukg.payroll.mapper;

import com.ukg.payroll.dto.PayrollDetailsDto;
import com.ukg.payroll.dto.PayrollDto;
import com.ukg.payroll.entity.Payroll;

public class PayrollMapper {
    public static Payroll mapToPayroll(PayrollDto payrollDto, Payroll payroll){
        payroll.setTransactionId(payrollDto.getTransactionId());
        payroll.setEmployeeId(payrollDto.getEmployeeId());
        payroll.setPayrollDate(payrollDto.getPayrollDate());
        payroll.setFinalAmount(payrollDto.getFinalAmount());
        return payroll;
    }

    public static PayrollDto mapToPayrollDto(Payroll payroll, PayrollDto payrollDto){
        payrollDto.setTransactionId(payroll.getTransactionId());
        payrollDto.setEmployeeId(payroll.getEmployeeId());
        payrollDto.setPayrollDate(payroll.getPayrollDate());
        payrollDto.setFinalAmount(payroll.getFinalAmount());
        return payrollDto;
    }

    public static PayrollDetailsDto mapToPayrollDetailsDto(Payroll payroll, PayrollDetailsDto payrollDetailsDto){
        payrollDetailsDto.setTransactionId(payroll.getTransactionId());
        payrollDetailsDto.setEmployeeId(payroll.getEmployeeId());
        payrollDetailsDto.setPayrollDate(payroll.getPayrollDate());
        payrollDetailsDto.setFinalAmount(payroll.getFinalAmount());
        return payrollDetailsDto;
    }
}
