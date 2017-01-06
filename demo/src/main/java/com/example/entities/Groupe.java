package com.example.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="GROUPES")
public class Groupe implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeGroupe;
	private String nomgroupe;
	@ManyToMany(mappedBy="groupes")
	private Collection<Employee> employes;
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groupe(String nomgroupe) {
		super();
		this.nomgroupe = nomgroupe;
	}
	public Long getCodeGroupe() {
		return codeGroupe;
	}
	public void setCodeGroupe(Long codeGroupe) {
		this.codeGroupe = codeGroupe;
	}
	public String getNomgroupe() {
		return nomgroupe;
	}
	public void setNomgroupe(String nomgroupe) {
		this.nomgroupe = nomgroupe;
	}
	public Collection<Employee> getEmployes() {
		return employes;
	}
	public void setEmployes(Collection<Employee> employes) {
		this.employes = employes;
	}
	
	

}
