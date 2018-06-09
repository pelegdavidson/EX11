package com.example.peleg.ex11;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;

import android.widget.ListView;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import static com.example.peleg.ex11.XMLParser.parseFromStream;

/**
 * Created by peleg on 5/11/2018.
 */

public class CountryAdapter extends ArrayAdapter<Country> {

    ArrayList<Country> allCountroies;


    public CountryAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_1);
        InputStream ips = openAssetDataStream(context);
        this.allCountroies = parseFromStream(ips);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getContext());
        String del = settings.getString("deletedCountries", "");
        boolean b =settings.getBoolean("tosavelist", false);
        for (Country country: allCountroies)
        {
            if(!b||del.indexOf(country.getName())==-1){
                add(country);
            }
        }
        try {
            ips.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void removef(int pos){
        Country c = getItem(pos);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = settings.edit();
        if(settings.getBoolean("tosavelist",false)){
            editor.putString("deletedCountries",settings.getString("deletedCountries","")+","+c.getName());
           editor.commit();
        }
        remove(c);

    }
    private static InputStream openAssetDataStream(Context context){
        AssetManager assetManager = context.getAssets();
        InputStream in =null;
        try {
            in = assetManager.open("countries.xml");
        } catch (IOException e) {e.printStackTrace();}
        return in;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.rowitem,parent,false);
        Country currCountry = getItem(position);
        int resId = parent.getResources().getIdentifier(currCountry.getFlag(), "drawable", getContext().getPackageName());
        ImageView image = (ImageView)listItem.findViewById(R.id.imageView);
        image.setImageResource(resId);
        TextView name = (TextView) listItem.findViewById(R.id.name);
        name.setText(currCountry.getName());
        TextView release = (TextView) listItem.findViewById(R.id.info);
        release.setText(currCountry.getShorty());
        listItem.setTag(currCountry.getDetails());
        return listItem;

    }


}

