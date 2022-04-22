package com.codegym.repository.EmployeeRepository;

import com.codegym.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {
}
