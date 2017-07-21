package com.idigital.administrador.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USUARIO on 21/07/2017.
 */

public class Atendance {

    @SerializedName("id_attendance")
    @Expose
    private String idAttendance;
    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("date_show")
    @Expose
    private String dateShow;
    @SerializedName("id_headquarter")
    @Expose
    private String idHeadquarter;
    @SerializedName("sede")
    @Expose
    private String sede;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("movement")
    @Expose
    private String movement;
    @SerializedName("id_attendance_category")
    @Expose
    private String idAttendanceCategory;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("state")
    @Expose
    private String state;

    public String getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(String idAttendance) {
        this.idAttendance = idAttendance;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDateShow() {
        return dateShow;
    }

    public void setDateShow(String dateShow) {
        this.dateShow = dateShow;
    }

    public String getIdHeadquarter() {
        return idHeadquarter;
    }

    public void setIdHeadquarter(String idHeadquarter) {
        this.idHeadquarter = idHeadquarter;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getIdAttendanceCategory() {
        return idAttendanceCategory;
    }

    public void setIdAttendanceCategory(String idAttendanceCategory) {
        this.idAttendanceCategory = idAttendanceCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
