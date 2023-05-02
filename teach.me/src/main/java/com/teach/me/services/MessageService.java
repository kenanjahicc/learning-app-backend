package com.teach.me.services;

import com.teach.me.models.MessageDto;
import com.teach.me.models.entities.Message;
import com.teach.me.repositories.MessageRepository;
import org.hibernate.collection.spi.PersistentList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageDto getMessage(long id){
        Message b = messageRepository.findById(id).get();
       return new MessageDto(b.getId(), b.getSender(), b.getReciever(), b.getContent(),b.getTime());
    }

    public List<MessageDto> getMessages (){
        List<Message> lista = messageRepository.findAll();
        List<MessageDto> listadto = new ArrayList<>();

        for (Message a:lista) {
            listadto.add(new MessageDto(a.getId(),a.getSender(),a.getReciever(),a.getContent(),a.getTime()));

        }
        return listadto;
    }
}
