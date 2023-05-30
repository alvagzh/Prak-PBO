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
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ROG
 */
public class pembukuanview extends JFrame implements ActionListener {
    JLabel ljudul = new JLabel("Data Amunisi");
    JLabel lkode = new JLabel("kode");
    JLabel lnama = new JLabel("nama");
    JLabel lharga = new JLabel("harga");
    JLabel ljumlah = new JLabel("jumlah");

    public JTextField tfkode = new JTextField();
    public JTextField tfnama = new JTextField();
    public JTextField tfharga = new JTextField();
    public JTextField tfjumlah  = new JTextField();

    public JButton btnUpdate = new JButton("Pembaharui");
    public JButton btnDelete = new JButton("Hapus");
    public JButton btnReset = new JButton("Bersih");
    public JButton btnTambah = new JButton("Tambah");
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"kode", "nama", "harga", "jumlah"};

    public pembukuanview() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Pembukuan Stok Obat");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(550,600);
        
        add(ljudul);
        ljudul.setBounds(245, 10, 200, 20);
        
        add(scrollPane);
        scrollPane.setBounds(10, 250, 510, 300);
        
        add(lkode);
        lkode.setBounds(10, 50, 90, 20);
        add(tfkode);
        tfkode.setBounds(70, 50, 450, 20);

        add(lnama);
        lnama.setBounds(10, 90, 90, 20);
        add(tfnama);
        tfnama.setBounds(70, 90, 450, 20);

        add(lharga);
        lharga.setBounds(10, 130, 90, 20);
        add(tfharga);
        tfharga.setBounds(70, 130, 450, 20);

        add(ljumlah);
        ljumlah.setBounds(10, 170, 90, 20);
        add(tfjumlah);
        tfjumlah.setBounds(70, 170, 450, 20);
     
        add(btnDelete);
        btnDelete.setBounds(270, 210, 120, 20);

        add(btnUpdate);
        btnUpdate.setBounds(140, 210, 120, 20);

        add(btnReset);
        btnReset.setBounds(400, 210, 120, 20);
        btnReset.addActionListener(this);
        
        add(btnTambah);
        btnTambah.setBounds(10, 210, 120, 20);

    }

     public void actionPerformed(ActionEvent e) {
     if(e.getSource() == btnReset){
            tfkode.setText("");
            tfnama.setText("");
            tfharga.setText("");
            tfjumlah.setText("");
        }
     }



    public String getkode(){
        return tfkode.getText();
    }
    public String getnama(){
        return tfnama.getText();
    }
    public double getharga(){
        return Double.valueOf(tfharga.getText());
    }
    public double getjumlah(){
        return Double.valueOf(tfjumlah.getText());
    }
}
