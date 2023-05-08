package com.teach.me.repositories;

import com.teach.me.models.entities.Message;
import com.teach.me.models.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {



}
