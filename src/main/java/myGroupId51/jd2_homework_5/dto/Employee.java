package myGroupId51.jd2_homework_5.dto;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private double salary;
    private LocalDate hireDate;

    public Employee(int id, String firstName, String lastName, String email,
                    String department, double salary, LocalDate hireDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "\t" + firstName + " " + lastName + " (" +  email + "), " + department +
                ", зарплата " + salary + " руб., дата найма " + hireDate + ".";
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String department;
        private double salary;
        private LocalDate hireDate;

        public EmployeeBuilder id(int id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder email(String email) {
            this.email = email;
            return this;
        }

        public EmployeeBuilder department(String department) {
            this.department = department;
            return this;
        }

        public EmployeeBuilder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder hireDate(LocalDate hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        public Employee build() {
            return new Employee(this.id, this.firstName, this.lastName,
                    this.email, this.department, this.salary, this.hireDate);
        }
    }
}
