import java.sql.*;
import java.util.Scanner;

public class DBService {
    private DBConnection dataBase;
    private Scanner scanner = new Scanner(System.in);

    DBService(DBConnection dataBase) {
        this.dataBase = dataBase;
    }

    void task1() {
        printListOfDepartment();
        System.out.println("TASK 1. Enter department");
        String sql = "SELECT * FROM employees WHERE name_of_department = '" + scanner.nextLine() + "' ORDER BY salary";
        printEmployeesOfDepartment(sql);
    }

    void task2() {
        printListOfDepartment();
        System.out.println("TASK 2. Enter department");
        String sql = "SELECT * FROM employees WHERE name_of_department = '" + scanner.nextLine() + "' ORDER BY name";
        printEmployeesOfDepartment(sql);
    }

    void task3() {
        System.out.println("TASK 3. Enter employee");
        String name = scanner.nextLine();
        try (Statement statement = dataBase.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE name = '" + name + "'");
            if (resultSet.next()) {
                resultSet = statement.executeQuery("SELECT * FROM employees WHERE salary > '" + resultSet.getInt("salary") + "'");
            } else {
                throw new IllegalArgumentException("По вашему запросу ничего не найдено.");
            }
            printResultSet(resultSet);
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    void task4() {
        System.out.println("TASK 4. Enter name");
        String name = scanner.nextLine();
        try (Statement statement = dataBase.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE name = '" + name + "'");
            if (resultSet.next()) {
                System.out.println("Salary of " + name + ": " + resultSet.getString("salary"));
            } else {
                resultSet = statement.executeQuery("SELECT * FROM departments WHERE boss = '" + name + "'");
                if (resultSet.next()) {
                    resultSet = statement.executeQuery("SELECT * FROM employees WHERE name_of_department = '" + resultSet.getString("name_of_department") + "' ORDER BY salary");

                    printResultSet(resultSet);

                } else {
                    throw new IllegalArgumentException("По вашему запросу ничего не найдено.");
                }
            }
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    void createTablesForHomework() {
        try (Statement statement = dataBase.getConnection().createStatement()) {
            statement.execute("create table departments(" +
                    "name_of_department varchar(80) primary key not null," +
                    "boss varchar(80) not null);");
            statement.execute("create table employees(" +
                    "name varchar(80) not null," +
                    "salary real not null," +
                    "name_of_department varchar(80) references departments(name_of_department));");
            insertContentIntoTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertContentIntoTables() throws SQLException {
        executePreparedStatement("financial", "Alexander Ivanov");
        executePreparedStatement("sales", "Ivan Ivanov");
        executePreparedStatement("production", "Alexey Mordanov");

        executePreparedStatement("Vasiliy Kamikadze", 1000, "sales");
        executePreparedStatement("Vladislav Perevezentsev", 1200, "sales");
        executePreparedStatement("Ivan Kurochkin", 1320, "sales");
        executePreparedStatement("Lzhedmitriy Vtoroy", 500, "sales");
        executePreparedStatement("Dmitriy Vasnetsov", 700, "sales");
        executePreparedStatement("Anatoliy Chevchan", 2000, "production");
        executePreparedStatement("Victor Abramovich", 2222, "production");
        executePreparedStatement("Alisher Usmanov", 9999, "production");
        executePreparedStatement("Vladimir Pitin", 8888, "production");
        executePreparedStatement("Dmitriy Nedvedev", 7777, "production");
        executePreparedStatement("Tom Shelby", 3210, "production");
        executePreparedStatement("Tatiana Gesterenko", 12010, "financial");
        executePreparedStatement("Anton Ziluanov", 15300, "financial");
        executePreparedStatement("Arkadiy Drachuk", 8000, "financial");
        executePreparedStatement("Aleksey Sazanov", 7800, "financial");
        executePreparedStatement("Vladimir Nazarov", 6000, "financial");
        executePreparedStatement("Yaroslav Shmigov", 7800, "financial");
    }

    private void executePreparedStatement(String param1, String param2) throws SQLException {
        PreparedStatement preparedStatement = dataBase.getConnection().prepareStatement(
                "insert into departments(name_of_department, boss) values(?, ?)");
        preparedStatement.setString(1, param1);
        preparedStatement.setString(2, param2);
        preparedStatement.executeUpdate();
    }

    private void executePreparedStatement(String param1, int param2, String param3) throws SQLException {
        PreparedStatement preparedStatement = dataBase.getConnection().prepareStatement(
                "insert into employees(name, salary, name_of_department) values(?, ?, ?)");
        preparedStatement.setString(1, param1);
        preparedStatement.setInt(2, param2);
        preparedStatement.setString(3, param3);
        preparedStatement.executeUpdate();
    }

    private void printEmployeesOfDepartment(String sql) {
        try (Statement statement = dataBase.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.next())
                throw new IllegalArgumentException("По вашему запросу ничего не найдено.");
            printResultSet(resultSet);
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void printResultSet(ResultSet resultSet) {
        ResultSetMetaData resultSetMetaData;
        try {
            resultSetMetaData = resultSet.getMetaData();
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

    private void printListOfDepartment() {
        try (Statement statement = dataBase.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT name_of_department FROM departments");
            printResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
