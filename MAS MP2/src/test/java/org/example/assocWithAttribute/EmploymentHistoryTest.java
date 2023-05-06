package org.example.assocWithAttribute;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmploymentHistoryTest {

    Employee employee;
    Company company;
    LocalDate startDate;
    LocalDate endDate;
    EmploymentHistory employmentHistory;

    @BeforeEach
    void setUp() {
        employee = new Employee("Jan Kowalski");
        company = new Company("ABC");
        startDate = LocalDate.of(2020, 1, 1);
        endDate = LocalDate.of(2022, 1, 1);
        employmentHistory = new EmploymentHistory(employee, company, startDate, endDate);
    }

    @Test
    @DisplayName("Test employment history creation")
    void testEmploymentHistoryCreation() {
        assertNotNull(employmentHistory);
        assertEquals(employee, employmentHistory.getEmployee());
        assertEquals(company, employmentHistory.getCompany());
        assertEquals(startDate, employmentHistory.getStartDate());
        assertEquals(endDate, employmentHistory.getEndDate());
    }

    @Test
    @DisplayName("Test change end date")
    void testChangeEndDate() {
        LocalDate newEndDate = LocalDate.of(2023, 1, 1);
        employmentHistory.setEndDate(newEndDate);
        assertEquals(newEndDate, employmentHistory.getEndDate());
    }
}