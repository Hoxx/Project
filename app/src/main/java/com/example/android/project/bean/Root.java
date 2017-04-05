package com.example.android.project.bean;

import java.util.List;

/**
 * Created by Android on 2017/3/30.
 */

public class Root {
    private boolean error;

    private List<Results> results;

    public void setError(boolean error){
        this.error = error;
    }
    public boolean getError(){
        return this.error;
    }
    public void setResults(List<Results> results){
        this.results = results;
    }
    public List<Results> getResults(){
        return this.results;
    }
}
