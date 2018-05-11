package com.example.peleg.ex11;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.ArrayAdapter;

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
        for (Country country: allCountroies)
        {
            add(country);
        }
        try {
            ips.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static InputStream openAssetDataStream(Context context){
        AssetManager assetManager = context.getAssets();
        InputStream in =null;
        try {
            in = assetManager.open("countries.xml");
        } catch (IOException e) {e.printStackTrace();}
        return in;
    }


}

