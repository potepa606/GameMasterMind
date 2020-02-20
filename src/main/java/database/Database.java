package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static Statement statement;
    public static Connection connection;

    public static void polocz(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Mastermind","postgres","123456a");
            statement = connection.createStatement();
        }catch (ClassNotFoundException | SQLException e ){
            e.printStackTrace();
        }

    }
    public static void rozlocz(){
        try {
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
