package com.tutorials180.bnvbscsc270220.ModelClasses;

public class PostModel {

    private String userName;
    private int imageRef;

    public PostModel(String userName, int imageRef) {
        this.userName = userName;
        this.imageRef = imageRef;
    }

    public String getUserName() {
        return userName;
    }

    public int getImageRef() {
        return imageRef;
    }
}
