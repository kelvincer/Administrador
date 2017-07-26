package com.idigital.administrador.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USUARIO on 26/07/2017.
 */

public class Category {

    @SerializedName("id_attendance_category")
    @Expose
    private String idAttendanceCategory;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("flag")
    @Expose
    private String flag;

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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
