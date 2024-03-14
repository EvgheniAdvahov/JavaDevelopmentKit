package org.example;

public class Employee {
    Integer personalNumber;
    Integer phoneNumber;
    String name;
    Integer experience;

    public Employee(Integer personalNumber, Integer phoneNumber, String name, Integer experience) {
        this.personalNumber = personalNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
//        EmployeeList.employeeList.add(this);
    }

    public Integer getPersonalNumber() {
        return personalNumber;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    protected Integer getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Сотрудник{" +
                "Табельный номер=" + personalNumber +
                ", номер телефона=" + phoneNumber +
                ", имя='" + name + '\'' +
                ", стаж=" + experience +
                '}' + "\n";
    }
}
