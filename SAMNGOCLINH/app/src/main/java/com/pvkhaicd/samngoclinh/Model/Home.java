package com.pvkhaicd.samngoclinh.Model;

public class Home {
    private String mTagName;
    private String mTitle;
    private int mIconSource;

    public Home(String tagName, String title, int iconSource) {
        mTagName = tagName;
        mTitle = title;
        mIconSource = iconSource;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getIconSource() {
        return mIconSource;
    }

    public void setIconSource(int iconSource) {
        mIconSource = iconSource;
    }

    public String getTagName() {
        return mTagName;
    }

    public void setTagName(String tagName) {
        mTagName = tagName;
    }
}
