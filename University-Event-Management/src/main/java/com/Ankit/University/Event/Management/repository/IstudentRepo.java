package com.Ankit.University.Event.Management.repository;

import com.Ankit.University.Event.Management.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IstudentRepo extends CrudRepository<Student,Integer> {
}
