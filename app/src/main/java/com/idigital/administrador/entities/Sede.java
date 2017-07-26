package com.idigital.administrador.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by USUARIO on 25/07/2017.
 */

public class Sede {

    @SerializedName("id_sede")
    @Expose
    private String idSede;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("usuarios")
    @Expose
    private List<Usuario> usuarios;

    public String getIdSede() {
        return idSede;
    }

    public void setIdSede(String idSede) {
        this.idSede = idSede;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
