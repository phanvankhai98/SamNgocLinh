package com.pvkhaicd.samngoclinh.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarketItem implements Parcelable {

    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("phone_number")
    @Expose
    private String mPhoneNumber;
    @SerializedName("weight")
    @Expose
    private String mWeight;
    @SerializedName("type")
    @Expose
    private String mType;
    @SerializedName("cost")
    @Expose
    private String mCost;
    @SerializedName("address")
    @Expose
    private String mAddress;
    @SerializedName("time")
    @Expose
    private String mTime;
    @SerializedName("county")
    @Expose
    private String mCounty;
    @SerializedName("publisher")
    @Expose
    private String mPublisher;

    public MarketItem(int id, String phoneNumber, String weight, String type, String cost, String address, String time, String county, String publisher) {
        mId = id;
        mPhoneNumber = phoneNumber;
        mWeight = weight;
        mType = type;
        mCost = cost;
        mAddress = address;
        mTime = time;
        mCounty = county;
        mPublisher = publisher;
    }

    public MarketItem(String phoneNumber, String weight, String cost, String address, String time, String county, String publisher) {
        mPhoneNumber = phoneNumber;
        mWeight = weight;
        mCost = cost;
        mAddress = address;
        mTime = time;
        mCounty = county;
        mPublisher = publisher;
    }

    protected MarketItem(Parcel in) {
        mId = in.readInt();
        mPhoneNumber = in.readString();
        mWeight = in.readString();
        mType = in.readString();
        mCost = in.readString();
        mAddress = in.readString();
        mTime = in.readString();
        mCounty = in.readString();
        mPublisher = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mPhoneNumber);
        dest.writeString(mWeight);
        dest.writeString(mType);
        dest.writeString(mCost);
        dest.writeString(mAddress);
        dest.writeString(mTime);
        dest.writeString(mCounty);
        dest.writeString(mPublisher);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MarketItem> CREATOR = new Creator<MarketItem>() {
        @Override
        public MarketItem createFromParcel(Parcel in) {
            return new MarketItem(in);
        }

        @Override
        public MarketItem[] newArray(int size) {
            return new MarketItem[size];
        }
    };

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getWeight() {
        return mWeight;
    }

    public void setWeight(String weight) {
        mWeight = weight;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getCost() {
        return mCost;
    }

    public void setCost(String cost) {
        mCost = cost;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getCounty() {
        return mCounty;
    }

    public void setCounty(String county) {
        mCounty = county;
    }

    public String getPublisher() {
        return mPublisher;
    }

    public void setPublisher(String publisher) {
        mPublisher = publisher;
    }

    public String getBlurPhoneNumber(){
        String phone = mPhoneNumber.substring(0,mPhoneNumber.length()-3);
        return phone+"***";
    }
}
