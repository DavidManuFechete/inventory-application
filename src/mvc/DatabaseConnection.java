package mvc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private final String driver;
    private final String dbName;
    private final String connectionURL;
    private final String ssl;
    private final String username;
    private final String password;

    public DatabaseConnection() {
        driver = "com.mysql.cj.jdbc.Driver";
        connectionURL = "jdbc:mysql://localhost:3306/";
        dbName = "warcraft-db";
        ssl = "?autoReconnect=true&useSSL=false";
        username = "root";
        password = "davidxd117";
    }

    public Connection getConnection() throws Exception {
        Class.forName(driver);

        return DriverManager.getConnection(connectionURL + dbName + ssl, username, password);
    }

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        try {
            Connection conn = db.getConnection();
            System.out.println("Database successfully connected!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
