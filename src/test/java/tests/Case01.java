package tests;

import utilities.JDBC_Methods;
import org.junit.Test;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class Case01 {

    // Test Task 1: Countries  tablosunda, "Germany" isimli bir ülke oldugunu test edin..
    // Test task 1: Test in the country table whether there is a country with the name "Germany".
    // Testaufgabe 1: Testen Sie in der Ländertabelle, ob es ein Land mit dem Namen "Deutschland" gibt.
    @Test
    public void test() throws SQLException {              // My connection data
        String userName = "postgres";
        String hostname = "localhost";
        String databaseName = "Arsiv";                    // My Data base name !!
        String passWord = "*********";                    // My Server password !!

        // First --> Connection
        JDBC_Methods.buildConnection(hostname,databaseName,userName,passWord);

        // Second --> Statement
        Statement st = JDBC_Methods.createStatement();

        //Third --> Create Query
        String query = "SELECT name FROM students";

        //Fourth --> Run Query
        ResultSet rs = st.executeQuery(query);
        List<String> name = new ArrayList<>();

        // Fifth -->

        while (rs.next()) {
            System.out.println(rs.getString(1));
            name.add(rs.getString(1));
        }

        Assert.assertTrue(name.contains("Kara Murat"));

        JDBC_Methods.connectionStatementClose();

    }
}






