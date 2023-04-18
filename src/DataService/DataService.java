/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author VU HOANG
 */
public class DataService {
    private Connection connect;
    
    public void open(){
//        String strServer = "DESKTOP-3PMAECF";
//        String strDatabase = "QL_QuanMiCay";
//        String strUser = "sa";
//        String strPassword = "123";
        
        String strServer = "DELL\\SQLEXPRESS";
        String strDatabase = "QL_QuanMiCay";
        String strUser = "sa";
        String strPassword = "21062002";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectUrl = "jdbc:sqlserver://" + strServer + ":1433; databaseName = " + strDatabase
                                + "; user = " + strUser + "; password = " + strPassword;
            connect = DriverManager.getConnection(connectUrl);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close(){
        try {
            this.connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet executeQuery (String query) {
        ResultSet rs = null;
        try {
            Statement st = connect.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DataService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public int executeUpdate (String query) {
        int n = -1;
        try {
            Statement st = connect.createStatement();
            n = st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DataService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
