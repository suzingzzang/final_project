package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UsedBook;

@Repository
public interface UsedBookRepository extends PagingAndSortingRepository<UsedBook, Integer> {

}
