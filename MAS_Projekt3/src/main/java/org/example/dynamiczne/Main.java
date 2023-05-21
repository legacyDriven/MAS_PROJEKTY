package org.example.dynamiczne;

public class Main {
    public static void main(String[] args) {

        // Tworzenie obiektu typu Student
        Student student = new Student("Anna Kowalska", "Informatyka");
        System.out.println("Student:");
        System.out.println("Imię i nazwisko: " + student.getName());
        System.out.println("Kierunek studiów: " + student.getCourse());

        // Zmiana typu obiektu z Student na Employee
        Employee employee = new Employee(student, 5000);
        System.out.println("\nPracownik:");
        System.out.println("Imię i nazwisko: " + employee.getName());
        System.out.println("Wynagrodzenie: " + employee.getSalary());

        // Zmiana typu obiektu z Employee na Student
        Student studentAgain = new Student(employee, "Matematyka");
        System.out.println("\nStudent (ponownie):");
        System.out.println("Imię i nazwisko: " + studentAgain.getName());
        System.out.println("Kierunek studiów: " + studentAgain.getCourse());
    }
}

