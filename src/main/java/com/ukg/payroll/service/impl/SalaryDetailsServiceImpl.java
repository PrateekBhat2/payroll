package com.ukg.payroll.service.impl;

import com.ukg.payroll.dto.PayrollDetailsDto;
import com.ukg.payroll.dto.SalaryDto;
import com.ukg.payroll.entity.Payroll;
import com.ukg.payroll.exceptions.PayrollNotExistsException;
import com.ukg.payroll.mapper.PayrollMapper;
import com.ukg.payroll.repository.PayrollRepository;
import com.ukg.payroll.service.ISalaryDetailsService;
import com.ukg.payroll.service.clients.SalaryFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SalaryDetailsServiceImpl implements ISalaryDetailsService {
    private PayrollRepository payrollRepository;
    private SalaryFeignClient salaryFeignClient;

    public List<PayrollDetailsDto> fetchSalaryDetails(long employeeId, String From, String To) {
        List<Payroll> payrollList = payrollRepository.findByEmployeeId(employeeId);
        if (payrollList.isEmpty()) {
            throw new PayrollNotExistsException("No payroll exists");
        }
        List<PayrollDetailsDto> payrollDetailsDtoList = new ArrayList<>();
        for (int i = 0; i < payrollList.size(); i++) {
            PayrollDetailsDto payrollDetailsDto = PayrollMapper.mapToPayrollDetailsDto(payrollList.get(i), new PayrollDetailsDto());
            payrollDetailsDtoList.add(payrollDetailsDto);
        }

        for (int i = 0; i < payrollDetailsDtoList.size(); i++) {
            ResponseEntity<SalaryDto> salaryDtoResponseEntity = salaryFeignClient.fetchSalaryDetails(employeeId, From, To);
            payrollDetailsDtoList.get(i).setSalaryDto(salaryDtoResponseEntity.getBody());
        }

        return payrollDetailsDtoList;
    }
}
