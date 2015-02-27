/*
 * Copyright (c) 2015. Hannes Boran
 */

package com.tailoredapps.themetestapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ThemedFragment extends Fragment {

    public ThemedFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // create ContextThemeWrapper from the original Activity Context with the custom theme
        Bundle bundle = getArguments();
        int themeRes = bundle.getInt("theme_res");
        final Context contextThemeWrapper;
        contextThemeWrapper = new ContextThemeWrapper(getActivity(),
                themeRes);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);

        // inflate the layout using the cloned inflater, not default inflater
        View root = localInflater.inflate(R.layout.fragment_main, container, false);
        TextView header = (TextView) root.findViewById(R.id.header);
        header.setText("Theme " + bundle.getString("theme_name"));

        if (getActivity() instanceof ActionBarActivity) {
            ViewGroup switchContainer = (ViewGroup) root.findViewById(R.id.compatContainer);
            SwitchCompat compatSwitch = new SwitchCompat(getActivity());
            compatSwitch.setChecked(true);
            switchContainer.addView(compatSwitch);
        }
        return root;
    }
}
