package com.ukg.payroll.controller;

import com.ukg.payroll.dto.PayrollDto;
import com.ukg.payroll.dto.ResponseDto;
import com.ukg.payroll.service.IPayrollService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PayrollController {
    private IPayrollService iPayrollService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createPayroll(@RequestBody PayrollDto payrollDto){
        iPayrollService.createPayroll(payrollDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("Successfully Created", HttpStatus.CREATED));
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<PayrollDto>> fetchPayrollDetails(@RequestParam Long employeeId){
        List<PayrollDto> payrollDtoList = iPayrollService.fetchDetails(employeeId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(payrollDtoList);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateDetails(@RequestBody PayrollDto payrollDto) {
        boolean isUpdated = iPayrollService.updateDetails(payrollDto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto("Updated successfully", HttpStatus.ACCEPTED));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto("Unable to update", HttpStatus.BAD_REQUEST));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccounts(@RequestParam Long transactionId){
        boolean isDeleted = iPayrollService.deletePayroll(transactionId);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto("Deleted successfully", HttpStatus.OK));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto("Unable to delete", HttpStatus.BAD_REQUEST));
        }
    }
}
