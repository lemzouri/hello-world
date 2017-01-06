package com.example.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)   // heritage on utulise une seule table
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
@Type(name="CC",value=CompteCourant.class),
@Type(name="CE",value=CompteEpargne.class)})
@XmlSeeAlso({CompteCourant.class,CompteEpargne.class})
public abstract class Compte implements Serializable {
	@Id
	private String codecompte;
	private Date datecreation;
	private double solde;
	@ManyToOne   // un compte d un seul client et un client peut avoir plusieur compte
	@JoinColumn(name="CODE_CLI")
	private Client client;
	@ManyToOne   // un compte d un seul client et un client peut avoir plusieur compte
	@JoinColumn(name="CODE_EMP")
	private Employee employee;
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String codecompte, Date datecreation, double solde) {
		super();
		this.codecompte = codecompte;
		this.datecreation = datecreation;
		this.solde = solde;
	}
	public String getCodecompte() {
		return codecompte;
	}
	public void setCodecompte(String codecompte) {
		this.codecompte = codecompte;
	}
	public Date getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	
	
	

}
