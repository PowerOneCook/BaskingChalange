package com.swk.basket.wang;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handstudio.android.hzgrapherlib.animation.GraphAnimation;
import com.handstudio.android.hzgrapherlib.graphview.CircleGraphView;
import com.handstudio.android.hzgrapherlib.vo.GraphNameBox;
import com.handstudio.android.hzgrapherlib.vo.circlegraph.CircleGraph;
import com.handstudio.android.hzgrapherlib.vo.circlegraph.CircleGraphVO;

import java.util.ArrayList;
import java.util.List;

public class TeamActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_team);
        final CardView scoreDescBtn = (CardView) findViewById(R.id.team_score_desc);
        final CardView scoreRootCard = (CardView) findViewById(R.id.team_score_desc_card);
        scoreDescBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreRootCard.setVisibility(View.VISIBLE);
                ScoreFragment scoreFragment = new ScoreFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.add(R.id.team_score_desc_card, scoreFragment);
                ft.commit();
            }
        });
        RecyclerView scoreList = (RecyclerView) findViewById(R.id.team_score_list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        scoreList.setLayoutManager(manager);
        ScoreAdapter scoreAdapter = new ScoreAdapter();
        scoreAdapter.add("자살");
        scoreAdapter.add("자살");
        scoreAdapter.add("자살");
        scoreAdapter.add("자살");
        scoreAdapter.add("자살");
        scoreList.setAdapter(scoreAdapter);
    }

    public static class ScoreFragment extends Fragment {
        public ScoreFragment() {
            super();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_team_score_desc, container, false);
            RecyclerView scoreList = (RecyclerView) v.findViewById(R.id.frag_team_score_list);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, false);
            scoreList.setLayoutManager(manager);
            GraphAdapter graphAdapter = new GraphAdapter();
            graphAdapter.add("자살");
            graphAdapter.add("자살");
            graphAdapter.add("자살");
            graphAdapter.add("자살");
            graphAdapter.add("자살");
            graphAdapter.add("자살");
            graphAdapter.add("자살");
            scoreList.setAdapter(graphAdapter);
            return v;
        }
    }

    private static class GraphAdapter extends RecyclerView.Adapter<GraphAdapter.ViewHolder> {


        static class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(View itemView) {
                super(itemView);
            }


            ViewGroup layoutGraphView;
            ArrayList<CircleGraph> graphs = new ArrayList<>();
            public void setScore(int win, int lose) {
                graphs.clear();
                graphs.add(new CircleGraph("승", Color.parseColor("#03a9f4"), win));
                graphs.add(new CircleGraph("패",Color.parseColor("#e84e40"),lose));
            }

            private void setCircleGraph() {
                CircleGraphVO vo = makeLineGraphAllSetting(graphs);
                layoutGraphView.addView(new CircleGraphView(layoutGraphView.getContext(), vo));
            }

            /**
             * make line graph using options
             *
             * @return
             */
            private CircleGraphVO makeLineGraphAllSetting(List<CircleGraph> items) {
                //BASIC LAYOUT SETTING
                //padding
                int paddingBottom = CircleGraphVO.DEFAULT_PADDING;
                int paddingTop = CircleGraphVO.DEFAULT_PADDING;
                int paddingLeft = CircleGraphVO.DEFAULT_PADDING;
                int paddingRight = CircleGraphVO.DEFAULT_PADDING;

                //graph margin
                int marginTop = CircleGraphVO.DEFAULT_MARGIN_TOP;
                int marginRight = CircleGraphVO.DEFAULT_MARGIN_RIGHT;

                // radius setting
                int radius = 130;

                List<CircleGraph> arrGraph = new ArrayList<>();
                arrGraph.addAll(items);


                CircleGraphVO vo = new CircleGraphVO(paddingBottom, paddingTop, paddingLeft, paddingRight, marginTop, marginRight, radius, arrGraph);

                // circle Line
                vo.setLineColor(Color.WHITE);

                // set text setting
                vo.setTextColor(Color.WHITE);
                vo.setTextSize(20);

                // set circle center move X ,Y
                vo.setCenterX(0);
                vo.setCenterY(0);

                //set animation
                vo.setAnimation(new GraphAnimation(GraphAnimation.LINEAR_ANIMATION, 2000));
                //set graph name box

                vo.setPieChart(true);

                GraphNameBox graphNameBox = new GraphNameBox();

                // nameBox
                graphNameBox.setNameboxMarginTop(25);
                graphNameBox.setNameboxMarginRight(25);

                vo.setGraphNameBox(graphNameBox);

                return vo;
            }
        }

        List<String> items = new ArrayList<>();

        @Override
        public int getItemCount() {
            return items.size();
        }

        public void add(String item) {
            items.add(item);
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag_team_score_item, parent, false);
            ViewHolder holder = new ViewHolder(v);
            holder.layoutGraphView = (ViewGroup)v.findViewById(R.id.item_team_score_graph);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            int win = (int) (Math.random() * 30) + 1;
            holder.setScore(win, 30 - win);
            holder.setCircleGraph();

        }


    }
}

