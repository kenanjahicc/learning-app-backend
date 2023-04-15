package com.teach.me.services;

import com.teach.me.models.MessageDto;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageService {

    public static MessageDto getMessage(long id){

        return new MessageDto (id,"TestSender","TestReciever","testContent",new Date());

    }
    public static boolean addingMessage (MessageDto x){
        return true;

    }
    public static void editMessage (MessageDto x){
        x.setContent("new Message content");
    }
    public static void dltMessage (MessageDto x){
        x.setContent("Message has been deleted");
    }

}
