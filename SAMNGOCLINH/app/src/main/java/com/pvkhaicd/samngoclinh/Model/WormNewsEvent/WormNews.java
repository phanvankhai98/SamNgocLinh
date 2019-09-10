package com.pvkhaicd.samngoclinh.Model.WormNewsEvent;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WormNews {

    @SerializedName("worm")
    @Expose
    private List<Worm> worm = null;

    public List<Worm> getWorm() {
        return worm;
    }

    public void setWorm(List<Worm> worm) {
        this.worm = worm;
    }

}