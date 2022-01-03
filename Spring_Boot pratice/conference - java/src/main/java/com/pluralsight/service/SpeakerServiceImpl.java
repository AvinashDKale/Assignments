package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateRepositoryImpl;
import com.pluralsight.repository.SpeakersRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakersRepository repository;

    public SpeakerServiceImpl(SpeakersRepository speakersRepository){
        repository=speakersRepository;
    }

    @Override
    public List<Speaker> findAll(){
        return repository.findAll();
    }


    public void setRepository(SpeakersRepository repository) {
        this.repository = repository;



    }
}
