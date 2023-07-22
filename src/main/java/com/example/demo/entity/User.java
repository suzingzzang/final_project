package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(length = 32, nullable = false, unique = true)
	private String email;

	@Column(length = 256, nullable = false)
	private String password;

	@Column(length = 16, nullable = false)
	private String name;

	@Column(length = 32, nullable = false)
	private String phone;

	@Column(length = 45)
	private String photo;

	@Column(length = 128, nullable = false)
	private String address;

	@Column(name = "signup_date", length = 255, nullable = false)
	private LocalDateTime signupDate;

	@Column
	private boolean enabled = true;

	@Column(length = 16, nullable = false)
	private String role;

	public User() {
	}

	public User(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", photo=" + photo + ", address=" + address + ", signupDate=" + signupDate + ", enabled="
				+ enabled + ", role=" + role + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(LocalDateTime signupDate) {
		this.signupDate = signupDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Transient
	public String getPhotosImagePath() {
		if (userId == null || photo == null)
			return "/images/default-user.png";
		return "/user-photos/" + this.userId + "/" + this.photo;
	}

}