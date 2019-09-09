package com.pvkhaicd.samngoclinh.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClimateN {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("climate")
    @Expose
    private List<Climate> climate = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Climate> getClimate() {
        return climate;
    }

    public void setClimate(List<Climate> climate) {
        this.climate = climate;
    }

}