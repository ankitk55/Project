package org.ankit;

import org.springframework.beans.factory.annotation.Autowired;

public class car  {
    private String color;
    private Integer speed;
    private String type;



    public car(String color, Integer speed, String type) {
        this.color = color;
        this.speed = speed;
        this.type = type;
    }

    public car(String color, Integer speed) {
        this.color = color;
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "car{" +
                "color='" + color + '\'' +
                ", speed=" + speed +
                ", type='" + type + '\'' +
                '}';
    }



}
