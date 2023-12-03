package com.example.cis183_djsongsearch;

public class Attendee
{
    private String username;
    private String fName;
    private String lName;
    private String password;
    private String eventCode;

    public Attendee()
    {

    }

    public Attendee(String u, String f, String l, String p)
    {
        username = u;
        fName = f;
        lName = l;
        password = p;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String u) {
        username = u;
    }

    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String f) {
        fName = f;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String l) {
        lName = l;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String p) {
        password = p;
    }
    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String e) {
        eventCode = e;
    }

}
