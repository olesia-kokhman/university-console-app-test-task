package com.olesia.university;

import com.olesia.university.model.Lector;
import com.olesia.university.service.DepartmentService;
import com.olesia.university.service.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ConsoleUI {

    private final DepartmentService departmentService;
    private final LectorService lectorService;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("University Console App");
        System.out.println("Type 'exit' to quit or 'help' for commands.");

        while (true) {
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Bye!");
                break;
            }

            String result = handleCommand(input);
            System.out.println("Answer:\n");
            System.out.println(result);
        }
    }

    public String handleCommand(String input) {
        input = input.trim();

        if (input.equalsIgnoreCase("help")) {
            return getHelpMessage();
        }

        if (input.toLowerCase().startsWith("who is head of department")) {
            String departmentName = input.substring("who is head of department".length()).trim();
            return "Head of " + departmentName + " department is "
                    + departmentService.getDepartmentHeadNameByDepartmentName(departmentName) + ".";
        }

        if (input.toLowerCase().startsWith("show") && input.toLowerCase().endsWith("statistics")) {
            String departmentName = input.substring(5, input.length() - 11).trim();
            return departmentService.getDegreeStatisticsByDepartmentName(departmentName);
        }

        if (input.toLowerCase().startsWith("show the average salary for the department")) {
            String departmentName = input.substring("show the average salary for the department".length()).trim();
            return "The average salary of " + departmentName + " department is " +
                    departmentService.getAverageSalaryByDepartmentName(departmentName) + ".";
        }

        if (input.toLowerCase().startsWith("show count of employee for")) {
            String departmentName = input.substring("show count of employee for".length()).trim();
            return String.valueOf(departmentService.getEmployeeNumberByDepartmentName(departmentName));
        }

        if (input.toLowerCase().startsWith("global search by")) {
            String template = input.substring("global search by".length()).trim();
            List<Lector> lectors = lectorService.getLectorsByTemplate(template);
            if(lectors.isEmpty()) {
                return "No lectors were found for the given template {" + template + "}.";
            }

            return lectors.stream()
                    .map(lector -> lector.getName() + " " + lector.getSurname())
                    .collect(Collectors.joining(", "));
        }

        return "Unknown command. Type 'help' to see available options.";
    }

    public String getHelpMessage() {
        return "Available commands:\n" +
                "                 - Who is head of department {department_name}\n" +
                "                 - Show {department_name} statistics\n" +
                "                 - Show the average salary for the department {department_name}\n" +
                "                 - Show count of employee for {department_name}\n" +
                "                 - Global search by {template}\n" +
                "                 - Exit";
    }
}
