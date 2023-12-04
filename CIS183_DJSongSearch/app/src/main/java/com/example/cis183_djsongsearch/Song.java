package com.example.cis183_djsongsearch;

import java.io.Serializable;

public class Song implements Serializable
{
    private String songId;
    private String songName;
    private String artist;
    private String isExplicit;
    private String duration;
    private int djId;

    public Song()
    {

    }
    public Song(String i, String n, String a, String e, String d, int j)
    {
        songId = i;
        songName = n;
        artist = a;
        isExplicit = e;
        duration = d;
        djId = j;
    }

    public String getSongId()
    {
        return songId;
    }

    public void setSongId(String i)
    {
        songId = i;
    }

    public String getSongName()
    {
        return songName;
    }

    public void setSongName(String n)
    {
        songName= n;
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
    public int getDjId()
    {
        return djId;
    }

    public void setDjId(int i)
    {
        djId = i;
    }
}
