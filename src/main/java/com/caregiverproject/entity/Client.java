package com.caregiverproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="old_client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
		name="carer_client",
		joinColumns=@JoinColumn(name="id_client"),
		inverseJoinColumns=@JoinColumn(name="id_caregiver")
	)
	private List<Caregiver> caregivers;

	public Client() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Caregiver> getCaregivers() {
		return caregivers;
	}

	public void setCaregivers(List<Caregiver> caregivers) {
		this.caregivers = caregivers;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + "]";
	}
	
	public void addCaregiver(Caregiver newCaregiver) {
		if(this.caregivers == null) {
			this.caregivers = new ArrayList<>();
		}
		
		this.caregivers.add(newCaregiver);
	}
	
}
