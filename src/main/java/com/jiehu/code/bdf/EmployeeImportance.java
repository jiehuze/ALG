package com.jiehu.code.bdf;

import java.util.*;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 * <p>
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，
 * 员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 * <p>
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出：11
 * 解释：
 * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 *  
 * <p>
 * 提示：
 * <p>
 * 一个员工最多有一个 直系 领导，但是可以有多个 直系 下属
 * 员工数量不超过 2000 。
 * <p>
 */
public class EmployeeImportance {
    public static class Employee {
        int id;
        int importance;
        ArrayList<Integer> subordinates;

        public Employee() {
        }

        public Employee(int id, int imp, ArrayList<Integer> subStaff) {
            this.id = id;
            this.importance = imp;
            this.subordinates = subStaff;
        }

        public List<Employee> insert(String emp) {
            ArrayList<Employee> employees = new ArrayList<>();
            String[] split = emp.split("],");

            for (int i = 0; i < split.length; i++) {
                String replace = split[i].replace(" ", "");
                String replace1 = replace.replace("[", "");
                String replace2 = replace1.replace("]", "");

                String[] sp = replace2.split(",");

                ArrayList<Integer> emps = new ArrayList<>();
                for (int j = 2; j < sp.length; j++) {
                    emps.add(Integer.valueOf(sp[j]));
                }
                Employee employee = new Employee(Integer.valueOf(sp[0]), Integer.valueOf(sp[1]), emps);
                employees.add(employee);
            }

            return employees;
        }
    }

    public int imps = 0;

    public int getImportance(List<Employee> employees, int id) {
        if (employees.size() < 0)
            return 0;

        HashMap<Integer, Employee> employeeHashMap = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            employeeHashMap.put(employees.get(i).id, employees.get(i));
        }
        dfs(employeeHashMap, employeeHashMap.get(id));
        return imps;
    }

    /**
     * 方法一：深度搜索
     */
    public void dfs(HashMap<Integer, Employee> employeeHashMap, Employee employee) {

        imps += employee.importance;

        for (int curId : employee.subordinates) {
            dfs(employeeHashMap, employeeHashMap.get(curId));
        }

    }

    /**
     * 方法二：广度搜索
     */
    public int bfs(HashMap<Integer, Employee> employeeHashMap, int id) {
        int imps = 0;

        if (employeeHashMap.size() == 0) return 0;

        LinkedList<Employee> stack = new LinkedList<>();

        stack.offer(employeeHashMap.get(id));

        while (!stack.isEmpty()) {
            Employee employee = stack.poll();
            imps += employee.importance;
            if (employee.subordinates != null) {
                for (int i = 0; i < employee.subordinates.size(); i++) {
                    if (employeeHashMap.get(employee.subordinates.get(i)) != null)
                        stack.push(employeeHashMap.get(employee.subordinates.get(i)));
                }
            }

        }

        return imps;
    }
}
