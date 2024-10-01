package com.jbk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Data @ToString
@Entity 
@Table(name = "taskInfo")
public class Task {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message="Title is mendatory")
	private String title;
	@NotBlank(message=" description is mandatory")
	private String description;
	@NotBlank(message=" date is mendatory")
	private String date;
	@NotBlank(message="status is mendatory")
	private String status;

}
