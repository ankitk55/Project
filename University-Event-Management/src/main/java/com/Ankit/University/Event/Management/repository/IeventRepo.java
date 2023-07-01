package com.Ankit.University.Event.Management.repository;

import com.Ankit.University.Event.Management.model.Event;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IeventRepo extends CrudRepository<Event, Integer> {

    //Custom finders
    List<Event> findByEventDate(LocalDate eventDate);
}
