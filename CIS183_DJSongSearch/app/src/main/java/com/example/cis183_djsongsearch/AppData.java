package com.example.cis183_djsongsearch;

import java.util.ArrayList;

public class AppData
{
    private static Dj user;
    private static Attendee curAttendee;
    private static Event curEvent;
    private static Song curSong;
    private static ArrayList<Song> reqSongs;

    public static Dj getUser() {
        return user;
    }
    public static void setUser(Dj u) {
        user = u;
    }
    public static Attendee getCurAttendee()
    {
        return curAttendee;
    }
    public static void setCurAttendee(Attendee a)
    {
        curAttendee = a;
    }
    public static Event getCurEvent() {
        return curEvent;
    }
    public static void setCurEvent(Event e) {
        curEvent = e;
    }
    public static Song getCurSong() {
        return curSong;
    }
    public static void setCurSong(Song s) {
        curSong = s;
    }
    public static void initReqSongs()
    {
        reqSongs = new ArrayList<Song>();
    }
    public static void addReqSong(Song s)
    {
        reqSongs.add(s);
    }
    public static void removeReqSong(int i)
    {
        reqSongs.remove(i);
    }
    public static ArrayList<Song> getReqSongs()
    {
        return reqSongs;
    }
}
