package com.example.OneToOne.Repositories;

import com.example.OneToOne.model.EmployeeAddress;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpAddRepo extends JpaRepository <EmployeeAddress, Integer> {
}
