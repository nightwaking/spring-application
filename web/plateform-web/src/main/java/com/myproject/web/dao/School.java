package com.myproject.web.dao;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_school")
@Data
public class School {
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id")
	private String id;

	@Column(name = "school_name")
	private String schoolName;

	@OneToMany(mappedBy = "school", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Student> studentList = new HashSet<>();

	@Column(name = "created_dt")
	private Date createdDt;

	@Column(name = "updated_dt")
	private Date updatedDt;

	@Column(name = "is_del")
	private String isDel;
}
