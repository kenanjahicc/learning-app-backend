package com.teach.me.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class MessageDto implements Comparable<MessageDto> {
    private Long id;
    private String Sender;
    private String Receiver;
    private String Content;
    private Date time;

    @Override
    public int compareTo(MessageDto o) {
        return (int) (this.time.getTime()-o.time.getTime());
    }
}
