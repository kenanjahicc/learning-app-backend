package com.teach.me.services;

import com.teach.me.models.MessageDto;
import com.teach.me.models.entities.Message;
import com.teach.me.repositories.MessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageDto getMessage(long id){
        Message b = messageRepository.findById(id).get();
       return new MessageDto(b.getId(), b.getSender(), b.getReceiver(), b.getContent(),b.getTime());
    }

    public List<MessageDto> getMessages (String username, String usertwo){
        List<Message> lista = messageRepository.findAll();
        List<MessageDto> listadto = new ArrayList<>();

        for (Message a:lista) {
            if(a.getReceiver()==null||a.getSender()==null){

            }
            else if (((a.getReceiver().equals(username) || a.getSender().equals(username))) &&
                    ((a.getSender().equals(usertwo) || a.getReceiver().equals(usertwo)))) {
                listadto.add(new MessageDto(a.getId(), a.getSender(), a.getReceiver(), a.getContent(), a.getTime()));
            }
        }
        return listadto;
    }

    public ResponseEntity<String> addMessage(Message message) {
        messageRepository.save(message);
        return ResponseEntity.ok("Message added");
    }
}
