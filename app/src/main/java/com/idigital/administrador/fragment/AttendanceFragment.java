package com.idigital.administrador.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.idigital.administrador.R;
import com.idigital.administrador.TestConnectionAsyncTask;
import com.idigital.administrador.adapter.AttendanceRecyclerAdapter;
import com.idigital.administrador.api.IDigitalClient;
import com.idigital.administrador.api.IDigitalService;
import com.idigital.administrador.entities.Atendance;
import com.idigital.administrador.response.AllAtendanceResponse;
import com.idigital.administrador.util.SimpleDividerItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendanceFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    static final String TAG = AttendanceFragment.class.getSimpleName();
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeLayout;
    private Unbinder unbinder;
    AttendanceRecyclerAdapter recyclerAdapter;
    boolean onInitLoad;
    TestConnectionAndFetchAttendanceAsyncTask task;
    Call<AllAtendanceResponse> call;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_attendance, container, false);
        unbinder = ButterKnife.bind(this, v);
        setUpViews();

        task = (TestConnectionAndFetchAttendanceAsyncTask) new TestConnectionAndFetchAttendanceAsyncTask().execute();
        return v;
    }

    @Override
    public void onRefresh() {
        task = (TestConnectionAndFetchAttendanceAsyncTask) new TestConnectionAndFetchAttendanceAsyncTask().execute();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        task.cancel(true);
        if(call != null)
            call.cancel();
    }

    private void fetchData() {

        IDigitalService service = IDigitalClient.getIDigitalService();
        call = service.getAllAtendance();
        call.enqueue(new Callback<AllAtendanceResponse>() {
            @Override
            public void onResponse(Call<AllAtendanceResponse> call, Response<AllAtendanceResponse> response) {

                if (response.isSuccessful()) {

                    Log.i(TAG, "correct");
                    AllAtendanceResponse responseData = response.body();
                    if (onInitLoad) {
                        onInitLoad = false;
                        fillRecycler(responseData.getData());
                    } else
                        updateRecycler(responseData.getData());
                } else {
                    Toast.makeText(getContext(), "Error loading data", Toast.LENGTH_SHORT);
                }
                swipeLayout.setRefreshing(false);

                Log.i(TAG, response.raw().toString());
            }

            @Override
            public void onFailure(Call<AllAtendanceResponse> call, Throwable t) {
                Log.i(TAG, "failure");
                if (!call.isCanceled()) {
                    swipeLayout.setRefreshing(false);
                } else
                    Toast.makeText(getContext(), "Call canceled", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fillRecycler(List<Atendance> data) {

        recyclerAdapter = new AttendanceRecyclerAdapter(data);
        recycler.setAdapter(recyclerAdapter);
    }

    private void updateRecycler(List<Atendance> data) {
        recyclerAdapter.updateData(data);
    }

    private void setUpViews() {

        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        recycler.setAdapter(new EmptyAdapter());
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorSchemeColors(ContextCompat.getColor(getContext(), android.R.color.holo_blue_bright),
                ContextCompat.getColor(getContext(), android.R.color.holo_green_light));
        swipeLayout.setRefreshing(true);
        onInitLoad = true;
    }

    private class TestConnectionAndFetchAttendanceAsyncTask extends TestConnectionAsyncTask {

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (!isCancelled()) {
                if (!aBoolean) {
                    if (swipeLayout.isRefreshing())
                        swipeLayout.setRefreshing(false);
                    Toast.makeText(getContext(), getResources().getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
                    return;
                } else
                    fetchData();
            }
        }
    }

    private class EmptyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}