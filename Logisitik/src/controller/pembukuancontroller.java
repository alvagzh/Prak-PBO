/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import main.Pembukuan;
import model.pembukuanmodel;
import view.pembukuanview;

/**
 *
 * @author ASUS ROG
 */
public class pembukuancontroller {
    private ArrayList<Pembukuan> list;
    private String kode;
    private String nama;
    private double harga;
    private double jumlah;
    
    public pembukuancontroller (pembukuanview view, pembukuanmodel model){
        if(model.isContainPembukuan()){
            list = model.getPembukuan();
            String [][] data = convertData(list);
            view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
        }else{
            JOptionPane.showMessageDialog(null, "Pembelian Obat Belum Terdaftar");
        }
        view.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String kode = view.getkode();
               String nama = view.getnama();
               double harga = view.getharga();
               double jumlah = view.getjumlah();
               Pembukuan pembukuan = new Pembukuan(kode, nama, harga, jumlah);
               model.insertPembukuan(pembukuan);
               list = model.getPembukuan();
               //System.out.println(list.get(0).getkode());
               String [][] data = convertData(list);
               view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
               view.tfkode.setText("");
               view.tfnama.setText("");
               view.tfharga.setText("");
               view.tfjumlah.setText("");
            }
        });
        
         view.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("btnUpdate");
               String kode = view.getkode();
               String nama = view.getnama();
               double harga = view.getharga();
               double jumlah = view.getjumlah();
               Pembukuan pembukuan = new Pembukuan(kode, nama, harga, jumlah);
               model.updatePembukuan(pembukuan);
               list = model.getPembukuan();
               String [][] data = convertData(list);
               view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
               view.tfkode.setText("");
               view.tfnama.setText("");
               view.tfharga.setText("");
               view.tfjumlah.setText("");
            }
        });
         
         view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kode = view.getkode();
                model.deletePembukuan(kode);
                list = model.getPembukuan();
                String[][] data = convertData(list);
                view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
                view.tfkode.setText("");
                view.tfnama.setText("");
                view.tfharga.setText("");
                view.tfjumlah.setText("");
            }
        });
         
         view.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                int baris = view.tabel.getSelectedRow();
                int kolom = view.tabel.getSelectedColumn();
                kode = view.tabel.getValueAt(baris, 0).toString(); 
                nama = view.tabel.getValueAt(baris, 1).toString();
                harga = Double.parseDouble(view.tabel.getValueAt(baris, 2).toString());
                jumlah = Double.parseDouble(view.tabel.getValueAt(baris, 3).toString());
                
                view.tfkode.setText(String.valueOf(kode));
                view.tfnama.setText(String.valueOf(nama));
                view.tfharga.setText(String.valueOf(harga));
                view.tfjumlah.setText(String.valueOf(jumlah));
            }
            
        });
        
        view.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.tfkode.setText("");
                view.tfnama.setText("");
                view.tfharga.setText("");
                view.tfjumlah.setText("");
            }
        }); 
    }

    private String[][] convertData(ArrayList<Pembukuan> list) {    
        String[][] data = new String[list.size()][5];
        
        for(int i=0; i<list.size();i++)
        {
            data[i][0] = list.get(i).getkode();
            data[i][1] = list.get(i).getnama();
            data[i][2] = String.valueOf(list.get(i).getharga());
            data[i][3] = String.valueOf(list.get(i).getjumlah());           
        }
        return data;
    }
}
