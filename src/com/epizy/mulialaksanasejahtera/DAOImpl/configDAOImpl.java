/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epizy.mulialaksanasejahtera.DAOImpl;

import com.epizy.mulialaksanasejahtera.DAO.configDAO;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings("ALL")
public class configDAOImpl implements configDAO {

    public configDAOImpl() {

    }

    @SuppressWarnings("ThrowablePrintedToSystemOut")
    @Override
    public void getImageFormWeb(String Name, JLabel jLabel) {
         try{
             //set URL
             String patch = "https://ptmls.000webhostapp.com/foto/"+Name;
            URL url = new URL(patch);
            String xhtml;
            //set Model Iamge
            xhtml = "<html>"
                    + "<img src='"+url+"' border='5px' width='260' height='400'>"
                    + "</html>";
            //Set Ke Label
            jLabel.setText(xhtml);
        }catch(MalformedURLException e){
             //noinspection ThrowablePrintedToSystemOut
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
    @SuppressWarnings("deprecation")
    @Override
    public void SendEmail(String [] Object) {
        //deklarasi variabel
        SimpleEmail email = new SimpleEmail();
        
        //konfigurasi email
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(587);
        //noinspection deprecation
        email.setSSL(true);
        email.setAuthentication(Object[1], Object[2]);
        email.setSSLOnConnect(true);
        
        try{
            // Email pengirim
            email.setFrom(Object[3]);

            //Email Tujuan
            email.addTo(Object[4]);

            //Subjek Email
            email.setSubject(Object[5]);

            //Isi Pesan
            email.setMsg(Object[6]);

            //Mengirim Email
            email.send();
            
            JOptionPane.showMessageDialog(null, "Pesan Terkirim");
        }catch(EmailException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Pesan Gagal Terkirim");
        }
    }
    
    @Override
    public void setIcon (JFrame jFrame) {
        String patch;
        patch = "/com/epizy/mulialaksanasejahtera/icon/icons8-technical-support-30.png";
        jFrame.setIconImage(new ImageIcon(getClass().getResource(patch)).getImage());
    }
    
    @Override
    public void setIcon (Frame frame) {
        String patch;
        patch = "/com/epizy/mulialaksanasejahtera/icon/icons8-technical-support-30.png";
        frame.setIconImage(new ImageIcon(getClass().getResource(patch)).getImage());
    }
}
