package com.Ankit.JobSearchApplication.controller;

import com.Ankit.JobSearchApplication.model.Job;
import com.Ankit.JobSearchApplication.model.JobType;
import com.Ankit.JobSearchApplication.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
public class JobController {
    @Autowired
    JobService jobService;
    @PostMapping("jobs")
    public String addJobList(@RequestBody List<Job> jobList){
        return jobService.addJobList(jobList);
    }
    @PostMapping("job")
    public String addJobList(@RequestBody Job job){
        return jobService.addJob(job);
    }
    @GetMapping("job/id/{id}")
    public Optional<Job> getJobById(@PathVariable Long id){
        return jobService.findJobById(id);
    }
    @GetMapping("jobs/type/{jobType}")
    public List<Job> getAllJobByJobType(@PathVariable JobType jobType){
        return jobService.findByJobType(jobType);
    }
    @GetMapping("jobs/company/{companyName}")
    public List<Job> getAllJobsByCompanyName(@PathVariable String companyName){
        return jobService.findByCompanyName(companyName);
    }
    @GetMapping("jobs/location/{location}")
    public List<Job>getAllJobsByLocation(@PathVariable String location){
        return jobService.findByLocation(location);
    }
    @GetMapping("jobs/jobTitle/{title}")
    public List<Job>getAllJobsByJobTitle(@PathVariable String title){
        return jobService.findByTitle(title);
    }
    @GetMapping("jobs/lSalary/{lSalary}/uSalary/{uSalary}")
    public List<Job>getAllJobBySalaryRange(@PathVariable Double lSalary,@PathVariable Double uSalary){
        return jobService.findBySalaryLessThan(lSalary,uSalary);
    }
    @PutMapping("job/id/{id}/location/{location}")
    public String updateLocationById(@PathVariable Long id, @PathVariable String location){
        return jobService.updateLocationById(id,location);
    }
    @GetMapping("jobs")
    public List<Job>getAllJobs(){
        return jobService.getAllJobs();
    }
    @DeleteMapping("job/id/{id}")
    public  String deleteJobById(@PathVariable Long id){
        return jobService.deleteJobById(id);
    }
    @PutMapping("job/id/{id}/appliedDate/{appliedDate}")
    public String updateAppliedDateById(@PathVariable Long id,@PathVariable LocalDate appliedDate){
        return jobService.updateAppliedDateById(id,appliedDate);
    }
    @PutMapping("job/id/{id}/salary/{salary}")
    public String updateSalaryById(@PathVariable Long id, @PathVariable Double salary){
       return jobService.updateSalaryById(id,salary);
    }

    @PutMapping("job/id/{id}/description/{description}")
    public String updateDescriptionById(@PathVariable Long id ,@PathVariable String description){
        return jobService.updateDescriptionById(id, description);
    }
}
