package com.example.android.learnrecyclerview;

public class ExampleItem {

    private int mImageresource;
    private String mText1;
    private String mText2;

    public int getmImageresource() {
        return mImageresource;
    }

    public void setmImageresource(int mImageresource) {
        this.mImageresource = mImageresource;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public void setmText2(String mText2) {
        this.mText2 = mText2;
    }

    public ExampleItem(int mImageresource, String mText1, String mText2) {

        this.mImageresource = mImageresource;
        this.mText1 = mText1;
        this.mText2 = mText2;
    }
}
