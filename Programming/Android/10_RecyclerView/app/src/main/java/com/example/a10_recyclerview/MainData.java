package com.example.a10_recyclerview;

/**
 * @ MaidData Class
 * Image, name, content
 */
public class MainData {

    private int profileImageView;
    private String nameTextView;
    private String contentTextView;

    public MainData(int profileImageView, String nameTextView, String contentTextView) {
        this.profileImageView = profileImageView;
        this.nameTextView = nameTextView;
        this.contentTextView = contentTextView;
    }

    public int getProfileImageView() {
        return profileImageView;
    }

    public void setProfileImageView(int profileImageView) {
        this.profileImageView = profileImageView;
    }

    public String getNameTextView() {
        return nameTextView;
    }

    public void setNameTextView(String nameTextView) {
        this.nameTextView = nameTextView;
    }

    public String getContentTextView() {
        return contentTextView;
    }

    public void setContentTextView(String contentTextView) {
        this.contentTextView = contentTextView;
    }
}
