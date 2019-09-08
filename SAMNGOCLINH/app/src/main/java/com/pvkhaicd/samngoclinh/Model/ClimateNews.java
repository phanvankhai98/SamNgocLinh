package com.pvkhaicd.samngoclinh.Model;

import java.io.Serializable;

public class ClimateNews implements Serializable {
    String title;
    String content;

    public ClimateNews(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public ClimateNews() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
