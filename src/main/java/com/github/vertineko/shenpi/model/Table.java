package com.github.vertineko.shenpi.model;

import java.util.List;

public class Table<T> {
    private int sum;
    private List<T> data;
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


}
