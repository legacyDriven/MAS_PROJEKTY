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
    @DisplayName("Asocjacja z atrybutem - test tworzenia firmy")
    void testCompanyCreation() {
        assertNotNull(company);
        assertEquals("ABC", company.getName());
        assertTrue(company.getEmploymentHistories().isEmpty());
    }

    @Test
    @DisplayName("Asocjacja z atrybutem - test dodawania historii zatrudnienia")
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
    @DisplayName("Asocjacja z atrybutem - test usuwania historii zatrudnienia")
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