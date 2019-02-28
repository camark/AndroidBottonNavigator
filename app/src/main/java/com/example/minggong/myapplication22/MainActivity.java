package com.example.minggong.myapplication22;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.minggong.myapplication22.AboutFragment.OnFragmentInteractionListener;


public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,MeetingStatusFragment.OnFragmentInteractionListener,OnFragmentInteractionListener
{

    ViewPager main_viewPager;
    BottomNavigationView navigation;
    MainActivityViewPagerAdapter pagerAdapter;
    private MenuItem menuItem;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    main_viewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_dashboard:
                    main_viewPager.setCurrentItem(1);
                    break;
                case R.id.navigation_notifications:
                    main_viewPager.setCurrentItem(2);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);

        main_viewPager= findViewById(R.id.main_viewpager);
        pagerAdapter=new MainActivityViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new HomeFragment());
        pagerAdapter.addFragment(new MeetingStatusFragment());
        pagerAdapter.addFragment(new AboutFragment());
        main_viewPager.setAdapter(pagerAdapter);
        //main_viewPager.setCurrentItem(0);

        main_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigation.getMenu().getItem(position);
                menuItem.setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //mTextMessage = (TextView) findViewById(R.id.message);

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
