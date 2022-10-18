package com.example.springbootlinemessagingdemo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.springbootlinemessagingdemo.dao.MessageInfoDao;

@Document(collection = "lineMessage")
public class LineMessage {
    @Id
    private String userId;
    private List<MessageInfoDao> messageHistory;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<MessageInfoDao> getMessageHistory() {
        return messageHistory;
    }

    public void setMessageHistory(List<MessageInfoDao> messageHistory) {
        this.messageHistory = messageHistory;
    }

}
