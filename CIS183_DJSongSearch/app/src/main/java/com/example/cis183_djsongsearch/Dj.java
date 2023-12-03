package com.example.cis183_djsongsearch;

import java.io.Serializable;
import java.util.ArrayList;


public class Dj implements Serializable
{
    private int djId;
    private String djName;
    private String password;

    public Dj(String n, String p)
    {
        djName = n;
        password = p;
    }

    public Dj(int i, String n, String p)
    {
        djId = i;
        djName = n;
        password = p;
    }

    public int getDjId()
    {
        return djId;
    }

    public void setDjId(int i)
    {
        djId = i;
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
