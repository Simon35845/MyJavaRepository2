package myGroupId51.jd2_homework_5.Utils;

import myGroupId51.jd2_homework_5.dto.Employee;

import java.util.List;

public class EmployeeTable {
    private static final String[] HEADERS = {"id", "Имя", "Фамилия", "Электронная почта", "Отдел", "Зарплата, руб", "Дата найма"};
    private static final int[] COLUMN_WIDTHS = {3, 10, 12, 25, 25, 13, 10};

    public static void printOneResult(Employee employee) {
        TableBuilder.printHeader(HEADERS, COLUMN_WIDTHS);
        String[] data = {
                String.valueOf(employee.getId()),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail() != null ? employee.getEmail() : "—",
                employee.getDepartment() != null ? employee.getDepartment() : "—",
                employee.getSalary() != 0.0 ? String.format("%.2f", employee.getSalary()) : "—",
                employee.getHireDate() != null ? String.valueOf(employee.getHireDate()) : "—",
        };
        TableBuilder.printEmployeeRow(data, COLUMN_WIDTHS);
        TableBuilder.printFooter(COLUMN_WIDTHS);
    }

    public static void printManyResults(List<Employee> employees) {
        TableBuilder.printHeader(HEADERS, COLUMN_WIDTHS);
        for (Employee employee : employees) {
            String[] data = {
                    String.valueOf(employee.getId()),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail() != null ? employee.getEmail() : "—",
                    employee.getDepartment() != null ? employee.getDepartment() : "—",
                    employee.getSalary() != 0.0 ? String.format("%.2f", employee.getSalary()) : "—",
                    employee.getHireDate() != null ? String.valueOf(employee.getHireDate()) : "—",
            };
            TableBuilder.printEmployeeRow(data, COLUMN_WIDTHS);
        }
        TableBuilder.printFooter(COLUMN_WIDTHS);
    }
}

