package com.caregiverproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caregiverproject.entity.Caregiver;

public interface CaregiverRepository extends JpaRepository<Caregiver, Integer> {

}
