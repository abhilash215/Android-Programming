package com.example.abhiu.hw03frag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

public class Master_Detail extends AppCompatActivity implements Fragment_List.OnListItemSelectedListener {


    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master__detail);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container,Fragment_List.newInstance())
                    .commit();

        if (findViewById(R.id.detail_container) != null)
        {
            mTwoPane = true;

        }
    }

    public void onListItemSelected(int position, HashMap<String,?> movie)
    {
        if(mTwoPane)
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container,Task1Frag.newInstance(movie))
                    .addToBackStack(null)
                    .commit();
        }
        else
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, Task1Frag.newInstance(movie))
                    .addToBackStack(null)
                    .commit();
        }

    }}

