package com.example.abhiu.hw03frag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by abhiu on 2/10/2016.
 */
public class MoviePagerAdapter extends FragmentStatePagerAdapter{
    int count;

    private MovieData movieData;

    public MoviePagerAdapter(FragmentManager fm, MovieData movieData) {
        super(fm);
        this.movieData=movieData;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment frag = Task1Frag.newInstance(movieData.getItem(position));
        return frag;
    }

    @Override
    public int getCount() {
        return movieData.getSize();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) movieData.getItem(position).get("name");
    }
}
