/*
 * Copyright (c) 2015. Hannes Boran
 */

package com.tailoredapps.themetestapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Pair;

import java.util.ArrayList;

/**
 * Created by hannes on 30.01.15.
 */
class ThemedFragmentPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Pair<String, Integer>> themes;

    public ThemedFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        themes = Util.createThemes();
    }

    @Override
    public Fragment getItem(int i) {
        Fragment frag = new ThemedFragment();
        Bundle bundle = new Bundle();
        bundle.putString("theme_name", themes.get(i).first);
        bundle.putInt("theme_res", themes.get(i).second);
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public int getCount() {
        return themes.size();
    }
}
