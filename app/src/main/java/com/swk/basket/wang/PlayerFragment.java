package com.swk.basket.wang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by T on 2015-12-04.
 */
public class PlayerFragment extends Fragment {
    List<String> players;
    public PlayerFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        players = new ArrayList<>();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_wait_join_player,container,false);
        RecyclerView joinPlayerList = (RecyclerView)v.findViewById(R.id.frag_wait_join_player_list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(container.getContext(),LinearLayoutManager.VERTICAL,false);
        joinPlayerList.setLayoutManager(manager);
        JoinPlayerAdapter joinPlayerAdapter = new JoinPlayerAdapter();
        joinPlayerAdapter.add("정신병");
        joinPlayerAdapter.add("정신병");
        joinPlayerAdapter.add("정신병");
        joinPlayerAdapter.add("정신병");
        joinPlayerList.setAdapter(joinPlayerAdapter);
        return v;
    }

    private class JoinPlayerAdapter extends RecyclerView.Adapter<JoinPlayerAdapter.ViewHolder>{

        class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View itemView){
                super(itemView);
            }
            AdapterView.OnItemClickListener mItemClickListner;

            public void setOnItemClickListner(AdapterView.OnItemClickListener mItemClickListner) {
                this.mItemClickListner = mItemClickListner;
            }
        }
        List<String> items = new ArrayList<>();
        AdapterView.OnItemClickListener mListener;
        public void setOnItemClickListener(AdapterView.OnItemClickListener listener){
            mListener = listener;
        }
        public void add(String item){
            items.add(item);
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_card,parent,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.setOnItemClickListner(mListener);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

}