package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Payment;
import com.example.demo.entity.User;
import com.example.demo.repository.PaymentRepository;

@Service
@Transactional
public class PaymentService {

	@Autowired
	private PaymentRepository repo;

	public List<Payment> findPaymentByUser(User user) {
		return repo.findPaymentByUser(user);
	}

	public void save(Payment payment) {
		repo.save(payment);
	}

	public Payment get(int paymentId) throws Exception {
		return repo.findById(paymentId).get();
	}

	public void delete(int paymentId) {
		repo.deleteById(paymentId);
	}

	public List<Payment> findPaymentList() {
		return (List<Payment>) repo.findAll();
	}

	public void savepayment(Payment payment, User user) {
		payment.setUser(user);
		repo.save(payment);

	}

}
