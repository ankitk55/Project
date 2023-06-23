package com.Ankit.UrlHitcounter.controller;

import com.Ankit.UrlHitcounter.model.Model;
import com.Ankit.UrlHitcounter.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    UrlHitService urlHitService;

    @GetMapping("count")
    public String count(){
        return urlHitService.count();
    }

    @GetMapping("username/{username}/count")
    public Model count(@PathVariable String username){
        return urlHitService.getcounter(username);
    }
}
