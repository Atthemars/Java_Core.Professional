package geekbrains.homework.Lesson_2;

import java.sql.*;

public class DB_CRUD {

    private static Connection connection;
private static Statement  stmt;

    public static void main(String[] args) throws SQLException {
        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        createDB();
        updateDB();
        readDB();
        deleteDB();
        disconnect();


    }

    public static void connect () throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
connection = DriverManager.getConnection("jdbc:sqlite:main.db");
stmt = connection.createStatement();
    }

    public static void createDB(){
        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:main.db");
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql ="CREATE TABLE homeWorkTable " +
                        "(ID INTEGER PRIMARY KEY autoincrement," +
                        " Name           TEXT    NOT NULL, " +
                        " score INTEGER)";
                stmt.executeUpdate(sql);
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Table created successfully");
        }
    }
    public static void updateDB()
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:main.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO homeWorkTable (ID,NAME,Score) " +
                    "VALUES (1, 'Nikolai', 80)," +
                    " (2, 'Stas', 50);";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
    public static void readDB() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:main.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM homeWorkTable;");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                Integer score = rs.getInt("Score");

                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("Score : " + score);

                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
        public static void deleteDB()
        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:main.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "DELETE from homeWorkTable where ID='2';";
                stmt.executeUpdate(sql);
                c.commit();
                stmt.close();
                c.close();
                } catch ( Exception e ) {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    System.exit(0);
                }
                System.out.println("Operation done successfully");
        }


    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
