package com.Ankit.DoctorSearchingApp.model.dto;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.Ankit.DoctorSearchingApp.model.dto.Speciality.*;

@Component
public class SpecialitYvsSymptons {
    public Map<Speciality,String []> symptomsList(){
        Map<Speciality, String []> symptom =new HashMap<>();
        symptom.put(Orthopedic,new String []{"arthritis","back_pain","tissue_injuries"});
        symptom.put(Gynecology,new String []{"dysmenorrbea"});
        symptom.put(Dermatology,new String []{"skin_infection","skin_burn"});
        symptom.put(ENT,new String [] {"ear_pain","eye_pain"});
        return symptom;
    }


}
