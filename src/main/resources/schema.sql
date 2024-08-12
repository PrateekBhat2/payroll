CREATE TABLE IF NOT EXISTS `payroll`(
    `employee_id` INT NOT NULL,
    `transaction_id` LONG PRIMARY KEY,
    `payroll_date` VARCHAR(10) NOT NULL,
    `final_amount` LONG NOT NULL
);