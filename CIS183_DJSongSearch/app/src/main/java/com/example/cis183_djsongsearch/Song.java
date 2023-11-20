package com.example.cis183_djsongsearch;

public class Song
{
    private String id;
    private String name;
    private String artist;
    private String isExplicit;
    private String duration;

    public Song()
    {

    }
    public Song(String i, String n, String a, String e, String d)
    {
        id = i;
        name = n;
        artist = a;
        isExplicit = e;
        duration = d;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String i)
    {
        id = i;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String a)
    {
        artist = a;
    }

    public String getExplicit()
    {
        return isExplicit;
    }

    public void setExplicit(String e)
    {
        isExplicit = e;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String d)
    {
        duration = d;
    }
}
