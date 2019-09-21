package com.pvkhaicd.samngoclinh.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question implements Parcelable {

    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("question")
    @Expose
    private String mQuestion;
    @SerializedName("date")
    @Expose
    private String mDate;
    @SerializedName("publisher")
    @Expose
    private String mPublisher;
    @SerializedName("is_answered")
    @Expose
    private boolean isAnswered;
    @SerializedName("answer")
    @Expose
    private String mAnswer;

    public Question(int id, String question, String date, String publisher, boolean isAnswered, String answer) {
        this.mId = id;
        this.mQuestion = question;
        this.mDate = date;
        this.mPublisher = publisher;
        this.isAnswered = isAnswered;
        this.mAnswer = answer;
    }

    protected Question(Parcel in) {
        mId = in.readInt();
        mQuestion = in.readString();
        mDate = in.readString();
        mPublisher = in.readString();
        isAnswered = in.readByte() != 0;
        mAnswer = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        this.mQuestion = question;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public String getPublisher() {
        return mPublisher;
    }

    public void setPublisher(String publisher) {
        this.mPublisher = publisher;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        this.isAnswered = answered;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public void setAnswer(String answer) {
        this.mAnswer = answer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mQuestion);
        dest.writeString(mDate);
        dest.writeString(mPublisher);
        dest.writeByte((byte) (isAnswered ? 1 : 0));
        dest.writeString(mAnswer);
    }
}
