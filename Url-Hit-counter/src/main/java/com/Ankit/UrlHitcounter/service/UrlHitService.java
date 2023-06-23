package com.Ankit.UrlHitcounter.service;

import com.Ankit.UrlHitcounter.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrlHitService {
    @Autowired
    Model model;

    private Integer count =0;
    private Integer countt =0;

  public String count(){
      countt++;
      return "Visitors : "+countt;
  }

    public Model getcounter(String username){

        count++;
        model.setUsername(username);

        model.setHit(count);


        return model ;
    }

}
