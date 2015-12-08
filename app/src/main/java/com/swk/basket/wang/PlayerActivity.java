package com.swk.basket.wang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_image_white_24dp);
        setSupportActionBar(toolbar);
        RecyclerView scoreList = (RecyclerView)findViewById(R.id.player_score_list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        scoreList.setLayoutManager(manager);
        ScoreAdapter scoreAdapter = new ScoreAdapter();
        scoreAdapter.add("자살");
        scoreAdapter.add("자살");
        scoreAdapter.add("자살");
        scoreAdapter.add("자살");
        scoreAdapter.add("자살");
        scoreList.setAdapter(scoreAdapter);
    }

}
