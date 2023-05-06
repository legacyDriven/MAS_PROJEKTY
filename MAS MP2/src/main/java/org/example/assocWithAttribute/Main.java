package org.example.assocWithAttribute;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Jan Kowalski");
        Employee employee2 = new Employee("Anna Nowak");

        Company company1 = new Company("Janushex");
        Company company2 = new Company("Jonas Tech");

        EmploymentHistory history1 = new EmploymentHistory(employee1,
                company1, LocalDate.of(2020, 1, 1), LocalDate.of(2021, 1, 1));
        EmploymentHistory history2 = new EmploymentHistory(employee1,
                company2, LocalDate.of(2021, 2, 1), LocalDate.of(2022, 2, 1));
        EmploymentHistory history3 = new EmploymentHistory(employee2,
                company1, LocalDate.of(2019, 6, 1), LocalDate.of(2021, 6, 1));

        System.out.println(history1);
        System.out.println(history2);
        System.out.println(history3);
    }

}
