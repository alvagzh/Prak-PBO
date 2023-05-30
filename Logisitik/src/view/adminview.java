/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author ROG
 */
public class adminview extends JFrame implements ActionListener {
    JLabel ljudul = new JLabel("Silahkan masukan");
    JLabel lnama = new JLabel("Id");
    JLabel lpassword = new JLabel("pass");
    
    public JTextField tfnama = new JTextField();
    public JTextField tfpassword = new JTextField();
    
    public JButton btnLogin = new JButton("Login");
    
    public adminview(){
        setTitle("Logistik medan perang ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(400,250);
        
        add(ljudul);
        ljudul.setBounds(125, 10, 200, 20);
        
        add(lnama);
        lnama.setBounds(10, 40, 200, 20);
        add(tfnama);
        tfnama.setBounds(50, 40, 320, 20);
        
        add(lpassword);
        lpassword.setBounds(10, 80, 200, 20);
        add(tfpassword);
        tfpassword.setBounds(50, 80, 320, 20);
        
        add(btnLogin);
        btnLogin.setBounds(120,170, 150, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("belum memenuhi syarat."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getnama(){
        return tfnama.getText();
    }
    public String getpassword(){
        return tfpassword.getText();
    }
    }
    
    



