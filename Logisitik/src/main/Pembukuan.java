/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author ROG
 */
public class Pembukuan {
    private String kode;
    private String nama;
    private double harga;
    private double jumlah;
    
    public Pembukuan(String kode, String nama, double harga, double jumlah){
        this.kode =  kode;
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }
        
    public String getkode(){
        return kode;
    }
    
    public void setkode(String kode){
        this.kode = kode;
    }

    public String getnama(){
        return nama;
    }
    
    public void setnama(String nama){
        this.nama = nama;
    }

    public double getharga(){
        return harga;
    }
    
    public void setharga(double harga){
        this.harga = harga;
    }
    public double getjumlah(){
        return jumlah;
    }
    
    public void setjumlah(double jumlah){
        this.jumlah = jumlah;
    }
}
