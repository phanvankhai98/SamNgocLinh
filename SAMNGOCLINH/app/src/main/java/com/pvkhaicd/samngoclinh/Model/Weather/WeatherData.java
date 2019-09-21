package com.pvkhaicd.samngoclinh.Model.Weather;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherData implements Parcelable {

    @SerializedName("weather")
    @Expose
    private List<Weather> weather;
    @SerializedName("main")
    @Expose
    private Main main;

    @SerializedName("name")
    @Expose
    private String name;

    public WeatherData(List<Weather> weather, Main main, String name) {
        this.weather = weather;
        this.main = main;
        this.name = name;
    }

    protected WeatherData(Parcel in) {
        name = in.readString();
    }

    public static final Creator<WeatherData> CREATOR = new Creator<WeatherData>() {
        @Override
        public WeatherData createFromParcel(Parcel in) {
            return new WeatherData(in);
        }

        @Override
        public WeatherData[] newArray(int size) {
            return new WeatherData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
