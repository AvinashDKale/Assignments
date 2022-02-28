package com.springWeb2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springWeb2.entity.IssuedBookDao;

@Repository
public interface IssuedRepository extends JpaRepository<IssuedBookDao, Integer>{
//Title,Issued_Date,Return_Date
    @Query(nativeQuery = true,
            value="select * from library_schema.issued_books_table "
                    + "where issued_books_table.Issued_Date between :start and :end")
 List<IssuedBookDao> findByIssued_dateBetween(@Param("start") LocalDate start, @Param("end") LocalDate end);

 // public List<IssuedBookDao> findByIssued_dateBetween( LocalDate
 // startDate,LocalDate endDate);
    
//    @Query(nativeQuery = true,value="SELECT * FROM library_schema.issued_books_table where issued_books_table.Issued_for=Issued_for")
   List<IssuedBookDao> findByIssuedFor(String issued_for);
}
