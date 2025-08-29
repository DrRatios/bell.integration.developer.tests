package com.aleksgolds.bell.integrator.developer.tests;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task2 {
    public static void main(String[] args) {
        List<Map<String, String>> employeeTable = new ArrayList<>();
        Map<String, String> javaDevEmployee = new HashMap<>();
        javaDevEmployee.put("Имя", "Кирилл");
        javaDevEmployee.put("Возраст", "26");
        javaDevEmployee.put("Должность", "Middle java dev");
        javaDevEmployee.put("Зарплата", "150000 руб");
        Map<String, String> autoQAEmployee = new HashMap<>();
        autoQAEmployee.put("Имя", "Виталий");
        autoQAEmployee.put("Возраст", "28");
        autoQAEmployee.put("Должность", "Senior java automation QA");
        autoQAEmployee.put("Зарплата", "2000$");
        Map<String, String> funcQAEmployee = new HashMap<>();
        funcQAEmployee.put("Имя", "Александр");
        funcQAEmployee.put("Возраст", "31");
        funcQAEmployee.put("Должность", "junior functional tester");
        funcQAEmployee.put("Зарплата", "50000 руб");
        Map<String, String> devOpsEmployee = new HashMap<>();
        devOpsEmployee.put("Имя", "Дементий");
        devOpsEmployee.put("Возраст", "35");
        devOpsEmployee.put("Должность", "dev-ops");
        devOpsEmployee.put("Зарплата", "1500$");
        employeeTable.add(javaDevEmployee);
        employeeTable.add(autoQAEmployee);
        employeeTable.add(funcQAEmployee);
        employeeTable.add(devOpsEmployee);

        System.out.println(getEmployeesNameUnder30(employeeTable));
        System.out.println(getEmployeesNameTakingRubSalary(employeeTable));
        System.out.println(getEmployeesAvgAge(employeeTable));
    }

    public static List<String> getEmployeesNameUnder30(List<Map<String, String>> employeeTable) {
        return employeeTable.stream()
                .filter(map -> Integer.parseInt(map.get("Возраст")) < 30)
                .map(map -> map.get("Имя"))
                .collect(Collectors.toList());
    }

    public static List<String> getEmployeesNameTakingRubSalary(List<Map<String, String>> employeeTable) {
        return employeeTable.stream()
                .filter(map -> map.get("Зарплата").contains("руб"))
                .map(map -> map.get("Имя"))
                .collect(Collectors.toList());
    }

    public static double getEmployeesAvgAge(List<Map<String, String>> employeeTable) {
        return employeeTable.stream()
                .flatMapToInt(map -> IntStream.of(Integer.parseInt(map.get("Возраст"))))
                .average()
                .orElseThrow(() -> new RuntimeException("Something went wrong"));
    }

}
