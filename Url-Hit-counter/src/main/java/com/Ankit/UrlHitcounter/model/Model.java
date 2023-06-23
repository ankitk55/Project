package com.Ankit.UrlHitcounter.model;

import org.springframework.stereotype.Component;

@Component
public class Model {

    private String username;
    private Integer hit;

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
