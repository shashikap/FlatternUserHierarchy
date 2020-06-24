package com.dbs.codetest.entity;

//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.NotFound;
//import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="teamhierarchy")
public class TeamHierarchy {

	@Id
	@Column(name = "empid")
	private String empId;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="managerid")
	@JsonBackReference
	private TeamHierarchy manager;

	@NotFound(action = NotFoundAction.IGNORE)
	@OneToMany(mappedBy="manager", fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<TeamHierarchy> subUsers;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public TeamHierarchy getManager() {
		return manager;
	}

	public void setManager(TeamHierarchy manager) {
		this.manager = manager;
	}

	public Set<TeamHierarchy> getSubUsers() {
		return subUsers;
	}

	public void setSubUsers(Set<TeamHierarchy> subUsers) {
		this.subUsers = subUsers;
	}
}
