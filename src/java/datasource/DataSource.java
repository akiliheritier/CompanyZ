/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author akili.heritier
 */
public class DataSource {
    public static Connection getConnection() {
        Connection conn = null;
        try { 
             Class.forName("com.mysql.jdbc.Driver").newInstance();//
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_z_db?user=root&password=");
         } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            
        }
        
        return conn;
    }  
}
