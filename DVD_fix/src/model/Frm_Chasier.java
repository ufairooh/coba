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
import java.util.Currency;
import javax.swing.JOptionPane;

/**
 *
 * @author Azka
 */
public class Frm_Chasier {
    Double Payment;
    Double total;
    Double Result;
    Integer idtotrans;
    Integer lbIDHeader;
    String date1;
    Double change1;
    
    Connection con;
    Statement stmt;
    PreparedStatement stat;
    ResultSet rs;

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public Double getChange1() {
        return change1;
    }

    public void setChange1(Double change1) {
        this.change1 = change1;
    }

    public Integer getIdtotrans() {
        return idtotrans;
    }

    public void setIdtotrans(Integer idtotrans) {
        this.idtotrans = idtotrans;
    }

    public Integer getLbIDHeader() {
        return lbIDHeader;
    }

    public void setLbIDHeader(Integer lbIDHeader) {
        this.lbIDHeader = lbIDHeader;
    }

    public Double getPayment() {
        return Payment;
    }

    public void setPayment(Double Payment) {
        this.Payment = Payment;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getResult() {
        return Result;
    }

    public void setResult(Double Result) {
        this.Result = Result;
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
    
     public int doChange(){
         int i = 0;
         if(Payment<total){
            JOptionPane.showMessageDialog(null, "Payment can not less than Total Price");
            i=0;
        }else{
        Result = Payment-total;
        i=1;
        }
        return i;
     }
     
     public int doTransac(){
     int ii = 0;
     this.getConnection();
        try{
            stat = con.prepareStatement("insert into totalTrans values (?,?,?)");
            stat.setString(1, Integer.toString(idtotrans));
            stat.setString(2, Integer.toString(lbIDHeader));
            stat.setString(3, Double.toString(total));
            stat.executeUpdate();
            ii=1;
            }catch(Exception s){
                JOptionPane.showMessageDialog(null, s);
            }  
     
     return ii;
     }
}
