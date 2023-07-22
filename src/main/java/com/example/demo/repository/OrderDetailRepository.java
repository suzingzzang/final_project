package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.User;

@Repository
public interface OrderDetailRepository extends PagingAndSortingRepository<OrderDetail, Integer> {

	@Query("SELECT o FROM OrderDetail o WHERE o.order =:order")
	public List<OrderDetail> findOrderDetailsByOrder(@Param("order") Order order);
	
	@Query("SELECT od FROM OrderDetail od JOIN FETCH od.book WHERE od.order.user = :user")
	public List<OrderDetail> findOrderDetailsByUser(@Param("user") User user);

}
