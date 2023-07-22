package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("Normal");
		user.setSignupDate(LocalDateTime.now());
		return repo.save(user);
	}

	private void encodePassword(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	}

	public User findByEmail(String name) {
		return repo.findByEmail(name);
	}

	public User getUserByEmail(String userEmail) {

		return repo.getUserByEmail(userEmail);
	}

	public Optional<User> findById(int userid) {
		return repo.findById(userid);
	}

	public User saveencode(User user) {

		Boolean isUpdatingUser = (user.getUserId() != null);
		if (isUpdatingUser) {
			User exstingUser = repo.findById(user.getUserId()).get();
			if (user.getPassword().isEmpty()) {
				user.setPassword(exstingUser.getPassword());
			} else {
				encodePassword(user);
			}
		} else {
			encodePassword(user);
		}
		return repo.save(user);

	}

	public Optional<User> findByID(String username) {
		return repo.finByID(username);
	}

	public boolean isEmailUnique(Integer id, String email) {
		User userByEmail = repo.getUserByEmail(email); // null이면 중복되지 않은 것.
		if (userByEmail == null)
			return true;

		boolean isCreatingNew = (id == null);

		if (isCreatingNew) {
			if (userByEmail != null)
				return false;
		} else {
			if (userByEmail.getUserId() != id) {
				return false;
			}
		}
		return true;
	}

	public void delete(int userId) {
		repo.deleteById(userId);

	}

	public User get(Integer userId) throws Exception {
		try {
			return repo.findById(userId).get();

		} catch (NoSuchElementException ex) {
			throw new Exception("Could not find any user with ID " + userId);

		}
	}

}