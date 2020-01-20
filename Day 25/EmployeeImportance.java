// Question : https://leetcode.com/problems/employee-importance/

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EmployeeImportance {


    public int getImportance(List<Employee> employees, int id) {
        // Put all importance in a hashmap
        HashMap<Integer,Employee> allemployees = new HashMap<>();
        for (Employee e: employees){
            allemployees.put(e.id,e);
        }

        return getEmployeeImportance(allemployees,id);
    }


    public int getEmployeeImportance(HashMap<Integer, Employee> allEmployees, int id){
        Employee self = allEmployees.get(id);
        int myImportance = self.importance;
        int childrenImportance = 0;

        for (int Id: self.subordinates) {
            childrenImportance += getEmployeeImportance(allEmployees,Id);
        }

        return myImportance + childrenImportance;
    }


}


class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};