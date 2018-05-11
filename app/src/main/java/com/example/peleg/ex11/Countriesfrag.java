package com.example.peleg.ex11;

import android.app.ListFragment;
import android.content.Context;

/**
 * Created by peleg on 5/11/2018.
 */

public class Countriesfrag extends ListFragment {
    CountryAdapter adapter;
    public Countriesfrag(){
        super();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        adapter = new CountryAdapter(context);
        setListAdapter(adapter);
    }
}
