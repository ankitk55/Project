package com.Ankit.Restaurant_Management_Service_API.repository;

import com.Ankit.Restaurant_Management_Service_API.model.Admin;
import com.Ankit.Restaurant_Management_Service_API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Long> {
    Admin findFirstByAdminEmail(String newEmail);
}
