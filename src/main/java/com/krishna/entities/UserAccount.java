package com.krishna.entities;

import java.time.LocalDate;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String username;
	private String email;
	private Long phNo;
	private String gender;
	private LocalDate dob;
	private Long SSN;
	private String activeSw="Y";
	@CreationTimestamp
	@Column(name="created_date", updatable = false)
	private LocalDate createdDate;
	@UpdateTimestamp
	@Column(name="last_modified", insertable = false)
	private LocalDate updatedDate;

}
