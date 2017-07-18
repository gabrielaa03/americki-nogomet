package com.example.plavatvornica.prvamalenaaplikacija.second_activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.plavatvornica.prvamalenaaplikacija.R;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Gabriela on 18.7.2017..
 */

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    ArrayList<RecyclerViewItem> recList;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.recycler_cell_layout , parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecyclerViewItem item = this.recList.get(position);
        holder.cell.setText(item.getItem());
    }

    @Override
    public int getItemCount() {
        return recList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_recycler_cell) TextView cell;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
