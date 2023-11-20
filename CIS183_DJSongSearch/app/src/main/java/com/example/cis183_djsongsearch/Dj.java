package com.example.cis183_djsongsearch;

import java.util.ArrayList;

public class Dj
{
    private String id;
    private String djName;
    private final ArrayList<Song> songLibrary;
    private final ArrayList<Event> events;

    public Dj(String i, String n, ArrayList<Song> l, ArrayList<Event> e)
    {
        id = i;
        djName = n;
        songLibrary = l;
        events = e;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String i)
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

    public void addSong(Song s)
    {
        songLibrary.add(s);
    }

    public void removeSong(Song s)
    {
        songLibrary.remove(s);
    }

    public void addEvent(Event e)
    {
        events.add(e);
    }

    public void removeEvent(Event e)
    {
        events.remove(e);
    }
}
