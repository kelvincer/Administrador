package com.idigital.administrador.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.idigital.administrador.R;
import com.idigital.administrador.TestConnectionAsyncTask;
import com.idigital.administrador.adapter.AttendanceRecyclerAdapter;
import com.idigital.administrador.adapter.ResultAdapter;
import com.idigital.administrador.api.IDigitalClient;
import com.idigital.administrador.api.IDigitalService;
import com.idigital.administrador.entities.Atendance;
import com.idigital.administrador.entities.Result;
import com.idigital.administrador.response.AllAtendanceResponse;
import com.idigital.administrador.response.FilterResponse;
import com.idigital.administrador.util.SimpleDividerItemDecoration;
import com.idigital.administrador.view.ProgressDialogView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by USUARIO on 21/07/2017.
 */

public class FilterFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = FilterFragment.class.getSimpleName();

    @BindView(R.id.id_user_etx)
    EditText idUserEtx;
    @BindView(R.id.movement_etx)
    EditText movementEtx;
    @BindView(R.id.id_sede_etx)
    EditText idSedeEtx;
    @BindView(R.id.state_etx)
    EditText stateEtx;
    @BindView(R.id.category_etx)
    EditText categoryEtx;
    @BindView(R.id.search_btn)
    Button searchBtn;
    @BindView(R.id.filter_recycler)
    RecyclerView filterRecycler;
    Unbinder unbinder;
    ProgressDialogView progressDialogView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_filter, container, false);
        unbinder = ButterKnife.bind(this, v);

        setupView();
        return v;
    }

    private void setupView() {

        filterRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        filterRecycler.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        searchBtn.setOnClickListener(this);
        progressDialogView = new ProgressDialogView(getContext());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.search_btn) {

            progressDialogView.showProgressDialog();
            new TestConnectionAndFetchAttendanceAsyncTask().execute();
        }
    }

    private void fillRecycler(List<Result> data) {

        ResultAdapter recyclerAdapter = new ResultAdapter(data);
        filterRecycler.setAdapter(recyclerAdapter);
    }

    private void fetchData() {

        IDigitalService service = IDigitalClient.getIDigitalService();
        Call<FilterResponse> call = service.searchUsers(idUserEtx.getText().toString(), movementEtx.getText().toString(),
                idSedeEtx.getText().toString(), stateEtx.getText().toString(), categoryEtx.getText().toString());
        call.enqueue(new Callback<FilterResponse>() {
            @Override
            public void onResponse(Call<FilterResponse> call, Response<FilterResponse> response) {

                if (response.isSuccessful()) {

                    FilterResponse filterResponse = response.body();
                    fillRecycler(filterResponse.getData());

                } else {
                    Toast.makeText(getContext(), "Error loading data", Toast.LENGTH_SHORT);
                }
                progressDialogView.dismissDialog();
                Log.i(TAG, response.raw().toString());
            }

            @Override
            public void onFailure(Call<FilterResponse> call, Throwable t) {
                progressDialogView.dismissDialog();
                Log.i(TAG, t.getMessage());
                Toast.makeText(getContext(), "Failure on service", Toast.LENGTH_SHORT).show();
            }
        });
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
