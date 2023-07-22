package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@Column(name="role_name", length = 16, nullable = false, unique = true)
	private String roleName;
	
	public Role(){}

	@Override
	public String toString() {
		return "Role [roleName=" + roleName + "]";
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

}
