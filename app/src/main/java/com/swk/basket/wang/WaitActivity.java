package com.swk.basket.wang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class WaitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);
        WaitFragment waitFragment = new WaitFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.wait_root, waitFragment);
        ft.commit();
        ViewPager pager = (ViewPager)findViewById(R.id.wait_pager);
        TabLayout tabs = (TabLayout)findViewById(R.id.wait_tab);
        WaitPagerAdapter waitPagerAdapter = new WaitPagerAdapter(getSupportFragmentManager());
        waitPagerAdapter.addFragment();

    }
    public static class WaitFragment extends Fragment{

        public WaitFragment() {
            super();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            View v = inflater.inflate(R.layout.fragment_wait_status_wait,container,false);
            return v;
        }
    }
    private class WaitPagerAdapter extends FragmentPagerAdapter{
        ArrayList<Fragment> fragList;
        ArrayList<String> titleList;
        public WaitPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return fragList.size();
        }

        @Override
        public Fragment getItem(int position) {
            return fragList.get(position);
        }
        public void addFragment(Fragment fm , String title){
            fragList.add(fm);
            titleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
    private class GameFragment extends Fragment{

        public GameFragment() {
            super();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return null;
        }
    }

}
