package com.example.springbootlinemessagingdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springbootlinemessagingdemo.model.LineMessage;

public interface LineMessageRepository extends MongoRepository<LineMessage, String> {

}
