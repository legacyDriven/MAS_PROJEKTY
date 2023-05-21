package org.example.overlapping.flat;

import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.math.BigInteger;
import java.util.EnumSet;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class Person {

    String name;

    String surname;

    @NonFinal
    BigInteger salary;
    @NonFinal
    Integer studentId;

    EnumSet<Role> roles;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.roles = EnumSet.noneOf(Role.class);
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
    }

    public boolean hasRole(Role role) {
        return this.roles.contains(role);
    }


    public void setSalary(BigInteger salary) {
        if (!roles.contains(Role.EMPLOYEE)) {
            throw new IllegalStateException("Person must be an EMPLOYEE to set a salary");
        }
        this.salary = salary;
    }

    public BigInteger getSalary() {
        if (!roles.contains(Role.EMPLOYEE)) {
            throw new IllegalStateException("Person must be an EMPLOYEE to get a salary");
        }
        return salary;
    }

    public void setStudentId(Integer studentId) {
        if (!roles.contains(Role.STUDENT)) {
            throw new IllegalStateException("Person must be a STUDENT to set a studentId");
        }
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        if (!roles.contains(Role.STUDENT)) {
            throw new IllegalStateException("Person must be a STUDENT to get a studentId");
        }
        return studentId;
    }
}
