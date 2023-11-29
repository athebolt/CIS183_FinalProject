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

    public Attendee(String u, String p)
    {
        username = u;
        password = p;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String u) {
        username = u;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String p) {
        password = p;
    }
}
