package com.olesia.university.service;

import com.olesia.university.model.Degree;
import com.olesia.university.model.Department;
import com.olesia.university.model.Lector;
import com.olesia.university.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;

    public int getEmployeeNumberByDepartmentName(String departmentName) {
        return repository.findByName(departmentName).getLectors().size();
    }

    public double getAverageSalaryByDepartmentName(String departmentName) {
        return repository.findAverageSalaryByDepartmentName(departmentName);
    }

    public String getDepartmentHeadNameByDepartmentName(String departmentName) {
        Lector head = repository.findByName(departmentName).getHead();
        return head.getName() + " " + head.getSurname();
    }

    public Map<Degree, Long> getDegreeStatisticsByDepartmentName(String departmentName) {
        Department department = repository.findByName(departmentName);
        return department.getLectors().stream().collect(Collectors.groupingBy(Lector::getDegree, Collectors.counting()));
    }


}
