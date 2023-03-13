package com.example.w3d1;

import android.graphics.drawable.Drawable;

// POJO : Plain old java object
class Tweet {
    private String text;
    private Drawable image;

    public Tweet(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
