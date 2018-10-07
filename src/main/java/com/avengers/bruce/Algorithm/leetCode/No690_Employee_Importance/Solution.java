package com.avengers.bruce.Algorithm.leetCode.No690_Employee_Importance;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

// Employee info
class Employee {
    // It's the unique id of each employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}

class Solution1 {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, List<Integer>> subOrdinatesMap = new HashMap<>();
        HashMap<Integer, Integer> importanceMap = new HashMap<>();
        for (Employee employee : employees) {
            subOrdinatesMap.put(employee.id, employee.subordinates);
            importanceMap.put(employee.id, employee.importance);
        }
        return helper(employees, importanceMap, subOrdinatesMap, id);
    }

    private static int helper(List<Employee> employees, HashMap<Integer, Integer> importanceMap,
                              HashMap<Integer, List<Integer>> subOrdinatesMap, int id) {
        int sum = 0;
        if (importanceMap.containsKey(id)) {
            List<Integer> subOrdinates = subOrdinatesMap.get(id);
            sum += importanceMap.get(id);
            for (int subOrdinate : subOrdinates) {
                sum += helper(employees, importanceMap, subOrdinatesMap, subOrdinate);
            }
        }
        return sum;
    }
}

class Solution2 {
    int total = 0;

    public int getImportance(List<Employee> employees, int id) {
        Employee manager = employees.stream().filter(e -> e.id == id).collect(Collectors.toList()).get(0);
        total += manager.importance;
        manager.subordinates.forEach(subId -> getImportance(employees, subId));
        return total;
    }
}