package com.ukg.payroll.service.impl;

import com.ukg.payroll.dto.PayrollDto;
import com.ukg.payroll.entity.Payroll;
import com.ukg.payroll.exceptions.PayrollNotExistsException;
import com.ukg.payroll.mapper.PayrollMapper;
import com.ukg.payroll.repository.PayrollRepository;
import com.ukg.payroll.service.IPayrollService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PayrollServiceImpl implements IPayrollService {
    private PayrollRepository payrollRepository;

    @Override
    public void createPayroll(PayrollDto payrollDto){
        Payroll payroll = PayrollMapper.mapToPayroll(payrollDto,new Payroll());
        payrollRepository.save(payroll);
    }

    public List<PayrollDto> fetchDetails(Long employeeId){
        List<Payroll> payrollList = payrollRepository.findByEmployeeId(employeeId);
        if(payrollList.isEmpty()){
            throw new PayrollNotExistsException("No payroll exists");
        }
        List<PayrollDto> payrollDtoList = new ArrayList<>();
        for(int i = 0; i < payrollList.size(); i++){
            PayrollDto payrollDto = PayrollMapper.mapToPayrollDto(payrollList.get(i), new PayrollDto());
            payrollDtoList.add(payrollDto);
        }
        return payrollDtoList;
    }

    public boolean updateDetails(PayrollDto payrollDto){
        boolean isUpdated = false;

        Payroll payroll = payrollRepository.findByTransactionId(payrollDto.getTransactionId()).orElseThrow(
                () -> new PayrollNotExistsException("Payroll not found")
        );

        if (payroll != null) {
            PayrollMapper.mapToPayroll(payrollDto, payroll);

            payrollRepository.save(payroll);
            isUpdated = true;
        }

        return isUpdated;
    }

    public boolean deletePayroll(@RequestParam Long transactionId){
        boolean isDeleted = false;

        Payroll payroll = payrollRepository.findByTransactionId(transactionId).orElseThrow(
                () -> new PayrollNotExistsException("Payroll not found")
        );

        if (payroll != null) {

            payrollRepository.delete(payroll);
            isDeleted = true;
        }

        return isDeleted;
    }
}
