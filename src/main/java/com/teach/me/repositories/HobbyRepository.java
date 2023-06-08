package com.teach.me.repositories;


import com.teach.me.models.entities.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {

}
