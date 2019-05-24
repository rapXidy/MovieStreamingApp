package com.chidii.mymovies.Models;

public class Slide {

    private int Image ;
    private String Title;

    public Slide(int image, String title) {
        Image = image;
        Title = title;
        //add more fields as you go, if neccessary
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
