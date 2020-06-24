package com.dbs.codetest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "empid")
	private String empId;

	@Column(name = "accesskey")
	private String accessKey;

	@Column(name = "country")
	private String country;

}
