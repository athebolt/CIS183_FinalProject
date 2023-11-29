package com.example.cis183_djsongsearch;

import java.util.ArrayList;

public class Dj
{
    private int id;
    private String djName;
    private String password;

    public Dj(int i, String n, String p)
    {
        id = i;
        djName = n;
        password = p;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int i)
    {
        id = i;
    }

    public String getDjName()
    {
        return djName;
    }

    public void setDjName(String n)
    {
        djName = n;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String p)
    {
        password = p;
    }
}
