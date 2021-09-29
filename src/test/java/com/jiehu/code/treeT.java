package com.jiehu.code;

import com.jiehu.code.bdf.EmployeeImportance;

import java.util.List;

public class treeT {
    public static void main(String[] args) {
        employeeTest();
    }

    public static void employeeTest() {
        String input = "[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]]";
        EmployeeImportance employeeImportance = new EmployeeImportance();

        EmployeeImportance.Employee employee = new EmployeeImportance.Employee();
        List<EmployeeImportance.Employee> inputs = employee.insert(input);

        System.out.println(inputs);

        System.out.println(employeeImportance.getImportance(inputs, 1));

    }
}
