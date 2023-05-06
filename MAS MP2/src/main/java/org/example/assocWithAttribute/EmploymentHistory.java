package org.example.assocWithAttribute;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.time.LocalDate;

@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode(of = {"employee", "company", "startDate"})
public class EmploymentHistory {
    Employee employee;
    Company company;
    LocalDate startDate; //attribute
    @NonFinal
    @Setter
    LocalDate endDate; // optional attribute

    public EmploymentHistory(Employee employee, Company company, LocalDate startDate) {
        this.employee = employee;
        this.company = company;
        this.startDate = startDate;

        employee.addEmploymentHistory(this);
        company.addEmploymentHistory(this);
    }

    public EmploymentHistory(Employee employee, Company company, LocalDate startDate, LocalDate endDate) {
        this(employee, company, startDate);
        this.endDate = endDate;
    }
}
