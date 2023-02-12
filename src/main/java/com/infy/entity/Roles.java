package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.dto.Role;
import com.infy.dto.RolesDTO;

@Entity
@Table(name="roles")
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	@Enumerated(EnumType.STRING)
	private Role roleType;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Role getRoleType() {
		return roleType;
	}
	public void setRoleType(Role role) {
		this.roleType = role;
	}

	public RolesDTO getRolesDTOFromRoles() {
		RolesDTO roleDTO = new RolesDTO();
		roleDTO.setRoleId(this.getRoleId());
		roleDTO.setRoleType(this.getRoleType());
		
		return roleDTO;
	}
	
	public static Roles getRolesFromRolesDTO(RolesDTO rolesDTO) {
		Roles role = new Roles();
		role.setRoleId(rolesDTO.getRoleId());
		role.setRoleType(rolesDTO.getRoleType());
		
		return role;
	}
}
