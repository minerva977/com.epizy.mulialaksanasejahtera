/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epizy.mulialaksanasejahtera.Controller;

import com.epizy.mulialaksanasejahtera.DAO.configDAO;
import com.epizy.mulialaksanasejahtera.DAOImpl.configDAOImpl;

import javax.swing.*;

/**
 *
 * @author Nier
 */
public class controllerConfig {
    //Deklarasi Variabel
    private JFrame jFrame;
    private JInternalFrame jInternalFrame;
    configDAO configDAO;

    public controllerConfig() {
        configDAO = new configDAOImpl();
    }

    //mengambil gambar
    public void getIamge(String Name,JLabel jLabel){
        configDAO.getImageFormWeb(Name, jLabel);
    }
    
    //mengirim email
    public void sendEmail(String[] OStrings){
        configDAO.SendEmail(OStrings);
    }
}
