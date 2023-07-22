package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="used_book")
public class UsedBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="used_book_id")
	private Integer usedBookId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	@Column(nullable = false) 
	private String status;
	
	@Column(nullable = false)
	private Integer price;
	
	public UsedBook(){}

	@Override
	public String toString() {
		return "UsedBook [usedBookId=" + usedBookId + ", user=" + user + ", book=" + book + ", status=" + status
				+ ", price=" + price + "]";
	}

	public Integer getUsedBookId() {
		return usedBookId;
	}

	public void setUsedBookId(Integer usedBookId) {
		this.usedBookId = usedBookId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
