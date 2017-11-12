/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epizy.mulialaksanasejahtera.DAOImpelement;

import com.epizy.mulialaksanasejahtera.DAO.configDAO;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.swing.*;
import java.net.URL;
import java.util.List;

public class configDAOImpl implements configDAO {

    public configDAOImpl() {

    }

    @Override
    public void getImageFormWeb(String Name, JLabel jLabel) {
         try{
             //set URL
            URL url=new URL("http://localhost/Mulia_laksana_sejatra_web/foto/"+Name);
            String xhtml;
            //set Model Iamge
            xhtml="<html>"
                    + "<img src='"+url+"'border= '5px' width='260' height='400'>"
                    + "</html>";
            //Set Ke Label
            jLabel.setText(xhtml);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    /*
    * List Pengganti parameter yang terlalu panjang akan ber isi sebagai berikut
    * listObjects.get(1) = Username Email
    * listObjects.get(2) = Password Email
    * listObjects.get(3) = Email Pengirim
    * listObjects.get(4) = Email Tujuan
    * listObjects.get(5) = Subjek Email
    * listObjects.get(6) = Pesan Email
    */
    @Override
    public void SendEmail(List<Object> listObjects) {
        //deklarasi variabel
        SimpleEmail email = new SimpleEmail();
        
        //konfigurasi email
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(587);
        email.setSSL(true);
        email.setAuthentication(listObjects.get(1).toString(), listObjects.get(2).toString());
        email.setSSLOnConnect(true);
        
        try{
            // Email pengirim
            email.setFrom(listObjects.get(3).toString());

            //Email Tujuan
            email.addTo(listObjects.get(4).toString());

            //Subjek Email
            email.setSubject(listObjects.get(5).toString());

            //Isi Pesan
            email.setMsg(listObjects.get(6).toString());

            //Mengirim Email
            email.send();
            
            JOptionPane.showMessageDialog(null, "Pesan Terkirim");
        }catch(EmailException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Pesan Gagal Terkirim");
        }
    }
}
