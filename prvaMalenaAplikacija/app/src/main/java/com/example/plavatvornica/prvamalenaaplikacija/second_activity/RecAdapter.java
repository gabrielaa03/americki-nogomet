package com.example.plavatvornica.prvamalenaaplikacija.second_activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gabriela on 18.7.2017..
 */



public class RecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_ELEMENT = 0;
    public static final int TYPE_HEADER = 1;
    private String numberOfElements="";

    ArrayList<Wrapper> recList = null;
    ItemClickListener clickListener;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ELEMENT:
                View viewONE = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell_layout, parent, false);
                ItemHolder rowONE = new ItemHolder(viewONE);
                return rowONE;

            case TYPE_HEADER:
                View viewTWO = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cell_layout_header, parent, false);
                HeaderHolder rowTWO = new HeaderHolder(viewTWO);
                return rowTWO;

        }return null;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Wrapper item = recList.get(position);

        switch(holder.getItemViewType()){
            case TYPE_ELEMENT:
                ItemHolder itemHolder = (ItemHolder) holder;
                itemHolder.cell.setText(item.getText());
                break;
            case TYPE_HEADER:
                HeaderHolder headerHolder = (HeaderHolder) holder;
                headerHolder.cell1.setText(item.getText());
                headerHolder.cellCount.setText(numberOfElements);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return (recList == null) ? 0 : recList.size();
    }

    public class HeaderHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_recycler_cell1)TextView cell1;
        @BindView(R.id.tv_recycler_cell_count)TextView cellCount;


        public HeaderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_recycler_cell)
        TextView cell;

        public ItemHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onClick(v, getAdapterPosition());
        }
    }


    public interface ItemClickListener {
        void onClick(View view, int position);
    }

    @Override
    public int getItemViewType(int position) {
        Wrapper pos = recList.get(position);
        int viewType = 0;
        if (pos.getType() == TYPE_ELEMENT) {
            viewType = TYPE_ELEMENT;
        } else if (pos.getType() == TYPE_HEADER) {
            viewType = TYPE_HEADER;
        }

        return viewType;

    }

    public void setData(List<Wrapper> list){
        recList = new ArrayList<>();
        recList.addAll(list);
        notifyDataSetChanged();
    }



}
