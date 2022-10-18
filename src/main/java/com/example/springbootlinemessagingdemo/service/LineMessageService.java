package com.example.springbootlinemessagingdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springbootlinemessagingdemo.dao.MessageInfoDao;
import com.example.springbootlinemessagingdemo.dto.SendMessageDto;
import com.example.springbootlinemessagingdemo.model.LineMessage;
import com.example.springbootlinemessagingdemo.repository.LineMessageRepository;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;

@Component
public class LineMessageService {
    @Autowired
    private LineMessageRepository lineMessageRepository;

    public void handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        TextMessageContent message = event.getMessage();
        LineMessage lineMessage = new LineMessage();
        String userId = event.getSource().getUserId();
        LineMessage document = lineMessageRepository.findById(userId).orElse(null);
        List<MessageInfoDao> daos = new ArrayList<>();
        if (document != null) {
            daos = document.getMessageHistory();
        }
        MessageInfoDao dao = new MessageInfoDao();
        dao.setMessage(message.getText());
        dao.setReplytoken(event.getReplyToken());
        dao.setTimeStamp(event.getTimestamp().toString());
        daos.add(dao);

        lineMessage.setUserId(event.getSource().getUserId());
        lineMessage.setMessageHistory(daos);
        lineMessageRepository.save(lineMessage);
    }
}
