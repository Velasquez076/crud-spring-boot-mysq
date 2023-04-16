package com.learn.crudspring.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author juveme88
 *
 */
@Setter
@Getter
@Entity
@Table(name = "tbl_users")
public class UserEntity {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String nombre;

	@Column(name = "lastname")
	private String apellido;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String telefono;

}
