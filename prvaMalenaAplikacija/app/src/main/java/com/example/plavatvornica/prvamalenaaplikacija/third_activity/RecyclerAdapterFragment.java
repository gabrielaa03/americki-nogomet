package com.example.plavatvornica.prvamalenaaplikacija.third_activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.plavatvornica.prvamalenaaplikacija.R;
import com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper_Second;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper_Second.TYPE_NAME_OF_PLAYER;
import static com.example.plavatvornica.prvamalenaaplikacija.model.data_models.Wrapper_Second.TYPE_NAME_OF_TEAM;

/**
 * Created by Plava tvornica on 21.7.2017..
 */

public class RecyclerAdapterFragment extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Wrapper_Second> list = new ArrayList();


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent ,false);
            switch(viewType){
                case TYPE_NAME_OF_PLAYER:
                    return new PlayerHolder(view);
                case TYPE_NAME_OF_TEAM:
                    return new TeamHolder(view);
            }
            return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Wrapper_Second item =  list.get(position);
        switch(holder.getItemViewType()){
            case TYPE_NAME_OF_PLAYER:
                PlayerHolder playerHolder = (PlayerHolder) holder;
                playerHolder.cell_player.setText((String) item.getObject());
                break;
            case TYPE_NAME_OF_TEAM:
                TeamHolder teamHolder = (TeamHolder) holder;
                teamHolder.cell_team.setText((String) item.getObject());
                break;
        }
    }

    @Override
    public int getItemCount() {
        { return (list == null) ? 0 : list.size();}
    }


    public class PlayerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recycler_cell_player)
        TextView cell_player;


        public PlayerHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    public class TeamHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.recycler_cell_team) TextView cell_team;

        public TeamHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    public void addData(List<Wrapper_Second> list1){
        list.clear();
        list.addAll(list1);
        notifyDataSetChanged();
    }


}
