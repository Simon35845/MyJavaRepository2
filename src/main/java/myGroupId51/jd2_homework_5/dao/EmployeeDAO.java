package myGroupId51.jd2_homework_5.dao;

import myGroupId51.jd2_homework_5.dto.Employee;

import java.util.List;

public interface EmployeeDAO extends DAO<Employee> {
    List<Employee> findByDepartment(String department);
    List<Employee> findBySalary(double salary);
    List<Employee> findAllOrderBySalary();
    List<Employee> findAllOrderByLastName();
}


