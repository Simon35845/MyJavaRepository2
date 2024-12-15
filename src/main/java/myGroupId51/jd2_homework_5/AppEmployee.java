package myGroupId51.jd2_homework_5;

import myGroupId51.jd2_homework_5.Utils.JDBCResources;
import myGroupId51.jd2_homework_5.dao.EmployeeDAO;
import myGroupId51.jd2_homework_5.dao.EmployeeDAOImpl;
import myGroupId51.jd2_homework_5.dto.Employee;

import java.sql.Date;
import java.time.LocalDate;

public class AppEmployee {
    public static void main(String[] args) {
        String url = JDBCResources.getURL();
        String user = JDBCResources.getUser();
        String password = JDBCResources.getPassword();

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(url, user, password);
        employeeDAO.createTable();

        Employee employee1 = Employee.builder()
                .firstName("Наталья")
                .lastName("Алферова")
                .email("natalfer@gmail.com")
                .department("Отдел контроля продукции")
                .salary(1523.21)
                .hireDate(LocalDate.of(2015, 3, 12))
                .build();

        Employee employee2 = Employee.builder()
                .firstName("Михаил")
                .lastName("Новиков")
                .department("Заготовительный цех")
                .salary(1614.65)
                .hireDate(LocalDate.of(2013, 2, 3))
                .build();

        Employee employee3 = Employee.builder()
                .firstName("Павел")
                .lastName("Ганицкий")
                .department("Сборочный цех")
                .salary(1889.56)
                .hireDate(LocalDate.of(2017, 5, 14))
                .build();

        Employee employee4 = Employee.builder()
                .firstName("Мария")
                .lastName("Ельская")
                .email("mariels@gmail.com")
                .department("Отдел кадров")
                .salary(2001.84)
                .hireDate(LocalDate.of(2019, 8, 14))
                .build();

        Employee employee5 = Employee.builder()
                .firstName("Дмитрий")
                .lastName("Вольтович")
                .department("Покрасочный цех")
                .salary(1594.44)
                .hireDate(LocalDate.of(2016, 4, 17))
                .build();

        employeeDAO.save(employee1);
        employeeDAO.save(employee2);
        employeeDAO.save(employee3);
        employeeDAO.save(employee4);
        employeeDAO.save(employee5);

        employee2.setDepartment("Сборочный цех");
        employee2.setSalary(1924.25);
        employeeDAO.update(employee2);
        employeeDAO.delete(5);

        System.out.println(employeeDAO.find(3));
        employeeDAO.findAll().forEach(System.out::println);
        employeeDAO.findByDepartment("Сборочный цех").forEach(System.out::println);
        employeeDAO.findBySalary(1700).forEach(System.out::println);
        employeeDAO.findAllOrderBySalary().forEach(System.out::println);
        employeeDAO.findAllOrderByLastName().forEach(System.out::println);
    }
}
