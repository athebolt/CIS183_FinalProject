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

    public DatabaseHelper(Context context)
    {
        //creates database
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //Tables: Dj, Event, Attendee, Song

        //Dj - djId int (primary) auto, djName text, password text
        //Event - eventCode text (primary) not null, djId int (foreign), date text, time text, location text, isPrivate text, isActive text
        //Attendee - username text (primary) not null, firstName text, lastName text, password text, eventCode text (foreign)
        //Song - SongId int (primary) auto, songName text, artist text, isExplicit text, duration text, djId int (foreign)

        db.execSQL("CREATE TABLE " + DJ_TABLE + "( djId INTEGER PRIMARY KEY AUTOINCREMENT, djName TEXT, password TEXT);");
        db.execSQL("CREATE TABLE " + EVENT_TABLE + " ( eventCode TEXT PRIMARY KEY NOT NULL, djId INTEGER, date TEXT, time TEXT, location TEXT, isPrivate TEXT, isActive TEXT, FOREIGN KEY (djId) REFERENCES " + DJ_TABLE + " (djId) );");
        db.execSQL("CREATE TABLE " + ATTENDEE_TABLE + " (username TEXT PRIMARY KEY NOT NULL, firstName TEXT, lastName TEXT, password TEXT, eventCode TEXT, FOREIGN KEY (eventCode) REFERENCES " + EVENT_TABLE + " (eventCode) );");
        db.execSQL("CREATE TABLE " + SONG_TABLE + " (songId INTEGER PRIMARY KEY AUTOINCREMENT, songName TEXT, artist TEXT, isExplicit TEXT, duration TEXT, djId INTEGER, FOREIGN KEY (djId) REFERENCES " + DJ_TABLE + " (djId) );");
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
            db.execSQL("INSERT INTO " + DJ_TABLE + " (djName, password) VALUES('Test','password');");

            //close db
            db.close();
        }

        if(numOfRowsInEventTable() == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + EVENT_TABLE + " VALUES('0','1','12/10/2023','10:10','Monroe, MI','false','true');");

            db.close();
        }

        if(numOfRowsInAttendeeTable() == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + ATTENDEE_TABLE + " (username, firstName, lastName, password) VALUES('ssample','sally','sample','password');");

            db.close();
        }

        if(numOfRowsInSongTable() == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + SONG_TABLE + " (songName, artist, isExplicit, duration, djId) VALUES('Sample','Test','false','1:00','1');");

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
        //INSERT INTO DJ_TABLE VALUES('djName','password');
        db.execSQL("INSERT INTO " + DJ_TABLE + " (djName, password) VALUES('" + dj.getDjName() + "','" + dj.getPassword() + "');");

        //close
        db.close();
    }

    public void addNewEvent(Event e)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //INSERT INTO EVENT_TABLE (eventCode, djId, date, time, location, isPrivate, isActive) VALUES('eventCode','djId','date','time','location','isPrivate','false');
        db.execSQL("INSERT INTO " + EVENT_TABLE + " VALUES('" + e.getEventCode() + "','" + e.getDjId() + "','" + e.getDate() + "','" + e.getTime() + "','" + e.getLocation() + "','" + e.getPrivate() + "','false');");

        db.close();
    }

    public void addNewAttendee(Attendee a)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //INSERT INTO ATTENDEE_TABLE VALUES('username','password');
        db.execSQL("INSERT INTO " + ATTENDEE_TABLE + " (username, firstName, lastName, password) VALUES('" + a.getUsername() + "','" + a.getFirstName() + "','" + a.getLastName() + "','" + a.getPassword() + "');");

        db.close();
    }

    public void addNewSong(Song s)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //INSERT INTO SONG_TABLE VALUES('name','artist','isExplicit','duration','djId');
        db.execSQL("INSERT INTO " + SONG_TABLE + " (songName, artist, isExplicit, duration, djId) VALUES(" + s.getSongName() + "','" + s.getArtist() + "','" + s.getExplicit() + "','" + s.getDuration() + "','" + s.getDjId() + "');");

        db.close();
    }

    //=================================================
    //get all of a table
    @SuppressLint("Range")
    public ArrayList<Dj> getAllDjs()
    {
        //stores info the table returns
        ArrayList<Dj> listDjs = new ArrayList<Dj>();

        //reading db
        SQLiteDatabase db = this.getReadableDatabase();

        //query to get all rows and attributes
        Cursor cursor = db.rawQuery("SELECT * FROM " + DJ_TABLE + " ORDER BY djId;", null);

        //variables to store info
        int djId;
        String djName;
        String password;

        //move to first
        if(cursor.moveToFirst())
        {
            do
            {
                djId = cursor.getInt(cursor.getColumnIndex("djId"));
                djName = cursor.getString(cursor.getColumnIndex("djName"));
                password = cursor.getString(cursor.getColumnIndex("password"));

                listDjs.add(new Dj(djId, djName, password));
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

        Cursor cursor = db.rawQuery("SELECT * FROM " + EVENT_TABLE + " ORDER BY eventCode;", null);

        String eventCode;
        int djId;
        String date;
        String time;
        String location;
        String isPrivate;
        String isActive;

        if(cursor.moveToFirst())
        {
            do
            {
                eventCode = cursor.getString(cursor.getColumnIndex("eventCode"));
                djId = cursor.getInt(cursor.getColumnIndex("dj"));
                date = cursor.getString(cursor.getColumnIndex("date"));
                time = cursor.getString(cursor.getColumnIndex("time"));
                location = cursor.getString(cursor.getColumnIndex("location"));
                isPrivate = cursor.getString(cursor.getColumnIndex("isPrivate"));
                isActive = cursor.getString(cursor.getColumnIndex("isActive"));

                listEvents.add(new Event(eventCode, djId, date, time, location, isPrivate, isActive));
            }
            while(cursor.moveToNext());
        }

        db.close();

        return listEvents;
    }
    //will probably never be used
    @SuppressLint("Range")
    public ArrayList<Attendee> getAllAttendees()
    {
        ArrayList<Attendee> listAttendees = new ArrayList<Attendee>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + ATTENDEE_TABLE + " ORDER BY username;", null);

        String username;
        String firstName;
        String lastName;
        String password;

        if(cursor.moveToFirst())
        {
            do
            {
                username = cursor.getString(cursor.getColumnIndex("username"));
                firstName = cursor.getString(cursor.getColumnIndex("firstName"));
                lastName = cursor.getString(cursor.getColumnIndex("lastName"));
                password = cursor.getString(cursor.getColumnIndex("password"));

                listAttendees.add(new Attendee(username, firstName, lastName, password));
            }
            while(cursor.moveToNext());
        }

        db.close();

        return listAttendees;
    }
    //will probably never be used
    @SuppressLint("Range")
    public ArrayList<Song> getAllSongs()
    {
        ArrayList<Song> listSongs = new ArrayList<Song>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + SONG_TABLE + " ORDER BY songId;", null);

        int songId;
        String songName;
        String artist;
        String isExplicit;
        String duration;
        int djId;

        if(cursor.moveToFirst())
        {
            do
            {
                songId = cursor.getInt(cursor.getColumnIndex("id"));
                songName = cursor.getString(cursor.getColumnIndex("name"));
                artist = cursor.getString(cursor.getColumnIndex("artist"));
                isExplicit = cursor.getString(cursor.getColumnIndex("isExplicit"));
                duration = cursor.getString(cursor.getColumnIndex("duration"));
                djId = cursor.getInt(cursor.getColumnIndex("djId"));

                listSongs.add(new Song(songId, songName, artist, isExplicit, duration, djId));
            }
            while(cursor.moveToNext());
        }

        db.close();

        return listSongs;
    }
    //=================================================

    //=================================================
    //update commands
    public void updateDj(Dj dj)
    {
        //write to update
        SQLiteDatabase db = this.getWritableDatabase();

        //update command
        //UPDATE DJ_TABLE SET djName = 'djName', password = 'password' WHERE djId = 'djId';
        db.execSQL("UPDATE " + DJ_TABLE + " SET djName = '" + dj.getDjName() + "' , password = '" + dj.getPassword() + "' WHERE djId = '" + dj.getDjId() + "';");

        //close db
        db.close();
    }

    public void updateEvent(Event e)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //UPDATE EVENT_TABLE SET djId = 'djId' , date = 'date' , time = 'time' , location = 'location' , isPrivate = 'isPrivate' WHERE EVENT_PRIMARY = 'eventCode';
        db.execSQL("UPDATE " + EVENT_TABLE + " SET dj = '" + e.getDjId() + "' , date = '" + e.getTime() + "' , location = '" + e.getLocation() + "' , isPrivate = '" + e.getPrivate() + "' WHERE eventCode = '" + e.getEventCode() + "';");

        db.close();
    }

    public void updateAttendee(Attendee a)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //UPDATE ATTENDEE_TABLE SET firstName = 'firstName', lastName = 'lastName', password = 'password' WHERE username = 'username';
        db.execSQL("UPDATE " + ATTENDEE_TABLE + " SET firstName = '" + a.getFirstName() + "' , lastName = '" + a.getLastName() + "' , password = '" + a.getPassword() + "' WHERE username = '" + a.getUsername() + "';");

        db.close();
    }

    public void updateSong(Song s)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //UPDATE SONG_TABLE SET name = 'name' , artist = 'artist' , isExplicit = 'isExplicit' , duration = 'duration' WHERE songId = 'songId';
        db.execSQL("UPDATE " + SONG_TABLE + " SET songName = '" + s.getSongName() + "' , artist = '" + s.getArtist() + "' , isExplicit = '" + s.getExplicit() + "' , duration = '" + s.getDuration() + "' WHERE songId =  '" + s.getSongId() + "';");

        db.close();
    }
    //=================================================

    //=================================================
    //delete commands

    public void deleteDj(int id)
    {
        //get writeable instance of database
        SQLiteDatabase db = getWritableDatabase();

        //must delete off primary key
        //DELETE FROM DJ_TABLE WHERE djId = 'id';
        db.execSQL("DELETE FROM " + DJ_TABLE + " WHERE djId = '" + id + "';");

        //close
        db.close();
    }

    public void deleteEvent(String code)
    {
        SQLiteDatabase db = getWritableDatabase();

        //DELETE FROM EVENT_TABLE WHERE eventCode = 'code';
        db.execSQL("DELETE FROM " + EVENT_TABLE + " WHERE eventCode = '" + code + "';");

        db.close();
    }

    public void deleteAttendee(String uName)
    {
        SQLiteDatabase db = getWritableDatabase();

        //DELETE FROM ATTENDEE_TABLE WHERE username = 'uName';
        db.execSQL("DELETE FROM " + ATTENDEE_TABLE + " WHERE username = '" + uName + "';");

        db.close();
    }

    public void deleteSong(int id)
    {
        SQLiteDatabase db = getWritableDatabase();

        //DELETE FROM SONG_TABLE WHERE songId = 'id';
        db.execSQL("DELETE FROM " + SONG_TABLE + " WHERE songId = '" + id + "';");

        db.close();
    }
    //=================================================

    //=================================================
    //MISC QUERIES
    @SuppressLint("Range")
    public ArrayList<Event> getEventsOfDj(int djId)
    {
        ArrayList<Event> events = new ArrayList<Event>();

        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "SELECT * FROM " + EVENT_TABLE + " WHERE " + EVENT_TABLE + ".djId = '" + djId + "';";

        Cursor cursor = db.rawQuery(selectQuery, null);

        String eventCode;
        String date;
        String time;
        String location;
        String isPrivate;
        String isActive;

        if(cursor.moveToNext())
        {
            do
            {
                eventCode = cursor.getString(cursor.getColumnIndex("eventCode"));
                date = cursor.getString(cursor.getColumnIndex("date"));
                time = cursor.getString(cursor.getColumnIndex("time"));
                location = cursor.getString(cursor.getColumnIndex("location"));
                isPrivate = cursor.getString(cursor.getColumnIndex("isPrivate"));
                isActive = cursor.getString(cursor.getColumnIndex("isActive"));

                events.add(new Event(eventCode, djId, date, time, location, isPrivate, isActive));
            }
            while (cursor.moveToNext());
        }

        db.close();

        return events;
    }

    @SuppressLint("Range")
    public ArrayList<Song> getSongsOfDj(int djId)
    {
        ArrayList<Song> songs = new ArrayList<Song>();

        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "SELECT * FROM " + SONG_TABLE + " WHERE " + SONG_TABLE + ".djId = '" + djId + "';";

        Cursor cursor = db.rawQuery(selectQuery, null);

        int songId;
        String songName;
        String artist;
        String isExplicit;
        String duration;

        if (cursor.moveToNext())
        {
            do
            {
                songId = cursor.getInt(cursor.getColumnIndex("songId"));
                songName = cursor.getString(cursor.getColumnIndex("songName"));
                artist = cursor.getString(cursor.getColumnIndex("artist"));
                isExplicit = cursor.getString(cursor.getColumnIndex("isExplicit"));
                duration = cursor.getString(cursor.getColumnIndex("duration"));

                songs.add(new Song(songId, songName, artist, isExplicit, duration, djId));
            }
            while(cursor.moveToNext());

        }

        db.close();

        return songs;
    }
    public void activateEvent(String eventCode)
    {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("UPDATE " + EVENT_TABLE + " SET isActive = 'true' WHERE eventCode = '" + eventCode + "';");

        db.close();
    }

    @SuppressLint("Range")
    public String getDjOfEvent(String eventCode)
    {
        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = ("SELECT Djs.djName FROM " + EVENT_TABLE + " INNER JOIN " + DJ_TABLE + " ON Events.djId = Djs.djId WHERE Events.eventCode = '" + eventCode + "';");

        Cursor cursor = db.rawQuery(selectQuery,null);

        db.close();

        cursor.moveToFirst();

        return cursor.getString(cursor.getColumnIndex("djName"));
    }
    //=================================================
}
