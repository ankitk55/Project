package com.Ankit.EmployeeManagementSystem.Model.dto.attendenceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class GetAttandenceDto {
    private LocalDateTime reportGeneratedOn=LocalDateTime.now();
    private String message;
    private Integer totalWorkingDays;
    private Integer totalPresent;
    private Integer totalAbsent;
    private List<AttandenceDto> attandenceList;

}
