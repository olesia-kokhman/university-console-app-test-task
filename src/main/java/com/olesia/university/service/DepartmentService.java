package com.olesia.university.service;

import com.olesia.university.model.Degree;
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
        return repository.findByName(departmentName).map(department -> department.getLectors().size()).orElse(0);
    }

    public double getAverageSalaryByDepartmentName(String departmentName) {
        return repository.findAverageSalaryByDepartmentName(departmentName).orElse(0.0);
    }

    public String getDepartmentHeadNameByDepartmentName(String departmentName) {
        return repository.findByName(departmentName).map(department -> {
            Lector head = department.getHead();
            return head.getName() + " " + head.getSurname();
        }).orElse("no department head was set yet");
    }

    public String getDegreeStatisticsByDepartmentName(String departmentName) {
        return repository.findByName(departmentName).map(department -> {
                    Map<Degree, Long> statisticsByDegree = department.getLectors().stream()
                            .collect(Collectors.groupingBy(Lector::getDegree, Collectors.counting()));
                    return "Assistants - " + statisticsByDegree.getOrDefault(Degree.ASSISTANT, 0L) + ",\n" +
                            "Associate professors - " + statisticsByDegree.getOrDefault(Degree.ASSOCIATE_PROFESSOR, 0L) + ",\n" +
                            "Professors - " + statisticsByDegree.getOrDefault(Degree.PROFESSOR, 0L) + ".";

                })
                .orElse("No lectors were found in department {" + departmentName + "}.");
    }


}
