package org.example.dynamiczne;

class Student extends Person {
    private String course;

    public Student(String name, String course) {
        super(name);
        this.course = course;
    }

    public Student(Employee employee, String course) {
        super(employee.getName());
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
