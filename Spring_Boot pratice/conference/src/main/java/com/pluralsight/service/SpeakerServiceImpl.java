package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateRepositoryImpl;
import com.pluralsight.repository.SpeakersRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakersRepository repository=new HibernateRepositoryImpl();


    @Override
    public List<Speaker> findAll(){
        return repository.findAll();
    }
}
