package com.idigital.administrador.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.idigital.administrador.R;
import com.idigital.administrador.TestConnectionAsyncTask;
import com.idigital.administrador.adapter.EmpleadorAdapter;
import com.idigital.administrador.api.IDigitalClient;
import com.idigital.administrador.api.IDigitalService;
import com.idigital.administrador.entities.Sede;
import com.idigital.administrador.response.EmpleadorResponse;
import com.idigital.administrador.util.SimpleDividerItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by USUARIO on 25/07/2017.
 */

public class EmpleadorFragment extends Fragment {

    @BindView(R.id.empleador_ryv)
    RecyclerView empleadorRyv;
    Unbinder unbind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_empleador, container, false);
        ButterKnife.bind(this, view);
        setUpViews();


        new TestConnectionAndFetchAttendanceAsyncTask().execute();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void setUpViews() {
        empleadorRyv.setLayoutManager(new LinearLayoutManager(getContext()));
        empleadorRyv.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
    }

    private void fetchData() {

        IDigitalService service = IDigitalClient.getIDigitalService();
        Call<EmpleadorResponse> call = service.getEmpleador();
        call.enqueue(new Callback<EmpleadorResponse>() {
            @Override
            public void onResponse(Call<EmpleadorResponse> call, Response<EmpleadorResponse> response) {

                if (response.isSuccessful()) {

                    EmpleadorResponse empleadorResponse = response.body();
                    fillRecyclerView(empleadorResponse.getData());
                }
            }

            @Override
            public void onFailure(Call<EmpleadorResponse> call, Throwable t) {

            }
        });

    }

    private void fillRecyclerView(List<Sede> data) {
        empleadorRyv.setAdapter(new EmpleadorAdapter(data));
    }

    private class TestConnectionAndFetchAttendanceAsyncTask extends TestConnectionAsyncTask {

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (!aBoolean) {
                Toast.makeText(getContext(), getResources().getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
                return;
            } else
                fetchData();
        }
    }
}
