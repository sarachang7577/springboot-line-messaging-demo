package com.example.springbootlinemessagingdemo.dao;

public class MessageInfoDao {
    private String message;
    private String replytoken;
    private String timeStamp;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReplytoken() {
        return replytoken;
    }

    public void setReplytoken(String replytoken) {
        this.replytoken = replytoken;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
