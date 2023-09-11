package com.Ankit.EmployeeManagementSystem.Model.dto.attendenceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttandenceDto {
    private LocalDate date;
    private Long employeeId;
    private String employeeName;
    private Boolean isPresent;
}




