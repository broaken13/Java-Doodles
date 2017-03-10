/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doodle;
import java.sql.*;
import java.util.logging.*;
/**
 *
 * @author bjo
 */
public class DatabaseExample {
    public static void main(String[] args) {
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //This example is for SQL sqlserver
            Connection c = DriverManager.getConnection("jdbc:sqlserver://url:1433;databaseName=db;user=bjo;password=password");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * From Customer");

            while(rs.next()) {
                System.out.println(rs.getString("name") + " : " + rs.getString("email"));
            }

        } catch (Exception ex) {
            Logger.getLogger(Doodle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
