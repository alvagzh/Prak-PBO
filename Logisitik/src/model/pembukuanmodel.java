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
import main.Pembukuan;
/**
 *
 * @author ROG
 */
public class pembukuanmodel {
    Connector kon = new Connector();
    
    public void insertPembukuan (Pembukuan Pembukuan){
        String query = "insert into Pembukuan(kode, nama, harga, jumlah) values (?,?,?,?)";
        PreparedStatement pstm;
        
        try {
            kon.statement = kon.koneksi.createStatement();
            pstm = kon.koneksi.prepareStatement(query);
            pstm.setString(1, Pembukuan.getkode());
            pstm.setString(2, Pembukuan.getnama());
            pstm.setDouble(3, Pembukuan.getharga());
            pstm.setDouble(4, Pembukuan.getjumlah());
            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deletePembukuan (String kode){
        String query = "delete from Pembukuan where kode = ?";
        PreparedStatement pstm;
        
        try{
            pstm = kon.koneksi.prepareStatement(query);
            pstm.setString(1, kode);
            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updatePembukuan (Pembukuan Pembukuan){
        String query = "Update Pembukuan SET nama=?, harga=?, jumlah=? WHERE kode=?";
        PreparedStatement pstm;
        
        try{
            kon.statement = kon.koneksi.createStatement();
            pstm = kon.koneksi.prepareStatement(query);
            pstm.setString(4, Pembukuan.getkode());
            pstm.setString(1, Pembukuan.getnama());
            pstm.setDouble(2, Pembukuan.getharga());
            pstm.setDouble(3, Pembukuan.getjumlah());
            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Pembukuan> getPembukuan(){
        System.out.println("getPembukuan()");
        String query = "Select * from Pembukuan";
        PreparedStatement pstm;
        
        try{
            kon.statement = kon.koneksi.createStatement();
            pstm = kon.koneksi.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            ArrayList<Pembukuan> list = new ArrayList<>();
            Pembukuan Pembukuan;
            while (rs.next()){
                Pembukuan = new Pembukuan(
                rs.getString("kode"),
                rs.getString("nama"),
                rs.getDouble("harga"),
                rs.getDouble("jumlah")        
                );
                list.add(Pembukuan);
            } return list;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } return null;
    }
    
    public boolean isContainPembukuan(){
        System.out.println("isContainPembukuan()");
        try{
            String query = "Select count(*) as num from Pembukuan";
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
  
