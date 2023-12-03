package com.example.cis183_djsongsearch;

import java.io.Serializable;

public class Event implements Serializable
{
    private String eventCode;
    private int djId;
    private String date;
    private String time;
    private String location;
    private String isPrivate;
    private String isActive;

    public Event()
    {

    }

    public Event(String c, int j, String d, String t, String l, String p, String a)
    {
        eventCode = c;
        djId = j;
        date = d;
        time = t;
        location = l;
        isPrivate = p;
        isActive = a;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String c) {
        eventCode = c;
    }

    public int getDjId() {
        return djId;
    }

    public void setDjId(int d) {
        djId = d;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String d) {
        date = d;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String t) {
        time = t;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String l) {
        location = l;
    }

    public String getPrivate() {
        return isPrivate;
    }

    public void setPrivate(String p) {
        isPrivate = p;
    }

    public String getActive() {
        return isActive;
    }

    public void setActive(String a) {
        isActive = a;
    }
}
