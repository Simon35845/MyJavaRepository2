package myGroupId51.jd2_homework_5.Utils;

public class SQLQuery {
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

    public static String createTable() {
        return CREATE_TABLE_QUERY;
    }

    public static String insert() {
        return INSERT_QUERY;
    }

    public static String update() {
        return UPDATE_QUERY;
    }

    public static String delete() {
        return DELETE_QUERY;
    }

    public static String select() {
        return SELECT_QUERY;
    }

    public static String selectAll() {
        return SELECT_ALL_QUERY;
    }

    public static String selectByDepartment() {
        return SELECT_BY_DEPARTMENT_QUERY;
    }

    public static String selectBySalary() {
        return SELECT_BY_SALARY_QUERY;
    }

    public static String selectAllOrderBySalary() {
        return SELECT_ALL_ORDER_BY_SALARY_QUERY;
    }

    public static String selectAllOrderByLastname() {
        return SELECT_ALL_ORDER_BY_LASTNAME_QUERY;
    }

}
