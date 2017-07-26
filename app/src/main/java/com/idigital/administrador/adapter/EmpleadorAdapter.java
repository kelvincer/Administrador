package com.idigital.administrador.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idigital.administrador.R;
import com.idigital.administrador.entities.Sede;
import com.idigital.administrador.util.SimpleDividerItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by USUARIO on 25/07/2017.
 */

public class EmpleadorAdapter extends RecyclerView.Adapter<EmpleadorAdapter.ViewHolder> {

    List<Sede> data;

    public EmpleadorAdapter(List<Sede> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empleador_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Sede sede = data.get(position);
        holder.bindItem(sede);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.headquarter_name)
        TextView headquarterName;
        @BindView(R.id.employeesRyv)
        RecyclerView employeesRyv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(Sede sede) {
            headquarterName.setText(sede.getName());
            setupViews();
            if (sede.getUsuarios() == null || sede.getUsuarios().size() == 0) {

            } else {
                employeesRyv.setAdapter(new EmployeeAdapter(sede.getUsuarios()));
            }
        }

        private void setupViews() {
            employeesRyv.setLayoutManager(new LinearLayoutManager(employeesRyv.getContext()));
            employeesRyv.addItemDecoration(new SimpleDividerItemDecoration(employeesRyv.getContext()));
        }
    }
}
