package com.example.cis183_djsongsearch;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongLibraryListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Song> listOfSongs;

    public SongLibraryListAdapter(Context c, ArrayList<Song> ls)
    {
        context = c;
        listOfSongs = ls;
    }

    @Override
    public int getCount()
    {
        return listOfSongs.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfSongs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.song_library_custom_cell, null);
        }

        TextView name = view.findViewById(R.id.tv_v_slcc_name);
        TextView artist = view.findViewById(R.id.tv_v_slcc_artist);
        TextView explicit = view.findViewById(R.id.tv_v_slcc_explicit);
        TextView duration = view.findViewById(R.id.tv_v_slcc_duration);

        Song song = listOfSongs.get(i);

        name.setText(song.getSongName());
        artist.setText(song.getArtist());
        duration.setText(song.getDuration());

        if(song.getExplicit().equals("true"))
        {
            explicit.setVisibility(View.VISIBLE);
        }

        return view;
    }
}
