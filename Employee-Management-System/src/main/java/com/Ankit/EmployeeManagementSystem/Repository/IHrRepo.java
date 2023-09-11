package com.Ankit.EmployeeManagementSystem.Repository;

import com.Ankit.EmployeeManagementSystem.Model.HR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHrRepo extends JpaRepository<HR,Long> {
  public   HR findByHrEmail(String hrEmail);
}
