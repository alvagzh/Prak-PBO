/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.Connector;
import main.Admin;
/**
 *
 * @author ROG
 */
public class adminmodel {
  Connector kon = new Connector();
    
    public ArrayList<Admin> getAdmin(){
        System.out.println("getAdmin()");
        String query = "Select * from Admin";
        PreparedStatement pstm;
        
        try{
            kon.statement = kon.koneksi.createStatement();
            pstm = kon.koneksi.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            ArrayList<Admin> list = new ArrayList<>();
            Admin Admin;
            while (rs.next()){
                Admin = new Admin(
                rs.getDouble("Id"),
                rs.getString("nama"),
                rs.getString("password")
                );
                list.add(Admin);
            } return list;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } return null;
    }
    
    public boolean isContainAdmin(){
        System.out.println("isContainAdmin()");
        try{
            String query = "Select count(*) as num from admin";
            PreparedStatement pstm = kon.koneksi.prepareStatement(query);
            kon.statement = kon.koneksi.createStatement();
            ResultSet rs = pstm.executeQuery(query);
            rs.next();
            if(rs.getInt("num")>0) return true;
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }return false;
    }

}   

