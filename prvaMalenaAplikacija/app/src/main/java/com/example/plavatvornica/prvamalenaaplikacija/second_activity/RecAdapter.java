package com.example.plavatvornica.prvamalenaaplikacija.second_activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper;
import com.example.plavatvornica.prvamalenaaplikacija.second_activity.view.SecondInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper.TYPE_ELEMENT;
import static com.example.plavatvornica.prvamalenaaplikacija.data_model.Wrapper.TYPE_HEADER;

/**
 * Created by Gabriela on 18.7.2017..
 */



public class RecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<Wrapper> recList = new ArrayList<>();
    SecondInterface clickListener;
    String text;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        switch (viewType) {
            case TYPE_ELEMENT:
                return new ItemHolder(view);
            case TYPE_HEADER:
                return new HeaderHolder(view);

        }
        return null;
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

                break;
        }
    }
    @Override
    public int getItemCount() {
        return (recList == null) ? 0 : recList.size();
    }

    public class HeaderHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_recycler_cell1)TextView cell1;


        public HeaderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setClickListener(SecondInterface itemClickListener) {
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
            text = recList.get(getAdapterPosition()).getText();
            if (clickListener != null) clickListener.onClick(v, text);
        }
    }
    @Override
    public int getItemViewType(int position) {
        return recList.get(position).getType();
    }

    public void addDataIntoRecycler(List<Wrapper> list){
        recList.clear();
        recList.addAll(list);
        notifyDataSetChanged();
    }



}
