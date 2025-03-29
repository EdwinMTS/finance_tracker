package db;

import org.jetbrains.annotations.Nullable;

import java.sql.*;

/**
 * Class to create database and retrieve connection
 */
public class DatabaseHelperClass {

    public static final String URL = "jdbc:sqlite:db/finance_tracker.db";

    /**
     * Function to create the database
     */
    public static void createDatabase() {

        try (var conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                var meta = conn.getMetaData();
                System.out.println("The driver name is: " + meta.getDriverName());
                System.out.println("A new database has been created!");
                createDatabaseTables();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Function to get a database connection
     * @return Database Connection object
     */
    @Nullable
    public static Connection getDatabaseConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    /**
     * Function to create all necessary tables in database
     */
    public static void createDatabaseTables() throws SQLException {
        Connection conn = getDatabaseConnection();
        assert conn != null;
        Statement st = conn.createStatement();
        for (String query : DatabaseQueries.createTableArray) {
            st.executeUpdate(query);
        }
        st.close();
    }
}
