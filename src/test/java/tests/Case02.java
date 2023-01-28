package tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.JDBC_Methods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Case02 {

    //Task 1: Ögrenciler tablosunda, "Kara Murat" isimli bir ogrenci oldugunu test edin...
    //Task 1: Check the student table to see if there is a student named "Kara Murat".
    //Aufgabe 1: Prüfen Sie in der Schülertabelle, ob es einen Schüler namens "Kara Murat" gibt.


    @Test                           // Test @ create
    public void StudentTest() throws SQLException {     // When Test Run with Void
        String userName = "postgres";
        String hostname = "localhost";
        String databaseName = "Arsiv";                  // Data base name ->  Changeable
        String passWord = "*********";                  // Server Password -> Enter the server password!

        JDBC_Methods.buildConnection(hostname, databaseName, userName, passWord);

        Statement st = JDBC_Methods.createStatement();

        String query = "SELECT * FROM student WHERE name = 'Kara Murat'";

        ResultSet rs = st.executeQuery(query);

        List<String> names = new ArrayList<>();

        while (rs.next()) {
            names.add(rs.getString("name"));
            System.out.println(rs.getString("name"));
        }

        Assert.assertTrue(names.contains("Merve Gul"));

        JDBC_Methods.connectionStatementClose();

    }
}
