package com.Ankit.University.Event.Management.service;

import com.Ankit.University.Event.Management.model.Event;
import com.Ankit.University.Event.Management.repository.IeventRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    IeventRepo eventRepo;

    public List<Event> getaAllEventsByDate(LocalDate date){
       return  eventRepo.findByEventDate(date);
    }
    public String addEvent(Event event){
        eventRepo.save(event);
        return "Event Added ..";
    }
    public String updateEventById(Integer id, String eventName, String locationOfEvent, LocalDate eventDate, LocalTime eventStartTime,LocalTime eventEndTime) {
        Optional<Event> eventOpt = eventRepo.findById(id);
        Event myEvent = null;
        if (eventOpt.isPresent()) {
            myEvent = eventOpt.get();
        } else {
            return "id not found ...";
        }
        myEvent.setEventName(eventName);
        myEvent.setLocationOfEvent(locationOfEvent);
        myEvent.setEventDate(eventDate);
        myEvent.setEventStartTime(eventStartTime);
        myEvent.setEventEndTime(eventEndTime);

        eventRepo.save(myEvent);
        return "Event Updated.. ";
    }
    public String deleteEventById(Integer id){
        eventRepo.deleteById(id);
        return "Event deleted for id : "+id;
    }


}
