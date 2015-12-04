package com.swk.basket.wang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_team);
        final CardView scoreDescBtn = (CardView)findViewById(R.id.team_score_desc);
        final CardView scoreRootCard = (CardView)findViewById(R.id.team_score_desc_card);
        scoreDescBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreRootCard.setVisibility(View.VISIBLE);
                ScoreFragment scoreFragment = new ScoreFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.add(R.id.team_score_desc_card,scoreFragment);
                ft.commit();
            }
        });
    }
    public static class ScoreFragment extends Fragment{
        public ScoreFragment() {
            super();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v =  inflater.inflate(R.layout.fragment_team_score_desc,container,false);
            RecyclerView scoreList = (RecyclerView)v.findViewById(R.id.frag_team_score_list);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(container.getContext(),LinearLayoutManager.HORIZONTAL,false);
            scoreList.setLayoutManager(manager);
            ScoreAdpater scoreAdpater = new ScoreAdpater();
            scoreAdpater.add("자살");
            scoreAdpater.add("자살");
            scoreAdpater.add("자살");
            scoreAdpater.add("자살");
            scoreAdpater.add("자살");
            scoreAdpater.add("자살");
            scoreAdpater.add("자살");
            scoreList.setAdapter(scoreAdpater);
            return v;
        }
    }
    private static class ScoreAdpater extends RecyclerView.Adapter<ScoreAdpater.ViewHolder>{
        static class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
        List<String> items = new ArrayList<>();
        @Override
        public int getItemCount() {
            return items.size();
        }
        public void add(String item){
            items.add(item);
            notifyDataSetChanged();
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag_team_score_item,parent,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }
    }
}
