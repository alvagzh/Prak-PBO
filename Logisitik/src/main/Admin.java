/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author ROG
 */
public class Admin {
    private double Id;
    private String nama;
    private String password;
    
    public Admin(double Id, String nama, String password){
        this.Id = Id;
        this.nama = nama;
        this.password = password;
    }
        
    public double getId(){
        return Id;
    }
    
    public void setId(double Id){
        this.Id = Id;
    }

    public String getnama(){
        return nama;
    }
    
    public void setnama(String nama){
        this.nama = nama;
    }

    public String getpassword(){
        return password;
    }
    
    public void setPin(String password){
        this.password = password;
    }
}
