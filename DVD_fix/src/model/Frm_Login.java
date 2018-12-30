/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;
import Main.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Azka
 */
public class Frm_Login {
    public String username;
    private String password;
    
    Connection con;
    Statement stmt;
    PreparedStatement stat;
    ResultSet rs;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    public int doLogin() {
        int i = 0;
        this.getConnection();
        String selectEmp = "select * from Employee where  username = ? and passwords = ?";
        String selectDept = "select IDDept from Employee where username = ?";
//        String user3;
        if((username.equals("zka"))&&(password.equals("secret")))
        {
           i = 1;
           JOptionPane.showMessageDialog(null, "Login Sucess\nWelcome"+"'"+username+"'");
        }else
        {
       try
        {
            stat = con.prepareStatement(selectEmp);
            stat.setString(1, username);
            stat.setString(2, password);
            rs = stat.executeQuery();
            if(rs.next())
               {
                  try {
                        stat = con.prepareStatement(selectDept);
                        //user3 = username;
                        stat.setString(1, username);
                        rs = stat.executeQuery();
                        if (rs.next())
                        {
                            if(rs.getObject("IDDept").equals("CAS"))
                            {
                                JOptionPane.showMessageDialog(null, "Login Success\nWelcome"+"'"+username+"'");
                                i = 2;
                                
                            }else if((rs.getObject("IDDept").equals("ADM")||(rs.getObject("IDDept").equals("STO"))))
                            {
                                JOptionPane.showMessageDialog(null, "Login Success\nWelcome"+"'"+username+"'");
                                i = 1;
                                System.out.println(i);
                            }
                        }
                    }catch (Exception e)
                    {
                    e.printStackTrace();
                    System.out.println(e);
            //JOptionPane.showMessageDialog(null, e);
                    }
                }else
                {
                    JOptionPane.showMessageDialog(null, "Login failed");
                    i = 0;
                    System.out.println("lala" + i);
                }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        return i;

    }


}
