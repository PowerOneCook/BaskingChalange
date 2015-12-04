package com.swk.basket.wang;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class WaitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);
        WaitFragment waitFragment = new WaitFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.wait_root, waitFragment);
        ft.commit();
        ViewPager pager = (ViewPager)findViewById(R.id.wait_pager);
        TabLayout tabs = (TabLayout)findViewById(R.id.wait_tab);

        WaitPagerAdapter waitPagerAdapter = new WaitPagerAdapter(fm);
        waitPagerAdapter.addFragment(new TalkFragment(),"카카오톡");
        waitPagerAdapter.addFragment(new PlayerFragment(),"참여선수");
        waitPagerAdapter.addFragment(new PlayerFragment(),"보류선수");
        pager.setAdapter(waitPagerAdapter);
        tabs.setupWithViewPager(pager);

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
            fragList = new ArrayList<>();
            titleList = new ArrayList<>();
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
    public static class TalkFragment extends Fragment{
        private int tutorialIndex = 0;
        int[] tutorials = new int[]{R.drawable.tutorial1,R.drawable.tutorial2};
        ImageView tutorial;
        public TalkFragment() {
            super();
        }
        public void getTutorial() {
            tutorial.setImageResource( tutorials[tutorialIndex]);
        }public void getTutorialnext() {
            if(tutorialIndex < 1){
                tutorialIndex++;
            }
            tutorial.setImageResource(tutorials[tutorialIndex]);
        }public void getTutorialprev() {
            if(tutorialIndex > 0){
                tutorialIndex--;
            }
            tutorial.setImageResource( tutorials[tutorialIndex]);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v =  inflater.inflate(R.layout.fragment_wait_talk,container,false);

            ImageButton nextBtn = (ImageButton)v.findViewById(R.id.frag_wait_talk_btn_tutorial_next);
            ImageButton prevBtn = (ImageButton)v.findViewById(R.id.frag_wait_talk_btn_tutorial_prev);
            tutorial = (ImageView)v.findViewById(R.id.frag_wait_talk_tutorial);
            getTutorial();
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getTutorialnext();
                }
            });
            prevBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getTutorialprev();
                }
            });
            return v;
        }
    }







}
