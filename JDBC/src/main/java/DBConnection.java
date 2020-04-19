import java.sql.*;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    Connection getConnection() {
        return connection;
    }

    static synchronized DBConnection getDBConnection() {
        if (dbConnection == null) {
            String password = "0000";
            String userName = "postgres";
            String url = "jdbc:postgresql://localhost:5432/java_db_books";
            String nameOfTheDesiredClass = "org.postgresql.Driver";
            dbConnection = new DBConnection(nameOfTheDesiredClass, url, userName, password);
        }
        return dbConnection;
    }

    void close() {
        try {
            connection.close();
            dbConnection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DBConnection(String className, String url, String name, String password) {
        try {
            Class.forName(className);
            this.connection = DriverManager.getConnection(url, name, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
