package com.teach.me.controllers;

import com.teach.me.models.MessageDto;
import com.teach.me.models.entities.Message;
import com.teach.me.services.MessageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message/{id}")
    public MessageDto getMessage(@PathVariable long id){
    return messageService.getMessage(id);


    }

    @GetMapping("/messages/{username}/{usertwo}")
    public List<MessageDto> getMessages(@PathVariable String username, @PathVariable String usertwo){
        return messageService.getMessages(username,usertwo);

    }

    @PostMapping(path ="/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addMessage(@RequestBody Message message){
        return messageService.addMessage(message);
    }




}
