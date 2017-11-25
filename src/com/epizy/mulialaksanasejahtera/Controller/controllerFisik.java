package com.epizy.mulialaksanasejahtera.Controller;

import com.epizy.mulialaksanasejahtera.DAO.fisikDAO;
import com.epizy.mulialaksanasejahtera.DAOImpl.fisikDAOImpl;
import com.epizy.mulialaksanasejahtera.Model.fisik;

import javax.swing.*;
import java.util.List;

public class controllerFisik {
    JFrame jFrame;
    JInternalFrame jInternalFrame;
    fisikDAO fisikDAO;
    List<fisik> fisikList;

    public controllerFisik (JFrame jFrame) {
        this.jFrame =jFrame;
        fisikDAO = new fisikDAOImpl();
        fisikList = fisikDAO.GetAll();
    }

    public controllerFisik (JInternalFrame jInternalFrame) {
        this.jInternalFrame = jInternalFrame;
        fisikDAO = new fisikDAOImpl();
        fisikList = fisikDAO.GetAll();
    }

    public void save (Object object1,Object object2,Object object3,Object object4,Object object5,Object object6
            ,Object object7,Object object8,Object object9,Object object10,Object object11,Object object12,Object object13) {
        fisik fisik = new fisik();
        fisik.setNoRegistrasi(String.valueOf(object1));
        fisik.setMerokok(String.valueOf(object2));
        fisik.setKeteranganMerokok(String.valueOf(object3));
        fisik.setAlkohol(String.valueOf(object4));
        fisik.setKeteranganAlkohol(String.valueOf(object5));
        fisik.setTato(String.valueOf(object6));
        fisik.setKeteranganTato(String.valueOf(object7));
        fisik.setButaWarna(String.valueOf(object8));
        fisik.setKeteranganButaWarna(String.valueOf(object9));
        fisik.setRabun(String.valueOf(object10));
        fisik.setKeteranganRabun(String.valueOf(object11));
        fisik.setAlergi(String.valueOf(object12));
        fisik.setKeteranganAlergi(String.valueOf(object13));
        fisikDAO.Save(fisik);
    }
}
