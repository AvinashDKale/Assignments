package com.springWeb2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springWeb2.entity.BookDao;

@Repository
public interface LibraryRepository extends JpaRepository<BookDao, Integer> {

	@Query(value = "select * from library_table  where id like %:keyword% or title like %:keyword% or author like %:keyword%", nativeQuery = true)
	 List<BookDao> findByKeyword(@Param("keyword") String keyword);
}
