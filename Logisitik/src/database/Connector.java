package database;
import java.sql.*;
import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;

public class Connector {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/apotik";
    static final String USER = "root";
    static final String PASS = ""; 
    public java.sql.Connection koneksi;
    public Statement statement;
    
    public Connector(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (java.sql.Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public java.sql.Connection getConnection(){
        return koneksi;
    }


}