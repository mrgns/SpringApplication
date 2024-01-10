package com.spring.SpringApplication.entity;

import java.io.Serializable;

import org.hibernate.annotations.WhereJoinTable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="employee_master")
public class EmployeeMaster implements Serializable {
	
	private static final long serialVersionUID = 6675149237035746821L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Staff_ID")
	private Integer staffId;

	@Column(name = "Password")
	private String password;

	@Column(name = "User_Id")
	private String userID;

	@Column(name = "F_Name")
	private String firstName; // first_name

	@Column(name = "M_Name")
	private String middleName; // middle_name

	@Column(name = "L_Name")
	private String lastName;

	@Column(name = "Email_Id")
	private String emailID;

	@Column(name = "Manager_ID")
	private Integer managerID;

	@Column(name = "Emp_Job_Title")
	private String employeeJobTitle;

	@Column(name = "role")
	private String role;
	
	@ManyToOne
	@JoinColumn(name = "role_id" ,insertable = false,updatable = false)
	 @WhereJoinTable(clause = "role_id <> 0")
	private RoleMatser roles;
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
//			CascadeType.REFRESH })
//	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private List<RoleMatser> employeeRole = new ArrayList<RoleMatser>();
	

}
