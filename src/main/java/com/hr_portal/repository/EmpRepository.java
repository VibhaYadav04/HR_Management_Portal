package com.hr_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr_portal.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {

}
