package com.codegym.repository.EmployeeRepository;

import com.codegym.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepsitory extends JpaRepository<Division, Integer> {
}
