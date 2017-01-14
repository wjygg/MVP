package com.example.administrator.mvp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/14.
 */

public class BeautyGirInfo implements Serializable{

    private String error;

    private List<BeautyGirDetail> results;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<BeautyGirDetail> getResults() {
        return results;
    }

    public void setResults(List<BeautyGirDetail> results) {
        this.results = results;
    }
}
