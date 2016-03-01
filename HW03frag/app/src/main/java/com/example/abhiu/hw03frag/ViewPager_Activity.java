package com.example.abhiu.hw03frag;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ViewPager_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);

        MoviePagerAdapter adapter = new MoviePagerAdapter(getSupportFragmentManager(), new MovieData());
        viewPager.setAdapter(adapter);

     viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
         public void transformPage(View page, float pos) {
             //rotation effect
           page.setRotationY(pos * -20);

                          // fading
             //final float nor=Math.abs(Math.abs(pos)-2);
             //page.setAlpha(nor);

                      // scaling
            // final float nor=Math.abs(Math.abs(pos)-2);
             //page.setScaleX(nor/2+0.5f);
             //page.setScaleY(nor/2+0.5f);

                 }

              });

             TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
             tabLayout.setupWithViewPager(viewPager);
             viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
         }


     }
