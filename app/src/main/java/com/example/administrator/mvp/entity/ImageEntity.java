package com.example.administrator.mvp.entity;

import java.io.Serializable;

/**
 * Author   :hymanme
 * Email    :hymanme@163.com
 * Create at 2016/1/8
 * Description:
 */
public class ImageEntity implements Serializable {
    private String small;
    private String medium;
    private String large;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    @Override
    public String toString() {
        return "ImageEntity{" +
                "small='" + small + '\'' +
                ", medium='" + medium + '\'' +
                ", large='" + large + '\'' +
                '}';
    }
}
