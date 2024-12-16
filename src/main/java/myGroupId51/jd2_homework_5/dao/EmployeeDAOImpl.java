package myGroupId51.jd2_homework_5.dao;

import myGroupId51.jd2_homework_5.Utils.JDBCResources;
import myGroupId51.jd2_homework_5.Utils.SQLQuery;
import myGroupId51.jd2_homework_5.dto.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void createTable() {
        try (Connection connection = DriverManager.getConnection(
                JDBCResources.getURL(), JDBCResources.getUser(), JDBCResources.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.createTable())) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Employee employee) {
        try (Connection connection = DriverManager.getConnection(
                JDBCResources.getURL(), JDBCResources.getUser(), JDBCResources.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.insert())) {
            setEmployeeParams(employee, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee, int id) {
        try (Connection connection = DriverManager.getConnection(
                JDBCResources.getURL(), JDBCResources.getUser(), JDBCResources.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.update())) {
            setEmployeeParams(employee, preparedStatement);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(
                JDBCResources.getURL(), JDBCResources.getUser(), JDBCResources.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.delete())) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee find(int id) {
        try (Connection connection = DriverManager.getConnection(
                JDBCResources.getURL(), JDBCResources.getUser(), JDBCResources.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.select())) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Вывод сотрудника по id:");
            return getEmployeeParams(resultSet).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        try (Connection connection = DriverManager.getConnection(
                JDBCResources.getURL(), JDBCResources.getUser(), JDBCResources.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.selectAll())) {
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("\nВывод всех сотрудников:");
            return getEmployeeParams(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        try (Connection connection = DriverManager.getConnection(
                JDBCResources.getURL(), JDBCResources.getUser(), JDBCResources.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.selectByDepartment())) {
            preparedStatement.setString(1, department);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Вывод всех сотрудников по отделу:");
            return getEmployeeParams(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Employee> findBySalary(double salary) {
        try (Connection connection = DriverManager.getConnection(
                JDBCResources.getURL(), JDBCResources.getUser(), JDBCResources.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.selectBySalary())) {
            preparedStatement.setDouble(1, salary);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Вывод всех сотрудников по зарплате:");
            return getEmployeeParams(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Employee> findAllOrderBySalary() {
        try (Connection connection = DriverManager.getConnection(
                JDBCResources.getURL(), JDBCResources.getUser(), JDBCResources.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.selectAllOrderBySalary())) {
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("\nВывод и сортировка всех сотрудников по зарплате:");
            return getEmployeeParams(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Employee> findAllOrderByLastName() {
        try (Connection connection = DriverManager.getConnection(
                JDBCResources.getURL(), JDBCResources.getUser(), JDBCResources.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.selectAllOrderByLastname())) {
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("\nВывод и сортировка всех сотрудников по фамилии:");
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
