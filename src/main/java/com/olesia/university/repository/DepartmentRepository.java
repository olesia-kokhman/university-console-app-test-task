package com.olesia.university.repository;

import com.olesia.university.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String departmentName);

    @Query("SELECT avg(lector.salary) FROM Lector lector WHERE lector.department.name = :departmentName")
    Double findAverageSalaryByDepartmentName(@Param("departmentName") String departmentName);
}
