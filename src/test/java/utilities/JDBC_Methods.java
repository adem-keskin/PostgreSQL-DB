package utilities;

import java.sql.*;

public class JDBC_Methods {       // There are Methods for Connection, Statement, Close.. Java Data Base Connectivity

    private static Connection connection;      // Instance Variables
    private static Statement statement;

    public static Connection buildConnection(String hostName, String databaseName, String userName,String passWord){
           // Connection Method -> Verbindung aufbau..


// First --> Register to DataBase, load the drivers using forName() method.

        //oracle.jdbc.driver.OracleDriver               //org.sqlite.JDBC           -> Class Names
        //com.microsoft.sqlserver.jdbc.SQLServerDrive   //com.mysql.jdbc.Driver        the addresses of web pages

        try {
            Class.forName("org.postgresql.Driver");    // Class.forName();  with try-catch surround..
        } catch (ClassNotFoundException e) {                     // REGISTER -> Registered
            throw new RuntimeException(e);
        }

// Second --> Build a connection + Register the drivers using DriverManager

        //url syntax: "jdbc:postgresql://     hostname      :portNumber/ databaseName;   --> for postgresql
        String url = "jdbc:postgresql://" + hostName  + ":5432/"    + databaseName;  // hostName and databaseName -> Parameters
        try {
            connection = DriverManager.getConnection(url,userName,passWord);    // with try-catch surround..
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    // Third --> Create a Statement and handle with try-catch
    public static Statement createStatement (){

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statement;
    }

    // Fourth --> Close the Connection and Statement,  with close() method  then try-catch handle
    public static void connectionStatementClose(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }





}

