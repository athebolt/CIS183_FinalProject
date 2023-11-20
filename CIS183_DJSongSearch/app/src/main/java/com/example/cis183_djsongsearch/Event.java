package com.example.cis183_djsongsearch;

public class Event
{
    private String eventCode;
    private String dj;
    private String date;
    private String time;
    private String location;
    private String isPrivate;

    public Event()
    {

    }

    public Event(String c, String j, String d, String t, String l, String p)
    {
        eventCode = c;
        dj = j;
        date = d;
        time = t;
        location = l;
        isPrivate = p;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String c) {
        eventCode = c;
    }

    public String getDj() {
        return dj;
    }

    public void setDj(String d) {
        dj = d;
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


}
