package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Review;

@Repository
public interface ReviewRepository extends PagingAndSortingRepository<Review, Integer> {

//	@Query("SELECT r FROM Review r WHERE r.book=:book")
//	public List<Object> findByBookid(@Param("book") Book book);

	@Query("SELECT r FROM Review r WHERE r.book =:book ORDER BY r.commentDate DESC")
	public List<Review> findByBookid(@Param("book") Book book);

	@Query("SELECT COUNT(r.book) FROM Review r WHERE r.book=:book")
	public Float countbook(@Param("book") Book book);

	@Query("SELECT SUM(r.starRating) FROM Review r WHERE r.book=:book")
	public Float sumstar(@Param("book") Book book);

}