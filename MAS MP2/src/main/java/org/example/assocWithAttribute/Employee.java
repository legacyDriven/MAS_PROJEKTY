package org.example.assocWithAttribute;

import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Getter
public class Employee {
    String name;
    private List<EmploymentHistory> employmentHistories;

    Employee(String name) {
        this.name = name;
        this.employmentHistories = new ArrayList<>();
    }

    public void addEmploymentHistory(EmploymentHistory history) {
        if (!employmentHistories.contains(history)) {
            employmentHistories.add(history);
        }
    }

    public void removeEmploymentHistory(EmploymentHistory history) {
        employmentHistories.remove(history);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
