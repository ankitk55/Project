package com.Ankit.EmployeeManagementSystem.Service;

import com.Ankit.EmployeeManagementSystem.Model.Attendence;
import com.Ankit.EmployeeManagementSystem.Model.Employee;
import com.Ankit.EmployeeManagementSystem.Model.dto.attendenceDto.AttandenceDto;
import com.Ankit.EmployeeManagementSystem.Model.dto.attendenceDto.GetAttandenceDto;
import com.Ankit.EmployeeManagementSystem.Repository.IAttendenceRepo;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttendenceService {
    @Autowired
    private IAttendenceRepo attendenceRepo;
    @Autowired
    GetAttandenceDto getAttandenceDto;
    public ResponseEntity<String> addAttandence(Employee employee1, Attendence attendence) {
        List<Attendence> ats =attendenceRepo.findByDate(attendence.getDate());
        if(ats.size()!= 0){
            return new ResponseEntity<>("Attendence already added.. ", HttpStatus.ACCEPTED);
        }
        attendence.setEmployee(employee1);
        attendenceRepo.save(attendence);
        return new ResponseEntity<>("Attendence added.. ", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<GetAttandenceDto> getAttendence(Employee employee1, Integer monthh, Integer year,List<AttandenceDto> attandenceDtos) {
        YearMonth month =YearMonth.of(year,monthh);
        LocalDate start=month.atDay(1);
        LocalDate  end =month.atEndOfMonth();
        List<Attendence>attendenceLis =attendenceRepo.findByEmployeeAndDateBetween(employee1,start,end);
        if(attendenceLis.size()==0){
            getAttandenceDto.setMessage("Attandence Record not available of Emoployee "+employee1.getEmployeeName());
            getAttandenceDto.setTotalAbsent(0);
          getAttandenceDto.setTotalWorkingDays(0);
            getAttandenceDto.setTotalPresent(0);
            getAttandenceDto.setAttandenceList(null);

            return new ResponseEntity<>(getAttandenceDto,HttpStatus.NOT_FOUND);
        }

        for(Attendence ats:attendenceLis){
            AttandenceDto attandenceDto =new AttandenceDto(ats.getDate(),ats.getEmployee().getEmployee_id(),
                    ats.getEmployee().getEmployeeName(),ats.getPesentStatus());
            attandenceDtos.add(attandenceDto);
        }

        int totaldays =attendenceLis.size();
        int totalPresent=0;
        int totalAbsent =0;
        for(Attendence attendence :attendenceLis){
            if(attendence.getPesentStatus()){
                totalPresent++;
            }
            else{
                totalAbsent++;
            }
        }
        getAttandenceDto.setMessage("Attendence Record of "+employee1.getEmployeeName());
        getAttandenceDto.setTotalAbsent(totalAbsent);
        getAttandenceDto.setTotalPresent(totalPresent);
        getAttandenceDto.setTotalWorkingDays(totaldays);
        getAttandenceDto.setAttandenceList(attandenceDtos);

        return  ResponseEntity.ok(getAttandenceDto);
    }

    public void deleteAttandence(Employee employee1) {
        List<Attendence>allAttendence =attendenceRepo.findByEmployee(employee1);
        List<Long>attandenceIds =new ArrayList<>();
        for(Attendence ats : allAttendence){
            attandenceIds.add(ats.getId());
        }
        attendenceRepo.deleteAllByIdInBatch(attandenceIds);
    }
}
