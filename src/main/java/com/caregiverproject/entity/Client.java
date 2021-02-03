package com.caregiverproject.entity;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.OneToMany;
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
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
		name="carer_client",
		joinColumns=@JoinColumn(name="id_client"),
		inverseJoinColumns=@JoinColumn(name="id_caregiver")
	)
	private Set<Caregiver> caregivers;
	
	//One client to many tasks -- 	//@JoinColumn(name="id_client") //foreign key in Task table (removed to try do bidirectional OneToMany)
	@OneToMany(mappedBy = "client", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Task> tasks;

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

	public Set<Caregiver> getCaregivers() {
		return caregivers;
	}

	public void setCaregivers(Set<Caregiver> caregivers) {
		this.caregivers = caregivers;
	}
	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + "]";
	}
	
	public void addCaregiver(Caregiver caregiver) {
		if(this.caregivers == null) {
			this.caregivers = new HashSet<>();
		}
		
		this.caregivers.add(caregiver);
	}
	
	public void deleteCaregiver(Caregiver caregiver) {
		this.caregivers.remove(caregiver);
	}
	
	public void addTask(Task task) {
		if(this.tasks == null) {
			this.tasks = new HashSet<>();
		}
		
		this.tasks.add(task);
		task.setClient(this);
	}
	
	public void deleteTask(Task task) {
		this.tasks.remove(task);
		task.setClient(null);
	}
	
}
