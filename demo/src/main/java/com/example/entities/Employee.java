package com.example.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codemeploye;
	private String nomemployee;
	@ManyToOne
	@JoinColumn(name="code_emp_sup")
	private Employee employesup;
	@ManyToMany
	@JoinTable(name="EMP_GR")
	private Collection<Groupe> groupes;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String nomemployee) {
		super();
		this.nomemployee = nomemployee;
	}
	public Long getCodemeploye() {
		return codemeploye;
	}
	public void setCodemeploye(Long codemeploye) {
		this.codemeploye = codemeploye;
	}
	public String getNomemployee() {
		return nomemployee;
	}
	public void setNomemployee(String nomemployee) {
		this.nomemployee = nomemployee;
	}
	@JsonIgnore
	public Employee getEmployesup() {
		return employesup;
	}
	@JsonSetter
	public void setEmployesup(Employee employesup) {
		this.employesup = employesup;
	}
	@JsonIgnore
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	
	
	

}
