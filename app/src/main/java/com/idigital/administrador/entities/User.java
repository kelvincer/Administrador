package com.idigital.administrador.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USUARIO on 26/07/2017.
 */

public class User {

    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("id_headquarter")
    @Expose
    private String idHeadquarter;

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

    public String getIdHeadquarter() {
        return idHeadquarter;
    }

    public void setIdHeadquarter(String idHeadquarter) {
        this.idHeadquarter = idHeadquarter;
    }
}
