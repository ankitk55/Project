package com.Ankit.University.Event.Management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Event {
    @Id
   private Integer eventId;
   private String eventName;
    private  String locationOfEvent;
    private LocalDate eventDate;
    private LocalTime eventStartTime;
    private LocalTime eventEndTime;
}
