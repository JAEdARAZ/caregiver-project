package com.caregiverproject.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="caregiver")
public class Caregiver {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="colour")
	private String colour;
	
	@ManyToMany(mappedBy = "caregivers") //reference to the List of Caregivers in Client entity
	private Set<Client> clients;

	public Caregiver () {}

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

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Caregiver [id=" + id + ", name=" + name + ", colour=" + colour + "]";
	}

	public void addClient(Client newClient) {
		if (this.clients == null) {
			this.clients = new HashSet<>();
		}
		
		this.clients.add(newClient);
	}
	
}
