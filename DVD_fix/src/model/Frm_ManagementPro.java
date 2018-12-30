/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Azka
 */
public class Frm_ManagementPro {
    String idpro;
    String type;
    String title;
    String artist;
    String year;
    String genre;
    String price;
    String stock;
    String idname;
    
    public String getIdname() {
        return idname;
    }

    public void setIdname(String idname) {
        this.idname = idname;
    }

    public String getIdpro() {
        return idpro;
    }

    public void setIdpro(String idpro) {
        this.idpro = idpro;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    Connection con;
    ResultSet rs;
    Statement stmt;
    PreparedStatement stat;
    DefaultTableModel mdl;
    
    private void getConnection() {
        try
        {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-764PK2R;databaseName=Project_DVD;user=sa;password=azkady1930");
            stmt = con.createStatement();
        }       
catch (Exception e)
        {
         System.out.println("Error"+ e);
        }
    }

    public int doInsertPro(){
	int i = 0;
        String selectDept = "Select IDDept from employee where username = ?";
        this.getConnection();
        
        try
        {
            stat=con.prepareStatement(selectDept);
            stat.setString(1, idname);
            rs = stat.executeQuery();
            if(rs.next())
           {
                if((rs.getObject("IDDept").equals("STO"))||(rs.getObject("IDDept").equals("ADM")))
                {
                    try
                    {
                        String str = "INSERT INTO DetailProduct VALUES(?,?,?,?,?,?,?,?)";
                        PreparedStatement stat = con.prepareStatement(str);
                        stat.setString(1, idpro);
                        stat.setString(2, type);
                        stat.setString(3, title);
                        stat.setString(4, artist);
                        stat.setString(5, year);
                        stat.setString(6, genre);
                        stat.setString(7, price);
                        stat.setString(8, stock);
                        stat.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Input product success!");
                        i =1;                    
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                }else
                {
                    JOptionPane.showMessageDialog(null, "DENIED ACCESS!", "Error!",JOptionPane.ERROR_MESSAGE);
                    i=0;
                }
           }
        }
            catch (Exception e)
        {
            System.out.println(e);
        }
	return i;
	}
    
    public int doUpdatePro(){
        int i = 0;
        String updatePro ="EXEC UpdateProduct ?, ?, ?";
        this.getConnection();

                    try
                    {
                        //isi kodingannya disini
                        stat = con.prepareStatement(updatePro);
                        stat.setString(1, idpro);
                        stat.setString(2, price);
                        stat.setString(3, stock);
                        stat.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Update data succes!");
                        i =1;                   
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }        
        return i;
    }
    
     public int doDeletePro(){
        int i = 0;
        String selectDept = "Select IDDept from employee where username = ?";
        String deletePro = "delete DetailProduct where IDDetPro = ?";
        this.getConnection();
        
        try
        {
            stat=con.prepareStatement(selectDept);
            stat.setString(1, idname);
            rs = stat.executeQuery();
            if(rs.next())
           {
                if((rs.getObject("IDDept").equals("STO"))||(rs.getObject("IDDept").equals("ADM")))
                {
                    try
                    {
                        //isi kodingannya disini
                        stat = con.prepareStatement(deletePro);
                        stat.setString(1, idpro);
                        stat.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Delete succes!");
                        i =1;                   
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "DENIED ACCESS!", "Error!",JOptionPane.ERROR_MESSAGE);
                    i=0;
                }
           }
        }
            catch (Exception e)
        {
            System.out.println(e);
        }
        
        return i;
    }
}
