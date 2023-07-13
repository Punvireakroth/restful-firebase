package com.java.employee.Model;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeModel {
    private String documentId;
    private String name;
    private int attendance;
    private String position;
    private int salary;
    private String workdepartment;
}
