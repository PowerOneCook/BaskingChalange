package com.swk.basket.wang;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by T on 2015-12-08.
 */
public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder>{
    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView){
            super(itemView);
        }
    }
    ArrayList<String> items= new ArrayList<>();
    public void add(String item){
        items.add(item);
        notifyDataSetChanged();
    }
    public void addAll(ArrayList<String> items){
        this.items = items;
    }
    public ArrayList<String> getItems() {
        return items;
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.score_card,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }
}
