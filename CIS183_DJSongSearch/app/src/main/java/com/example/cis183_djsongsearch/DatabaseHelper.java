package com.example.cis183_djsongsearch;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "SongSearch.db";
    private static final String DJ_TABLE = "Djs";
    private static final String EVENT_TABLE = "Events";
    private static final String ATTENDEE_TABLE = "Attendees";
    private static final String SONG_TABLE = "Songs";

    private static final String DJ_PRIMARY = "id";
    private static final String EVENT_PRIMARY = "eventCode";
    private static final String ATTENDEE_PRIMARY = "username";
    private static final String SONG_PRIMARY = "id";
    public DatabaseHelper(Context context)
    {
        //creates database
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //Tables: Dj, Event, Attendee, Song

        //Dj - id (primary), djName, songLibrary, events
        //Event - eventCode (primary), dj, date, time, location, isPrivate
        //Attendee - username (primary), password
        //Song - id (primary), name, artist, isExplicit, duration

        db.execSQL("CREATE TABLE " + DJ_TABLE + " ( id TEXT PRIMARY KEY NOT NULL, djName TEXT);");
        db.execSQL("CREATE TABLE " + EVENT_TABLE + " ( eventCode TEXT PRIMARY KEY NOT NULL, dj TEXT, date TEXT, time TEXT, location TEXT, isPrivate TEXT);");
        db.execSQL("CREATE TABLE " + ATTENDEE_TABLE + " (username TEXT PRIMARY KEY NOT NULL, password TEXT)");
        db.execSQL("CREATE TABLE " + SONG_TABLE + " (id TEXT PRIMARY KEY NOT NULL, name TEXT, artist TEXT, isExplicit TEXT, duration TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        //for db change

        //deletes tables
        db.execSQL("DROP TABLE IF EXISTS " + DJ_TABLE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + EVENT_TABLE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + ATTENDEE_TABLE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + SONG_TABLE + ";");

        //creates replacement table
        onCreate(db);
    }

    public void initializeDB()
    {
        //make sure all tables some sort of info in them

        if(numOfRowsInDJTable() == 0)
        {
            //write to db
            SQLiteDatabase db = this.getWritableDatabase();

            //sample entry
            db.execSQL("INSERT INTO " + DJ_TABLE + " VALUES('0','Test');");

            //close db
            db.close();
        }

        if(numOfRowsInEventTable() == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + EVENT_TABLE + " VALUES('0','Test','10/10/10','10:10','Monroe, MI','true');");

            db.close();
        }

        if(numOfRowsInAttendeeTable() == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + ATTENDEE_TABLE + " VALUES('sample', 'password');");

            db.close();
        }

        if(numOfRowsInSongTable() == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + ATTENDEE_TABLE + " VALUES('0','Sample','Test','false','1:00');");

            db.close();
        }
    }

    public int numOfRowsInDJTable()
    {
        //get a readable instance of database
        SQLiteDatabase db = this.getReadableDatabase();

        //count the number of rows in the database and store the number
        int numRows = (int) DatabaseUtils.queryNumEntries(db, DJ_TABLE);

        //close it
        db.close();

        //return number of rows
        return numRows;
    }

    public int numOfRowsInEventTable()
    {
        //get a readable instance of database
        SQLiteDatabase db = this.getReadableDatabase();

        //count the number of rows in the database and store the number
        int numRows = (int) DatabaseUtils.queryNumEntries(db, EVENT_TABLE);

        //close it
        db.close();

        //return number of rows
        return numRows;
    }

    public int numOfRowsInAttendeeTable()
    {
        //get a readable instance of database
        SQLiteDatabase db = this.getReadableDatabase();

        //count the number of rows in the database and store the number
        int numRows = (int) DatabaseUtils.queryNumEntries(db, ATTENDEE_TABLE);

        //close it
        db.close();

        //return number of rows
        return numRows;
    }

    public int numOfRowsInSongTable()
    {
        //get a readable instance of database
        SQLiteDatabase db = this.getReadableDatabase();

        //count the number of rows in the database and store the number
        int numRows = (int) DatabaseUtils.queryNumEntries(db, SONG_TABLE);

        //close it
        db.close();

        //return number of rows
        return numRows;
    }

    public void addNewDJ(Dj dj)
    {
        //write to db
        SQLiteDatabase db = this.getWritableDatabase();

        //insert dj
        //INSERT INTO DJ_TABLE VALUES('id','djName');
        db.execSQL("INSERT INTO " + DJ_TABLE + " VALUES('" + dj.getId() + "','" + dj.getDjName() + "');");

        //close
        db.close();
    }

    public void addNewEvent(Event e)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //INSERT INTO EVENT_TABLE VALUES('eventCode','dj','date','time','location','isPrivate');
        db.execSQL("INSERT INTO " + EVENT_TABLE + " VALUES('" + e.getEventCode() + "','" + e.getDj() + "','" + e.getDate() + "','" + e.getTime() + "','" + e.getLocation() + "','" + e.getPrivate() + "');");

        db.close();
    }

    public void addNewAttendee(Attendee a)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //INSERT INTO ATTENDEE_TABLE VALUES('username','password');
        db.execSQL("INSERT INTO " + ATTENDEE_TABLE + " VALUES('" + a.getUsername() + "','" + a.getPassword() + "');");

        db.close();
    }

    public void addNewSong(Song s)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //INSERT INTO SONG_TABLE VALUES('id','name','artist','isExplicit','duration');
        db.execSQL("INSERT INTO " + SONG_TABLE + " VALUES('" + s.getId() + "','" + s.getName() + "','" + s.getArtist() + "','" + s.getExplicit() + "','" + s.getDuration() + "');");

        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<Dj> getAllDjs()
    {
        //stores info the table returns
        ArrayList<Dj> listDjs = new ArrayList<Dj>();

        //reading db
        SQLiteDatabase db = this.getReadableDatabase();

        //query to get all rows and attributes
        Cursor cursor = db.rawQuery("SELECT * FROM " + DJ_TABLE + " ORDER BY " + DJ_PRIMARY + ";", null);

        //variables to store info
        String id;
        String djName;

        //move to first
        if(cursor.moveToFirst())
        {
            do
            {
                id = cursor.getString(cursor.getColumnIndex("id"));
                djName = cursor.getString(cursor.getColumnIndex("djName"));

                //listDjs.add(new Dj(id, djName));
            }
            while(cursor.moveToNext());
        }

        db.close();

        //return Djs
        return listDjs;
    }

    @SuppressLint("Range")
    public ArrayList<Event> getAllEvents()
    {
        ArrayList<Event> listEvents = new ArrayList<Event>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + EVENT_TABLE + " ORDER BY " + EVENT_PRIMARY + ";", null);

        String eventCode;
        String dj;
        String date;
        String time;
        String location;
        String isPrivate;

        if(cursor.moveToFirst())
        {
            do
            {
                eventCode = cursor.getString(cursor.getColumnIndex("eventCode"));
                dj = cursor.getString(cursor.getColumnIndex("dj"));
                date = cursor.getString(cursor.getColumnIndex("date"));
                time = cursor.getString(cursor.getColumnIndex("time"));
                location = cursor.getString(cursor.getColumnIndex("location"));
                isPrivate = cursor.getString(cursor.getColumnIndex("isPrivate"));

                listEvents.add(new Event(eventCode, dj, date, time, location, isPrivate));
            }
            while(cursor.moveToNext());
        }

        db.close();

        return listEvents;
    }

    @SuppressLint("Range")
    private ArrayList<Attendee> getAllAttendees()
    {
        ArrayList<Attendee> listAttendees = new ArrayList<Attendee>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + ATTENDEE_TABLE + " ORDER BY " + ATTENDEE_PRIMARY + ";", null);

        String username;
        String password;

        if(cursor.moveToFirst())
        {
            do
            {
                username = cursor.getString(cursor.getColumnIndex("username"));
                password = cursor.getString(cursor.getColumnIndex("password"));

                listAttendees.add(new Attendee(username, password));
            }
            while(cursor.moveToNext());
        }

        db.close();

        return listAttendees;
    }

    @SuppressLint("Range")
    private ArrayList<Song> getAllSongs()
    {
        ArrayList<Song> listSongs = new ArrayList<Song>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + SONG_TABLE + " ORDER BY " + SONG_PRIMARY + ";", null);

        String id;
        String name;
        String artist;
        String isExplicit;
        String duration;

        if(cursor.moveToFirst())
        {
            do
            {
                id = cursor.getString(cursor.getColumnIndex("id"));
                name = cursor.getString(cursor.getColumnIndex("name"));
                artist = cursor.getString(cursor.getColumnIndex("artist"));
                isExplicit = cursor.getString(cursor.getColumnIndex("isExplicit"));
                duration = cursor.getString(cursor.getColumnIndex("duration"));

                listSongs.add(new Song(id, name, artist, isExplicit, duration));
            }
            while(cursor.moveToNext());
        }

        db.close();

        return listSongs;
    }

}
