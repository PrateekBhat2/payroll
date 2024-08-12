CREATE TABLE IF NOT EXISTS `payroll`(
    `employee_id` INT NOT NULL,
    `transaction_id` LONG PRIMARY KEY,
    `payroll_date` VARCHAR(10) NOT NULL,
    `final_amount` LONG NOT NULL,
    `created_at` DATE NOT NULL,
    `created_by` VARCHAR(30) NOT NULL,
    `updated_at` DATE DEFAULT NULL,
    `updated_by` VARCHAR(30) DEFAULT NULL
);