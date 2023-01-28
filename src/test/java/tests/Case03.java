package tests;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Case03 {
    public class C02 {
        // Yazili not ortalamasının 90´dan kücük oldugunu test edin
        // Check if the exam grade point average is less than 90
        // Prüfen Sie, ob der Notendurchschnitt der Prüfung weniger als 90 beträgt
        @Test
        public void name() throws SQLException {
            String hostname = "localhost";               // DBUtils Class´inda olusturdugumuz methodlarla veverileri aliyoruz.
            String dbisim = "Arsiv";                     // We get the data, using the methods we created in the DBUtils class.
            String username = "postgres";                // Wir erhalten die Daten mit den Methoden, die wir in der DBUtils-Klasse erstellt haben.
            String password = "************";


            //1.Step Connection
            DBUtils.connectionOlustur(hostname,dbisim,username,password);

            //2.Step Statement
            Statement st = DBUtils.statementOlustur();

            String query = "SELECT avg(not_ort) FROM ogrenciler;";
            ResultSet rs = st.executeQuery(query);
            rs.next();

            double ort = rs.getDouble(1);
            System.out.println("ort = " + ort);

            Assert.assertTrue(ort < 90);

            DBUtils.connectionStatementKapat();

        }
}
