package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeList {
    public static List<Employee> employeeList = new ArrayList<>();



    protected static List<Employee> findByExperience(Integer employeeExp){
        List<Employee> listByExperience = new ArrayList<>();
        for (Employee employee : employeeList) {
            if(employee.getExperience().equals(employeeExp)){
                listByExperience.add(employee);
            }
        }
        return listByExperience;
    }


    protected static List<Employee> findPhoneByName(String name){
        List<Employee> listPhoneByName = new ArrayList<>();
        for (Employee employee : employeeList) {
            if(employee.getName().equals(name)){
                listPhoneByName.add(employee);
            }
        }
        return listPhoneByName;
    }
    protected static HashMap<Integer, String> findPhoneByNameMap(String name){
        HashMap<Integer, String> phoneMapByName = new HashMap<>();
        for (Employee employee : employeeList) {
            if(employee.getName().equals(name)){
                phoneMapByName.put(employee.getPhoneNumber(), employee.getName());
            }
        }
        return phoneMapByName;
    }

    protected static List<Employee> findEmployeeByPersonalNumber(Integer personalNumber){
        List<Employee> employeesListByPersonalNumber = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getPersonalNumber().equals(personalNumber)){
                employeesListByPersonalNumber.add(employee);
            }
        }
        return employeesListByPersonalNumber;
    }

    protected static void addToEmployeeList(
            Integer personalNumber
            ,Integer phoneNumber
            ,String name
            ,Integer experience
            ){
        employeeList.add(new Employee(personalNumber,phoneNumber,name,experience));
    }

}
