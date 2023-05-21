package org.example.overlapping.composition;

import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.math.BigDecimal;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class Person {
    String name;

    String surname;
    @NonFinal
    private Employee employeeRole;
    @NonFinal
    private Student studentRole;

    // Konstruktor
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setEmployeeRole(Employee employeeRole) {
        this.employeeRole = employeeRole;
    }

    public void setStudentRole(Student studentRole) {
        this.studentRole = studentRole;
    }

    public BigDecimal getSalary() {
        if (employeeRole == null) {
            throw new IllegalStateException("Person must be an EMPLOYEE to get a salary");
        }
        return employeeRole.getSalary();
    }

    public void setSalary(BigDecimal salary) {
        if (employeeRole == null) {
            throw new IllegalStateException("Person must be an EMPLOYEE to set a salary");
        }
        employeeRole.setSalary(salary);
    }

    public Integer getStudentId() {
        if (studentRole == null) {
            throw new IllegalStateException("Person must be a STUDENT to get a studentId");
        }
        return studentRole.getStudentId();
    }

    public void setStudentId(Integer studentId) {
        if (studentRole == null) {
            throw new IllegalStateException("Person must be a STUDENT to set a studentId");
        }
        studentRole.setStudentId(studentId);
    }

}
