/*
 * Copyright (c) 2015. Hannes Boran
 */

package com.tailoredapps.themetestapp;

import android.os.Build;
import android.util.Pair;

import java.util.ArrayList;

/**
 * Created by hannes on 30.01.15.
 */
public class Util {
    public static ArrayList<Pair<String, Integer>> createThemes() {
        ArrayList<Pair<String, Integer>> themes = new ArrayList<>();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            themes.add(new Pair("Material", R.style.ThemeMaterial));
        }
        themes.add(new Pair("AppCompat", R.style.ThemeAppCompat));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            themes.add(new Pair("DeviceDefault", R.style.ThemeDeviceDefault));
            themes.add(new Pair("Holo", R.style.ThemeHolo));
        }
        themes.add(new Pair("Classic", R.style.ThemeClassic));


        return themes;
    }
}
