package com.caregiverproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caregiverproject.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
