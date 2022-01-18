package com.springPostmen.postmentpractice.dao;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.springPostmen.postmentpractice.model.*;

@Repository
public interface StudentRepository  extends CrudRepository<Student,Integer>{

}
