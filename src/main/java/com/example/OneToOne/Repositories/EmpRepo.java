package com.example.OneToOne.Repositories;

import com.example.OneToOne.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee, Integer> {
}
