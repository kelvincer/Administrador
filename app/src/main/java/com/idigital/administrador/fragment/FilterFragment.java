package com.idigital.administrador.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.idigital.administrador.R;
import com.idigital.administrador.TestConnectionAsyncTask;
import com.idigital.administrador.adapter.SearchResultAdapter;
import com.idigital.administrador.adapter.SpinnerAdapter;
import com.idigital.administrador.api.IDigitalClient;
import com.idigital.administrador.api.IDigitalService;
import com.idigital.administrador.entities.Category;
import com.idigital.administrador.entities.Place;
import com.idigital.administrador.entities.Result;
import com.idigital.administrador.entities.User;
import com.idigital.administrador.response.CategoryResponse;
import com.idigital.administrador.response.FilterResponse;
import com.idigital.administrador.response.PlaceResponse;
import com.idigital.administrador.response.UserResponse;
import com.idigital.administrador.util.SimpleDividerItemDecoration;
import com.idigital.administrador.view.ProgressDialogView;

import java.util.ArrayList;
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

    @BindView(R.id.search_btn)
    Button searchBtn;
    @BindView(R.id.filter_recycler)
    RecyclerView filterRecycler;
    @BindView(R.id.state_spinner)
    Spinner stateSpinner;
    @BindView(R.id.sede_spinner)
    Spinner sedeSpinner;
    @BindView(R.id.user_spinner)
    Spinner userSpinner;
    @BindView(R.id.category_spinner)
    Spinner categorySpinner;
    List<Place> placeList;
    List<User> userList;
    List<Category> categoryList;
    Unbinder unbinder;
    ProgressDialogView progressDialogView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_filter, container, false);
        unbinder = ButterKnife.bind(this, v);

        setupViews();
        return v;
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

    private void setupViews() {

        setUpUserSpinner();
        setUpSedeSpinner();
        setUpStateSpinner();
        setUpCategorySpinner();
        filterRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        filterRecycler.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        searchBtn.setOnClickListener(this);
        progressDialogView = new ProgressDialogView(getContext());
    }

    private void setUpCategorySpinner() {

        categoryList = new ArrayList<>();
        IDigitalService service = IDigitalClient.getIDigitalService();
        Call<CategoryResponse> call = service.getCategories();
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if (response.isSuccessful()) {
                    CategoryResponse categoryResponse = response.body();
                    categoryList.addAll(categoryResponse.getData());
                    SpinnerAdapter adapter = new SpinnerAdapter(getContext(), R.layout.spinner_item, categoryList, 4);
                    categorySpinner.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

            }
        });
    }

    private void setUpUserSpinner() {

        userList = new ArrayList<>();
        IDigitalService service = IDigitalClient.getIDigitalService();
        Call<UserResponse> call = service.getUsers();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                if (response.isSuccessful()) {
                    UserResponse userResponse = response.body();
                    userList.addAll(userResponse.getData());
                    SpinnerAdapter adapter = new SpinnerAdapter(getContext(), R.layout.spinner_item, userList, 1);
                    userSpinner.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }

    private void setUpSedeSpinner() {

        placeList = new ArrayList<>();
        IDigitalService service = IDigitalClient.getIDigitalService();
        Call<PlaceResponse> call = service.getPlaces();
        call.enqueue(new Callback<PlaceResponse>() {
            @Override
            public void onResponse(Call<PlaceResponse> call, Response<PlaceResponse> response) {
                if (response.isSuccessful()) {
                    PlaceResponse placeResponse = response.body();
                    placeList.addAll(placeResponse.getData());
                    SpinnerAdapter adapter = new SpinnerAdapter(getContext(), R.layout.spinner_item, placeList, 2);
                    sedeSpinner.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<PlaceResponse> call, Throwable t) {

            }
        });
    }

    private void setUpStateSpinner() {

        List<String> states = new ArrayList<>();
        states.add("aprobado");
        states.add("desaprobado");
        states.add("observado");

        SpinnerAdapter adapter = new SpinnerAdapter(getContext(), R.layout.spinner_item, states, 3);
        stateSpinner.setAdapter(adapter);
    }

    private void fillRecycler(List<Result> data) {

        if (data.size() == 0) {
            Toast.makeText(getContext(), "No hay resultados en la búsqueda", Toast.LENGTH_SHORT).show();
            return;
        }

        SearchResultAdapter recyclerAdapter = new SearchResultAdapter(data);
        filterRecycler.setAdapter(recyclerAdapter);
    }

    private void fetchData() {

        IDigitalService service = IDigitalClient.getIDigitalService();
        Call<FilterResponse> call = service.searchUsers(userList.get(userSpinner.getSelectedItemPosition()).getIdUser(),
                placeList.get(sedeSpinner.getSelectedItemPosition()).getIdHeadquarter(),
                stateSpinner.getSelectedItem().toString(),
                categoryList.get(categorySpinner.getSelectedItemPosition()).getIdAttendanceCategory());
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
                t.printStackTrace();
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
