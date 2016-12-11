package com.example.administrator.mvp.entity;

import java.io.Serializable;


public class BookTagEntity implements Serializable{
    private int count;
    private String name;
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookTagEntity{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
