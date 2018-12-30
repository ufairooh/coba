/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import junit.framework.Assert;
import model.Frm_Chasier;
import model.Frm_Login;
import model.Frm_ManagementEmp;
import model.Frm_ManagementPro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Azka
 */
public class FileTest {
    
    public FileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//    @Ignore
     @Test
     public void testLoginAdmin() {
         Frm_Login fLog = new Frm_Login();
         fLog.setUsername("adminkece");
         fLog.setPassword("master");
         int i = fLog.doLogin();
         Assert.assertEquals(1, i);
     }
     
//     @Ignore
     @Test
     public void testLoginChasier() {
         Frm_Login fLog = new Frm_Login();
         fLog.setUsername("chisee");
         fLog.setPassword("asdfgh");
         int i = fLog.doLogin();
         Assert.assertEquals(2, i);
     }
     
//     @Ignore
      @Test
     public void testLoginStorage() {
         Frm_Login fLog = new Frm_Login();
         fLog.setUsername("okedeh");
         fLog.setPassword("qwerty");
         int i = fLog.doLogin();
         Assert.assertEquals(1, i);
     }
     
//     @Ignore
      @Test
     public void testLogFailedU() {
         Frm_Login fLog = new Frm_Login();
         fLog.setUsername("lkjh");
         fLog.setPassword("asdfgh");
         int i = fLog.doLogin();
         Assert.assertEquals(0, i);
     }
     
//     @Ignore
      @Test
     public void testLogFailedP() {
         Frm_Login fLog = new Frm_Login();
         fLog.setUsername("chisee");
         fLog.setPassword("bhuij");
         int i = fLog.doLogin();
         Assert.assertEquals(0, i);
     }
     
//     @Ignore
      @Test
     public void testLogNull() {
         Frm_Login fLog = new Frm_Login();
         fLog.setUsername("");
         fLog.setPassword("");
         int i = fLog.doLogin();
         Assert.assertEquals(0, i);
     }  //benar
     
//     @Ignore
      @Test
     public void testUpEmp() {
        Frm_ManagementEmp obj = new Frm_ManagementEmp();
        obj.setIdadm("3006");
        obj.setAiddept("STO");
        obj.setAphone("1234");
        obj.setAuser("asd");
        obj.setApass("dsa");
        obj.setIdname("adminkece");
         int i = obj.doUpdateEmp();
         Assert.assertEquals(1, i);
     }
     
//     @Ignore
      @Test
     public void testDeleteEmp() {
        Frm_ManagementEmp obj = new Frm_ManagementEmp();
        obj.setIdadm("3006");
        obj.setIdname("adminkece");
         int i = obj.doDeleteEmp();
         Assert.assertEquals(1, i);
     }
     
//    @Ignore
      @Test
     public void testDeletePro() {
        Frm_ManagementPro obj = new Frm_ManagementPro();
        obj.setIdpro("10025");
        obj.setIdname("adminkece");
         int i = obj.doDeletePro();
         Assert.assertEquals(1, i);
     }
     
//     @Ignore
      @Test //ganti idpro
     public void testInsertPro() {
        Frm_ManagementPro obj = new Frm_ManagementPro();
        obj.setIdname("adminkece");
        obj.setIdpro("10026");
        obj.setType("FLM");
        obj.setTitle("ufa");
        obj.setArtist("ufa");
        obj.setYear("2016");
        obj.setGenre("HOR");
        obj.setPrice("30000");
        obj.setStock("1");
         int i = obj.doInsertPro();
         Assert.assertEquals(1, i);
     }
     
//      @Ignore
      @Test //ganti idadm
     public void testInsertEmp() {
        Frm_ManagementEmp obj = new Frm_ManagementEmp();
        obj.setIdname("adminkece");
        obj.setIdadm("300");
        obj.setAname("Mala");
        obj.setAgdr("Female");
        obj.setAiddept("STO");
        obj.setAphone("12345678");
        obj.setAuser("lalala");
        obj.setApass("qwerty");
         int i = obj.doInsertEmp();
         Assert.assertEquals(1, i);
     }
     
//    @Ignore
      @Test
     public void testPaymentFailed() {
        Frm_Chasier obj = new Frm_Chasier();
        obj.setPayment(2000.00);
        obj.setTotal(5000.00);
         int i = obj.doChange();
         Assert.assertEquals(0, i);
     }
     
//     @Ignore
      @Test
     public void testPaymentSuccess() {
        Frm_Chasier obj = new Frm_Chasier();
        obj.setPayment(7000.00);
        obj.setTotal(5000.00);
         int i = obj.doChange();
         Assert.assertEquals(1, i);
     }
     
//     @Ignore
      @Test //ganti idtotrans
     public void testTransSuccess() {
        Frm_Chasier obj = new Frm_Chasier();
        obj.setIdtotrans(90013);
        obj.setLbIDHeader(20065);
        obj.setTotal(28000.00);
         int i = obj.doTransac();
         Assert.assertEquals(1, i);
     }
     
     @Test
     public void testProCFailed(){
        Frm_ManagementPro fPro = new Frm_ManagementPro();
        fPro.setIdpro("");
        fPro.setType("");
        fPro.setTitle("");
        fPro.setArtist("");
        fPro.setYear("");
        fPro.setGenre("");
        fPro.setPrice("");
        fPro.setStock("");
         int i = fPro.doInsertPro();
         Assert.assertEquals(0, i);  
     }
     
     @Test
     public void testEmpCFailed(){
        Frm_ManagementEmp fEmp = new Frm_ManagementEmp();
        fEmp.setIdadm("");
        fEmp.setAiddept("");
        fEmp.setAname("");
        fEmp.setAgdr("");
        fEmp.setAphone("");
        fEmp.setAuser("");
        fEmp.setApass("");
         int i = fEmp.doInsertEmp();
         Assert.assertEquals(0, i);  
     }
     
     @Test
     public void testProUpdate(){
        Frm_ManagementPro fPro = new Frm_ManagementPro();
        fPro.setIdpro("10001");
        fPro.setPrice("20000");
        fPro.setStock("3");
         int i = fPro.doUpdatePro();
         Assert.assertEquals(1, i);  
     }
}

