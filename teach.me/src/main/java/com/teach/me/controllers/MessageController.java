package com.teach.me.controllers;

import com.teach.me.models.MessageDto;
import com.teach.me.services.MessageService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/message")
@RestController
public class MessageController {
@GetMapping ("/{id}")
    public MessageDto getMessage (@PathVariable long id){
    MessageDto x;
    x= MessageService.getMessage(id);
    return x;

}
@PostMapping
    public boolean AddMessage(@RequestBody MessageDto x){
    return MessageService.addingMessage(x);

}
@PatchMapping
public void editMessage(@RequestBody MessageDto x){
    MessageService.editMessage(x);

}

}
