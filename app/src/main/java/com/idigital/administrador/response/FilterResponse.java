package com.idigital.administrador.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.idigital.administrador.entities.Result;

import java.util.List;

/**
 * Created by USUARIO on 21/07/2017.
 */

public class FilterResponse {

    @SerializedName("data")
    @Expose
    private List<Result> data = null;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("blocking")
    @Expose
    private Boolean blocking;

    public List<Result> getData() {
        return data;
    }

    public void setData(List<Result> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getBlocking() {
        return blocking;
    }

    public void setBlocking(Boolean blocking) {
        this.blocking = blocking;
    }
}
