package com.example.springbootlinemessagingdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootlinemessagingdemo.dto.SendMessageDto;
import com.example.springbootlinemessagingdemo.model.LineMessage;
import com.example.springbootlinemessagingdemo.service.LineMessageService;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@RestController
@LineMessageHandler
@RequestMapping("/line")
public class LineMessageController {

    @Autowired
    LineMessageService lineMessageService;

    @GetMapping("/{userId}")
    public LineMessage getMessage(@PathVariable String userId) {
        return lineMessageService.getMessage(userId);
    }

    @GetMapping("/userIds")
    public List<String> getUserIds() {
        return lineMessageService.getUserIds();
    }

    @PostMapping("/send/text")
    public void sendTextMessage(@RequestBody SendMessageDto sendMessage) {
        lineMessageService.sendTextMessage(sendMessage);
    }

    @EventMapping
    public void handleTextMessageEvent(MessageEvent<TextMessageContent> event) throws Exception {
        lineMessageService.handleTextMessageEvent(event);
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("other event: " + event);
    }
}
