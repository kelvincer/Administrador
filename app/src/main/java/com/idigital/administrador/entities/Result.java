package com.idigital.administrador.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USUARIO on 21/07/2017.
 */

public class Result {

    @SerializedName("id_attendance")
    @Expose
    private String idAttendance;
    @SerializedName("date_show")
    @Expose
    private String dateShow;
    @SerializedName("attempts")
    @Expose
    private String attempts;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("type_control")
    @Expose
    private String typeControl;
    @SerializedName("movement")
    @Expose
    private String movement;
    @SerializedName("move_flag")
    @Expose
    private String moveFlag;
    @SerializedName("deleted")
    @Expose
    private String deleted;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("observation")
    @Expose
    private String observation;
    @SerializedName("date_add")
    @Expose
    private String dateAdd;
    @SerializedName("date_upd")
    @Expose
    private String dateUpd;
    @SerializedName("id_user_schedule")
    @Expose
    private Object idUserSchedule;
    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("id_headquarter")
    @Expose
    private String idHeadquarter;
    @SerializedName("id_attendance_category")
    @Expose
    private String idAttendanceCategory;
    @SerializedName("user_register")
    @Expose
    private String userRegister;
    @SerializedName("date_user_register")
    @Expose
    private Object dateUserRegister;
    @SerializedName("last_user_register")
    @Expose
    private String lastUserRegister;
    @SerializedName("last_date_register")
    @Expose
    private Object lastDateRegister;
    @SerializedName("sede")
    @Expose
    private String sede;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("hora")
    @Expose
    private String hora;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("categoria")
    @Expose
    private String categoria;

    public String getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(String idAttendance) {
        this.idAttendance = idAttendance;
    }

    public String getDateShow() {
        return dateShow;
    }

    public void setDateShow(String dateShow) {
        this.dateShow = dateShow;
    }

    public String getAttempts() {
        return attempts;
    }

    public void setAttempts(String attempts) {
        this.attempts = attempts;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTypeControl() {
        return typeControl;
    }

    public void setTypeControl(String typeControl) {
        this.typeControl = typeControl;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getMoveFlag() {
        return moveFlag;
    }

    public void setMoveFlag(String moveFlag) {
        this.moveFlag = moveFlag;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(String dateUpd) {
        this.dateUpd = dateUpd;
    }

    public Object getIdUserSchedule() {
        return idUserSchedule;
    }

    public void setIdUserSchedule(Object idUserSchedule) {
        this.idUserSchedule = idUserSchedule;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdHeadquarter() {
        return idHeadquarter;
    }

    public void setIdHeadquarter(String idHeadquarter) {
        this.idHeadquarter = idHeadquarter;
    }

    public String getIdAttendanceCategory() {
        return idAttendanceCategory;
    }

    public void setIdAttendanceCategory(String idAttendanceCategory) {
        this.idAttendanceCategory = idAttendanceCategory;
    }

    public String getUserRegister() {
        return userRegister;
    }

    public void setUserRegister(String userRegister) {
        this.userRegister = userRegister;
    }

    public Object getDateUserRegister() {
        return dateUserRegister;
    }

    public void setDateUserRegister(Object dateUserRegister) {
        this.dateUserRegister = dateUserRegister;
    }

    public String getLastUserRegister() {
        return lastUserRegister;
    }

    public void setLastUserRegister(String lastUserRegister) {
        this.lastUserRegister = lastUserRegister;
    }

    public Object getLastDateRegister() {
        return lastDateRegister;
    }

    public void setLastDateRegister(Object lastDateRegister) {
        this.lastDateRegister = lastDateRegister;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
