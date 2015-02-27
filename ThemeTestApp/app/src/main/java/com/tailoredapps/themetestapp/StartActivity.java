/*
 * Copyright (c) 2015. Hannes Boran
 */

package com.tailoredapps.themetestapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class StartActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_start, container,
                    false);
            ViewGroup buttonContainer = (ViewGroup) rootView.findViewById(R.id.buttonContainer);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                addButton(getString(R.string.classic_activity), ClassicActivity.class, buttonContainer);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                addButton(getString(R.string.holo_activity), HoloActivity.class, buttonContainer);
                addButton(getString(R.string.devicedefault_activity), DeviceDefaultActivity.class, buttonContainer);
            }
            addButton("AppCompatActivity", MainActivity.class, buttonContainer);
            addButton("CompatNoActionbarActivity", CompatNoActionbarActivity.class,
                    buttonContainer);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                addButton(getString(R.string.material_activity), MaterialActivity.class, buttonContainer);
            }
            return rootView;
        }

        public void addButton(String buttonText, final Class<?> cls, ViewGroup viewGroup) {
            Button button = new Button(getActivity());
            button.setText(buttonText);
            button.setMinWidth(getResources().getDimensionPixelSize(R.dimen.button_width));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), cls);
                    startActivity(intent);
                }
            });
            viewGroup.addView(button, ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
