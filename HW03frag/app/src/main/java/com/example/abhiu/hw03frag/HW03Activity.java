package com.example.abhiu.hw03frag;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HW03Activity extends AppCompatActivity implements PageChange {
    boolean aboutMeShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw03frag);

        if (savedInstanceState != null) {
            pageChange(savedInstanceState.getInt("pageId", 0));
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Front_Page_Frag.newInstance(R.id.front_page))
                    .commit();
        }
    }


    @Override
    public void pageChange(int pageId) {
        switch (pageId) {
            case 1:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new About_Me_Frag());
                transaction.addToBackStack("about_me");
                transaction.commit();
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (getSupportFragmentManager().getBackStackEntryCount()>0) {
            outState.putInt("pageId", 1);
        }
        super.onSaveInstanceState(outState);
    }
}
