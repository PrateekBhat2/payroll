package com.ukg.payroll.service.clients;

import com.ukg.payroll.dto.SalaryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("salary")
public interface SalaryFeignClient {
    @GetMapping("/fetch-salary")
    public ResponseEntity<SalaryDto> fetchSalaryDetails(@RequestParam long empId, String dateFrom, String dateTo);
}
