/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epizy.mulialaksanasejahtera.Controller;

import com.epizy.mulialaksanasejahtera.DAO.configDAO;
import com.epizy.mulialaksanasejahtera.DAOImpelement.configDAOImpl;

import javax.swing.*;
import java.util.List;

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
    public void sendEmail(List<Object> objectList){
        configDAO.SendEmail(objectList);
    }
}
