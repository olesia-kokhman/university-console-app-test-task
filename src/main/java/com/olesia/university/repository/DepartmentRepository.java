package com.olesia.university.repository;

import com.olesia.university.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String departmentName);

    @Query("SELECT avg(lector.salary) FROM Lector lector JOIN lector.departments dep WHERE dep.name = :departmentName")
    Optional<Double> findAverageSalaryByDepartmentName(@Param("departmentName") String departmentName);

}
