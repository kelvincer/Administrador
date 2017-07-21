package com.idigital.administrador.api;

import com.idigital.administrador.response.AllAtendanceResponse;
import com.idigital.administrador.response.FilterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IDigitalService {

    @GET("attendance-all")
    Call<AllAtendanceResponse> getAllAtendance();

    @FormUrlEncoded
    @POST("attendance-search")
    Call<FilterResponse> searchUsers(@Field("id_user") String idUser,  @Field("movement") String movement,
                                     @Field("id_headquarter") String headquarter, @Field("state") String state,
                                     @Field("id_attendance_category") String category);
}
