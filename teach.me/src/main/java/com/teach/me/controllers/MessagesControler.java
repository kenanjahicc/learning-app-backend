package com.teach.me.controllers;

import com.teach.me.models.MessageDto;
import com.teach.me.services.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/messages")
@RestController

public class MessagesControler {
    ArrayList<MessageDto>messageDtos;
    @GetMapping ("/{id}")public ArrayList<MessageDto> getMessage (@PathVariable long id){
        ArrayList<MessageDto> list = new ArrayList<>();
       MessageDto x = new MessageDto(15L,"sender1", "reciever1","poruka",new Date());
       list.add(x);
       x.setContent("poruka1test");
       x.setId(155L);
       return list;

    }
}
