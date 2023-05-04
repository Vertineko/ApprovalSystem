package com.github.vertineko.shenpi.model;

public class Course {
    private int id;
    private String code;
    private String name;
    private String catalory;
    private int creadit;


    public Course(int id, String code, String name, String catalory, int creadit) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.catalory = catalory;
        this.creadit = creadit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalory() {
        return catalory;
    }

    public void setCatalory(String catalory) {
        this.catalory = catalory;
    }

    public int getCreadit() {
        return creadit;
    }

    public void setCreadit(int creadit) {
        this.creadit = creadit;
    }
}
