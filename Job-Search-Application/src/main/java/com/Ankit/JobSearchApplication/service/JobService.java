package com.Ankit.JobSearchApplication.service;

import com.Ankit.JobSearchApplication.model.Job;
import com.Ankit.JobSearchApplication.model.JobType;
import com.Ankit.JobSearchApplication.repository.IjobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    IjobRepo jobRepo;

    public String addJobList(List<Job> jobList){            // CRUD REPO
        jobRepo.saveAll(jobList);
        return "jobs Added ..";
    }
    public String addJob(Job job){                       //<--  CRUD REPO
        jobRepo.save(job);
        return "job Added ..";
    }
    public Optional<Job> findJobById(Long id){              // CRUD REPO
        return jobRepo.findById(id);
    }
    public List<Job>findByJobType(JobType jobType){         //CUSTOM FINDERS
        return jobRepo.findByJobType(jobType);
    }
    public List<Job>findByCompanyName(String companyName){       //CUSTOM FINDERS
        return jobRepo.findByCompanyName(companyName);
    }
    public List<Job>findByLocation(String location){         //CUSTOM FINDERS
        return jobRepo.findByLocation(location);
    }
    public List<Job> findByTitle(String title){              //CUSTOM FINDERS
        return jobRepo.findByTitle(title);
    }
    public List<Job> findBySalaryLessThan(Double lSalary,Double uSalary){            //CUSTOM FINDERS
        return jobRepo.findBySalaryGreaterThanAndSalaryLessThan(lSalary,uSalary);
    }
    public String updateLocationById(Long id,String location){              //CUSTOM QUERY
         jobRepo.updateLocationById(id,location);
         return "Location updated ..";
    }
    public List<Job>getAllJobs(){                             //CUSTOM QUERY
        return jobRepo.getAllJobs();
    }
    public String deleteJobById(Long id){                         //CUSTOM QUERY
        jobRepo.deleteJobById(id);
        return "Job Deleted ...";
    }
    public String updateAppliedDateById(Long id, LocalDate appliedDate){              //CUSTOM QUERY
        jobRepo.updateAppliedDateById(id,appliedDate);
        return "Applied Date Updated ...";
    }

    public String updateSalaryById(Long id, Double salary){               //CUSTOM QUERY
        jobRepo.updateSalaryById(id,salary);
        return "Salary Changed for id : "+id;
    }

    public String updateDescriptionById(Long id ,String description){             //CUSTOM QUERY
        jobRepo.updateDescriptionById(id, description);
        return "Job description changed for id : "+id;
    }
}
