import java.sql.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jdbc",
                    "postgres", "0000");
            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");
//            System.out.print("Departments: [");
//            while (resultSet.next()) {
//                System.out.print(" " + resultSet.getString("name") + " ");
//            }
//            System.out.println("]");

            System.out.println("TASK 1. Enter department");
            String sql = "SELECT * FROM employees WHERE department_name = '" + scanner.nextLine() + "' ORDER BY salary";
            printDepartmentEmployees(statement, sql);

            System.out.println("TASK 2. Enter department");
            sql = "SELECT * FROM employees WHERE department_name = '" + scanner.nextLine() + "' ORDER BY name";
            printDepartmentEmployees(statement, sql);

            System.out.println("TASK 3. Enter employee");
            String name = scanner.nextLine();
            task3(statement, name);

            System.out.println("TASK 4. Enter name");
            name = scanner.nextLine();
            task4(statement, name);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void task4(Statement statement, String name) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE name = '" + name + "'");
            if (resultSet.next()) {
                System.out.println(resultSet.getString("salary"));
            } else {
                resultSet = statement.executeQuery("SELECT * FROM departments WHERE boss = '" + name + "'");
                if (resultSet.next()) {
                    resultSet = statement.executeQuery("SELECT * FROM employees WHERE department_name = '" + resultSet.getString("name") + "' ORDER BY name");
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    int columnsNumber = resultSetMetaData.getColumnCount();
                    while (resultSet.next()) {
                        for (int i = 1; i <= columnsNumber; i++) {
                            if (i > 1) System.out.print(", ");
                            String columnValue = resultSet.getString(i);
                            System.out.print(resultSetMetaData.getColumnName(i) + ": " + columnValue);
                        }
                        System.out.println(";");
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    static void task3(Statement statement, String name) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE name = '" + name + "'");
            if (resultSet.next()) {
                resultSet = statement.executeQuery("SELECT * FROM employees WHERE salary > '" + resultSet.getInt("salary") + "'");
            } else {
                throw new IllegalArgumentException();
            }
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnsNumber = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(", ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(resultSetMetaData.getColumnName(i) + ": " + columnValue);
                }
                System.out.println(";");
            }
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    static void printDepartmentEmployees(Statement statement, String sql) {
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnsNumber = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(", ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(resultSetMetaData.getColumnName(i) + ": " + columnValue);
                }
                System.out.println(";");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
