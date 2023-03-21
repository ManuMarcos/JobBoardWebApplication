package com.jobboard.enumerations;

public enum Status {
    OPEN("open"), CLOSE("close");

    private final String status;

    private Status(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
