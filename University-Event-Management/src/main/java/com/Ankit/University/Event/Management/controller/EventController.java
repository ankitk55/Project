package com.Ankit.University.Event.Management.controller;

import com.Ankit.University.Event.Management.model.Event;
import com.Ankit.University.Event.Management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventService eventService;
    @GetMapping("events/date/{date}")
    public List<Event> getAllEventsByDate(@PathVariable LocalDate date){
        return eventService.getaAllEventsByDate(date);
    }
    @PostMapping("event")
    public String addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }
    @DeleteMapping("event/{id}")
    public String deleteEventById(@PathVariable Integer id){
        return eventService.deleteEventById(id);
    }
    @PutMapping("event/{id}")
    public String updateEventById(@PathVariable Integer id,@RequestParam String eventName, @RequestParam String locationOfEvent,@RequestParam LocalDate eventDate,@RequestParam LocalTime eventStartTime, @RequestParam LocalTime eventEndTime){
        return eventService.updateEventById(id,eventName,locationOfEvent,eventDate,eventStartTime,eventEndTime);
    }
}
