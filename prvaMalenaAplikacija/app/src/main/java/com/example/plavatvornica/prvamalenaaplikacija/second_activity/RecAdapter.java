package com.example.plavatvornica.prvamalenaaplikacija.second_activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.plavatvornica.prvamalenaaplikacija.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gabriela on 18.7.2017..
 */



public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {
    public static final int TYPE_ELEMENT = 0;
    public static final int TYPE_HEADER = 1;

    ArrayList<String> recList = null;
    ArrayList<String> oldList = null;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewONE = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell_layout, parent, false);
        ViewHolder rowONE = new ViewHolder(viewONE);
        return rowONE;
/*
        switch (viewType) {
            case TYPE_ELEMENT:
                View viewONE = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell_layout, parent, false);
                ViewHolder rowONE = new ViewHolder(viewONE);
                return rowONE;

            case TYPE_HEADER:
                View viewTWO = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell_layout_header, parent, false);
                ViewHolder rowTWO = new ViewHolder(viewTWO);
                return rowTWO;

            default:
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell_layout, parent, false);
            ViewHolder row = new ViewHolder(view);
            return row;
        }*/
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = recList.get(position);
        holder.cell.setText(item);

    }

    @Override
    public int getItemCount() {
        return (recList == null) ? 0 : recList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_recycler_cell)
        TextView cell;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    @Override
    public int getItemViewType(int position) {
        String pos = recList.get(position);
        /*int viewType = 0;
        if (pos.getType() == TYPE_ELEMENT) {
            viewType = TYPE_ELEMENT;
        } else if (pos.getType() == TYPE_HEADER) {
            viewType = TYPE_HEADER;
        }

        return viewType;*/
        return 1;
    }

    public void setData(List<String> list){
        recList = new ArrayList<>();
        recList.addAll(list);
        notifyDataSetChanged();
    }

    public void oldOne(List<String> list){
        oldList = new ArrayList<>();
        oldList.addAll(list);
    }

}
