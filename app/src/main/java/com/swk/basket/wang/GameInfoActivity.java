package com.swk.basket.wang;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by T on 2015-12-04.
 */
public class GameInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);
        TabLayout tabs = (TabLayout)findViewById(R.id.game_info_tabs);
        ViewPager pager = (ViewPager)findViewById(R.id.game_info_pager);
        GameInfoPagerAdapter gameInfoPagerAdapter = new GameInfoPagerAdapter(getSupportFragmentManager());
        gameInfoPagerAdapter.add(new GameInfoFragment(),"경기정보");
        gameInfoPagerAdapter.add(new PlayerFragment(),"참여선수");
        gameInfoPagerAdapter.add(new TeamFragment(),"팀원선택");
        pager.setAdapter(gameInfoPagerAdapter);
        tabs.setupWithViewPager(pager);
    }
    private class GameInfoPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> items = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        public GameInfoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }
        public void add(Fragment f ,String title){
            items.add(f);
            titles.add(title);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
    public static class GameInfoFragment extends Fragment{
        public GameInfoFragment() {
            super();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_wait_tab_game,container,false);
        }
    }
    public static class TeamFragment extends Fragment{
        public TeamFragment() {
            super();
        }
        private class GroupData{
            ArrayList<String> items = new ArrayList<>();
        }
        private class MyAdapter extends BaseExpandableListAdapter{
            List<GroupData> items = new ArrayList<>();
            public MyAdapter() {
                super();
            }

            public List<GroupData> getItems() {
                return items;
            }
            public void addAll(ArrayList<GroupData> list){
                items = list;
            }
            @Override
            public int getGroupCount() {
                return items.size();
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return items.get(groupPosition).items.size();
            }

            @Override
            public Object getGroup(int groupPosition) {
                return items.get(groupPosition);
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return items.get(groupPosition).items.get(childPosition);
            }

            @Override
            public long getGroupId(int groupPosition) {
                return (long)groupPosition <<32|0xffffffff;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return ((long)groupPosition)<<32|(long)childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                if(convertView == null){
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team_group,null);
                }
                return convertView;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                if(convertView == null){
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team_child,null);
                }
                return convertView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        }
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_team_select,container,false);
            ExpandableListView list = (ExpandableListView) v.findViewById(R.id.frag_team_select_team_list);
            GroupData groupData = new GroupData();
            groupData.items.add("자살");
            groupData.items.add("자살");
            groupData.items.add("자살");
            groupData.items.add("자살");
            GroupData groupData2 = new GroupData();
            groupData2.items.add("자살");
            groupData2.items.add("자살");
            groupData2.items.add("자살");
            ArrayList<GroupData> groupDatas = new ArrayList<>();
            groupDatas.add(groupData);
            groupDatas.add(groupData2);
            MyAdapter myAdapter = new MyAdapter();
            myAdapter.addAll(groupDatas);
            list.setAdapter(myAdapter);
            return v;
        }
    }

}
