package com.example.coolapp.models;

public class StudentErrorResponse {


    private String message;

    private long timeStamp;

    private int code;

    public StudentErrorResponse(){

    }

    public StudentErrorResponse(String message, long timeStamp, int code){
        this.code = code;
        this.message = message;
        this.timeStamp = timeStamp;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;

    }



}
