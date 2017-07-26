package com.idigital.administrador.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idigital.administrador.R;
import com.idigital.administrador.entities.Atendance;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by USUARIO on 06/04/2017.
 */

public class AttendanceRecyclerAdapter extends RecyclerView.Adapter<AttendanceRecyclerAdapter.CustomViewHolder> {

    List<Atendance> data;

    public AttendanceRecyclerAdapter(List<Atendance> data) {
        this.data = data;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_list_item, parent, false);
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

    public void updateData(List<Atendance> data) {

        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void clearData() {
        this.data.clear();
        notifyDataSetChanged();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.user_txv)
        TextView userTxv;
        @BindView(R.id.date_txv)
        TextView dateTxv;
        @BindView(R.id.category_txv)
        TextView categoryTxv;
        @BindView(R.id.state_txv)
        TextView stateTxv;
        View view;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            view = itemView;
        }

        private void bindItem(final Atendance item) {

            userTxv.setText(item.getNombre());
            dateTxv.setText(item.getDateShow());
            categoryTxv.setText(item.getCategory());
            stateTxv.setText(item.getState());
        }
    }
}
