package com.chidii.mymovies.Models;

import android.widget.ImageView;

public class Cast {

    String name;
    int img_link;

    public Cast(String name, int img_link) {
        this.name = name;
        this.img_link = img_link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg_link() {
        return img_link;
    }

    public void setImg_link(int img_link) {
        this.img_link = img_link;
    }
}
