package com.idigital.administrador.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idigital.administrador.R;
import com.idigital.administrador.entities.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by USUARIO on 21/07/2017.
 */

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.CustomViewHolder> {

    List<Result> data;

    public ResultAdapter(List<Result> data) {
        this.data = data;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.bindItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name_txv)
        TextView nameTxv;
        @BindView(R.id.date_txv)
        TextView dateTxv;
        @BindView(R.id.category_txv)
        TextView categoryTxv;
        @BindView(R.id.state_txv)
        TextView stateTxv;
        @BindView(R.id.movement_txv)
        TextView movementTxv;
        View view;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            view = itemView;
        }

        private void bindItem(final Result item) {

            nameTxv.setText(item.getNombre());
            dateTxv.setText(item.getDateShow());
            categoryTxv.setText(item.getCategoria());
            stateTxv.setText(item.getState());
            movementTxv.setText(item.getMovement());
        }
    }
}
