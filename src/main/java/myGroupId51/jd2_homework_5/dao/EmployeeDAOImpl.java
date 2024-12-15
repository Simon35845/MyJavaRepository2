package myGroupId51.jd2_homework_5.dao;

import myGroupId51.jd2_homework_5.dto.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private String url;
    private String user;
    private String password;

    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE IF NOT EXISTS employees (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "first_name VARCHAR(50) NOT NULL, " +
                    "last_name VARCHAR(50) NOT NULL, " +
                    "email VARCHAR(100), " +
                    "department VARCHAR(50), " +
                    "salary DECIMAL(10,2), " +
                    "hire_date DATE);";

    private static final String INSERT_QUERY =
            "INSERT INTO employees (" +
                    "first_name, last_name, email, department, salary, hire_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?);";

    private static final String UPDATE_QUERY =
            "UPDATE employees " +
                    "SET first_name = ?, last_name = ?, email = ?, " +
                    "department = ?, salary = ?, hire_date = ? " +
                    "WHERE id = ?;";

    private static final String DELETE_QUERY =
            "DELETE FROM employees " +
                    "WHERE id = ?;";

    private static final String SELECT_QUERY =
            "SELECT * FROM employees " +
                    "WHERE id = ?;";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM employees;";

    private static final String SELECT_BY_DEPARTMENT_QUERY =
            "SELECT * FROM employees " +
                    "WHERE department = ?;";

    private static final String SELECT_BY_SALARY_QUERY =
            "SELECT * FROM employees " +
                    "WHERE salary > ?;";

    private static final String SELECT_ALL_ORDER_BY_SALARY_QUERY =
            "SELECT * FROM employees " +
                    "ORDER BY salary;";

    private static final String SELECT_ALL_ORDER_BY_LASTNAME_QUERY =
            "SELECT * FROM employees " +
                    "ORDER BY last_name;";

    public EmployeeDAOImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }


    @Override
    public void createTable() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_QUERY)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Employee employee) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            setEmployeeParams(employee, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            setEmployeeParams(employee, preparedStatement);
            preparedStatement.setInt(7, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee find(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return getEmployeeParams(resultSet).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Все сотрудники из отдела:");
            return getEmployeeParams(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_DEPARTMENT_QUERY)) {
            preparedStatement.setString(1, department);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Все сотрудники из отдела:");
            return getEmployeeParams(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Employee> findBySalary(double salary) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_SALARY_QUERY)) {
            preparedStatement.setDouble(1, salary);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Все сотрудники с зарплатой более:");
            return getEmployeeParams(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Employee> findAllOrderBySalary() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER_BY_SALARY_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Все сотрудники отсортированы по зарплате:");
            return getEmployeeParams(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Employee> findAllOrderByLastName() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER_BY_LASTNAME_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Все сотрудники отсортированы по фамилии:");
            return getEmployeeParams(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private static void setEmployeeParams(Employee employee, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getEmail());
        preparedStatement.setString(4, employee.getDepartment());
        preparedStatement.setDouble(5, employee.getSalary());
        preparedStatement.setDate(6, java.sql.Date.valueOf(employee.getHireDate()));
    }

    private List<Employee> getEmployeeParams(ResultSet resultSet) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        while (resultSet.next()) {
            employees.add(new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("department"),
                    resultSet.getDouble("salary"),
                    resultSet.getDate("hire_date").toLocalDate()));
        }
        return employees;
    }
}
