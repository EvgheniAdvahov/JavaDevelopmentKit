package org.example;

public class Main {
    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();

        Employee employee1 = new Employee(1, 1234, "Alex", 5);
        Employee employee2 = new Employee(2, 3465, "Dmitrii", 3);
        Employee employee3 = new Employee(3, 6787, "Roman", 3);
        Employee employee4 = new Employee(4, 9999, "Alex", 15);


        EmployeeList.employeeList.add(employee1);
        EmployeeList.employeeList.add(employee2);
        EmployeeList.employeeList.add(employee3);
        EmployeeList.employeeList.add(employee4);



        System.out.println("=============Сотрудники================");
        System.out.println(EmployeeList.employeeList);
        System.out.println("============Найти по стажу==============");
        System.out.println(employeeList.findByExperience(3));

        System.out.println("=======Найти сотрудника по имени- вариант1");
        System.out.println(employeeList.findPhoneByName("Alex"));
        System.out.println("===Найти номер телефона сотрудника по имени- вариант2");
        System.out.println(employeeList.findPhoneByNameMap("Alex"));
        //переопределить тоСтринг в HashMap

        System.out.println("====Найти сотрудника по табельному номеру====");
        System.out.println(employeeList.findEmployeeByPersonalNumber(2));

        System.out.println("========После добавления нового сотрудника======");
        employeeList.addToEmployeeList(11, 567, "Constantin",0);
        System.out.println(employeeList.employeeList);

    }
}