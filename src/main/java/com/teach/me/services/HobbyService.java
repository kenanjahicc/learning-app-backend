package com.teach.me.services;

import com.teach.me.models.entities.Hobby;
import com.teach.me.repositories.HobbyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HobbyService {

    private final HobbyRepository hobbyRepository;

    HobbyService(HobbyRepository hobbyRepository){ this.hobbyRepository = hobbyRepository;}

    public String getHobbyDescription(long id){
        Optional<Hobby> hobby =  hobbyRepository.findById(id);
        return hobby.get().getDescription();
    }
    public Hobby getHobby(long id){
        Optional<Hobby> hobby = hobbyRepository.findById(id);
        return hobby.get();
    }
}
