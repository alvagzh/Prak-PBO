/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.util.ArrayList;
import main.Admin;
import main.Pembukuan;
import model.adminmodel;
import model.pembukuanmodel;
import view.adminview;
import view.pembukuanview;
/**
 *
 * @author ASUS ROG
 */
public class admincontroller {
    private ArrayList<Admin> list;
    private double Id;
    private String nama;
    private String password;
    
        public admincontroller (adminview view, adminmodel model){
            if(model.isContainAdmin()){
                list = model.getAdmin();
                String [][] data = convertData(list);
            }else{
                JOptionPane.showMessageDialog(null, "Admin Belum Terdaftar");
            }
            
            view.btnLogin.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e){
                    String nama = view.getnama();
                    String password = view.getpassword();
                    String [][] data = convertData(list);
                    int log=0;
                    for(int i=0; i<list.size();i++){
                        if(data[i][0].equals(nama) && data[i][1].equals(password)){
                            log = 1;
                        }
                    }
                    if(log == 1){
                        view.dispose();
                        pembukuanview view = new pembukuanview();
                        pembukuanmodel model = new pembukuanmodel();
                        pembukuancontroller con = new pembukuancontroller(view, model);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Data Admin Salah");

                    }
                }
            
            });
        }
        
        private String[][] convertData(ArrayList<Admin> list) {    
        String[][] data = new String[list.size()][4];
        
        for(int i=0; i<list.size();i++)
        {
            data[i][0] = list.get(i).getnama();
            data[i][1] = list.get(i).getpassword();           
        }
        return data;
    }
}