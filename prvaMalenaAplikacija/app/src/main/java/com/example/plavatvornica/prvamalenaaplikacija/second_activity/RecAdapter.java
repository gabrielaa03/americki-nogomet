package com.example.plavatvornica.prvamalenaaplikacija.second_activity;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gabriela on 18.7.2017..
 */

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    ArrayList<String> recList = null;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

               View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell_layout, parent, false);
                return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = recList.get(position);
        holder.cell.setText(item);
/*
        if (item!=null){
            switch(item.getType()){
                case HEADER:
                    holder.cell.setBackgroundColor(Color.parseColor("#68015e"));
                    break;
                case ROW:
                    holder.cell.setBackgroundColor(Color.parseColor("#ffffff"));
                    break;
            }
        }*/
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
        super.getItemViewType(position);
/*
        if (recList != null) {
            String object = recList.get(position);
            if (object != null) {
                return object.getItem();
            }
        }*/
        return 0;

    }

    public void setData(List<String> list){
        recList = new ArrayList<>();
        recList.addAll(list);
        notifyDataSetChanged();
    }


}
