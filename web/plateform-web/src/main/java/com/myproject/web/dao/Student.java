package com.myproject.web.dao;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_student")
@Data
public class Student {

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id")
	private String id;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "school_id", insertable = false, updatable = false)
	private String schoolId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id")
	private School school;

	@Column(name = "created_dt")
	private Date createdDt;

	@Column(name = "updated_dt")
	private Date updatedDt;

	@Column(name = "is_del")
	private String isDel;
}

