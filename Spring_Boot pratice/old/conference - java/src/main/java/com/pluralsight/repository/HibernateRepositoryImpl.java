package com.pluralsight.repository;

import com.pluralsight.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class HibernateRepositoryImpl implements SpeakersRepository {
    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers=new ArrayList<Speaker>();
        Speaker speaker = new Speaker();
        speaker.setFirstname("Bryan");
        speaker.setLastname("Hansen");
        speakers.add(speaker);


return speakers;
    }
}
