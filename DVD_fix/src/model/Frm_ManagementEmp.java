/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Main.Login;
import Main.Management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Azka
 */
public class Frm_ManagementEmp {
    String idadm;
    String aiddept;
    String aname;
    String agdr;
    String aphone;
    String auser ;
    String apass ;
    String idname;
    Connection con;
    ResultSet rs;
    Statement stmt;
    PreparedStatement stat;
    DefaultTableModel mdl;
    
    public String getIdname() {
        return idname;
    }

    public void setIdname(String idname) {
        this.idname = idname;
    }
    
    public String getIdadm() {
        return idadm;
    }

    public void setIdadm(String idadm) {
        this.idadm = idadm;
    }

    public String getAiddept() {
        return aiddept;
    }

    public void setAiddept(String aiddept) {
        this.aiddept = aiddept;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAgdr() {
        return agdr;
    }

    public void setAgdr(String agdr) {
        this.agdr = agdr;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public String getAuser() {
        return auser;
    }

    public void setAuser(String auser) {
        this.auser = auser;
    }

    public String getApass() {
        return apass;
    }

    public void setApass(String apass) {
        this.apass = apass;
    }
    

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

    public int doInsertEmp(){
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
                if(rs.getObject("IDDept").equals("STO"))
                {
                    JOptionPane.showMessageDialog(null, "DENIED ACCESS!");
                    i=0;
                }
                else if(rs.getObject("IDDept").equals("ADM"))
                {
                    try
                    {
                        String str = "INSERT INTO Employee VALUES(?,?,?,?,?,?,?)";
                        PreparedStatement stat = con.prepareStatement(str);
                        stat.setString(1, idadm);
                        stat.setString(2, aiddept);
                        stat.setString(3, aname);
                        stat.setString(4, agdr);
                        stat.setString(5, aphone);
                        stat.setString(6, auser);
                        stat.setString(7, apass);
                        stat.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Input new employee success!");
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
    
    
    public int doUpdateEmp(){
        int i=0;
        String selectDept = "Select IDDept from employee where username = ?";
        String updateEmp = "EXEC updateEmp ?,?,?,?,?";
        this.getConnection();
        
        try
        {
            stat=con.prepareStatement(selectDept);
            stat.setString(1, idname);
            rs = stat.executeQuery();
            if(rs.next())
           {
                if(rs.getObject("IDDept").equals("STO"))
                {
                    JOptionPane.showMessageDialog(null, "DENIED ACCESS!");
                    i=0;
                }
                else if(rs.getObject("IDDept").equals("ADM"))
                {
                    try
                    {
                        //isi kodingannya disini
                        stat = con.prepareStatement(updateEmp);
                        stat.setString(1, idadm);
                        stat.setString(2, aiddept);
                        stat.setString(3, aphone);
                        stat.setString(4, auser);
                        stat.setString(5, apass);
                        stat.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Update data succes!");
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
    
     public int doDeleteEmp(){
        int i=0;
        String selectDept = "Select IDDept from employee where username = ?";
        String deleteEmp = "delete Employee where IDEmp = ?";
        this.getConnection();
        
        try
        {
            stat=con.prepareStatement(selectDept);
            stat.setString(1, idname);
            rs = stat.executeQuery();
            if(rs.next())
           {
                if(rs.getObject("IDDept").equals("STO"))
                {
                    JOptionPane.showMessageDialog(null, "DENIED ACCESS!");
                    i=0;
                }
                else if(rs.getObject("IDDept").equals("ADM"))
                {
                    try
                    {
                        //isi kodingannya disini
                        stat = con.prepareStatement(deleteEmp);
                        stat.setString(1, idadm);
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
