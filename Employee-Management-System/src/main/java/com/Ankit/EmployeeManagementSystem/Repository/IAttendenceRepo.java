package com.Ankit.EmployeeManagementSystem.Repository;

import com.Ankit.EmployeeManagementSystem.Model.Attendence;
import com.Ankit.EmployeeManagementSystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IAttendenceRepo extends JpaRepository<Attendence,Long> {
   public  List<Attendence> findByEmployeeAndDateBetween(Employee employee1, LocalDate start, LocalDate end);

   List<Attendence> findByDate(LocalDate date);

   List<Attendence> findByEmployee(Employee employee1);
}
