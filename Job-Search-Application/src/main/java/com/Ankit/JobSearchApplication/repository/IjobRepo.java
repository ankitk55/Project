package com.Ankit.JobSearchApplication.repository;

import com.Ankit.JobSearchApplication.model.Job;
import com.Ankit.JobSearchApplication.model.JobType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;




@Repository
@Transactional
public interface IjobRepo extends CrudRepository<Job,Long> {

// Custom finders
    List<Job> findByJobType(JobType jobType);
    List<Job> findByCompanyName(String companyName);
    List<Job>findByLocation(String location);
    List<Job> findByTitle(String title);
    List<Job>findBySalaryGreaterThanAndSalaryLessThan(Double lsalary,Double usalary);

    //  CUSTOM QUERIES
    @Query(value = "select * from JOB",nativeQuery = true)
    List<Job> getAllJobs();
   @Modifying  // this is for Updation and DEletion Query.
    @Query(value = "update JOB set LOCATION = :location where ID=:id",nativeQuery = true)
    void updateLocationById(Long id,String location);

    @Modifying
    @Query(value = "delete from JOB where ID =:id",nativeQuery = true)
    void deleteJobById(Long id);
    @Modifying
    @Query(value = "update JOB set APPLIED_DATE  =:appliedDate where ID =:id",nativeQuery = true)
    void updateAppliedDateById(Long id , LocalDate appliedDate);


    @Modifying
    @Query(value = "update JOB set SALARY  =:salary where ID =:id",nativeQuery = true)
    void updateSalaryById(Long id , Double salary);
@Modifying
    @Query(value = "update JOB set DESCRIPTION   =:description where ID =:id",nativeQuery = true)
    void updateDescriptionById(Long id ,String description);
}
