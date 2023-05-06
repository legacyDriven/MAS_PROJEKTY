package org.example.assocWithAttribute;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    Company company;

    @BeforeEach
    void setUp() {
        company = new Company("ABC");
    }

    @Test
    @DisplayName("Test company creation")
    void testCompanyCreation() {
        assertNotNull(company);
        assertEquals("ABC", company.getName());
        assertTrue(company.getEmploymentHistories().isEmpty());
    }

    @Test
    @DisplayName("Test add employment history")
    void testAddEmploymentHistory() {
        Employee employee = new Employee("Jan Kowalski");
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 1, 1);
        EmploymentHistory employmentHistory = new EmploymentHistory(employee, company, startDate, endDate);

        company.addEmploymentHistory(employmentHistory);
        assertFalse(company.getEmploymentHistories().isEmpty());
        assertEquals(1, company.getEmploymentHistories().size());
        assertTrue(company.getEmploymentHistories().contains(employmentHistory));
    }
    @Test
    @DisplayName("Test remove employment history")
    void testRemoveEmploymentHistory() {
        Employee employee = new Employee("Jan Kowalski");
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 1, 1);
        EmploymentHistory employmentHistory = new EmploymentHistory(employee, company, startDate, endDate);

        company.addEmploymentHistory(employmentHistory);
        company.removeEmploymentHistory(employmentHistory);
        assertTrue(company.getEmploymentHistories().isEmpty());
    }

}