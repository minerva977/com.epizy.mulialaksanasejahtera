package com.epizy.mulialaksanasejahtera.Controller;

import com.epizy.mulialaksanasejahtera.DAO.kerjaDAO;
import com.epizy.mulialaksanasejahtera.DAOImpl.kerjaDAOImpl;
import com.epizy.mulialaksanasejahtera.Model.kerja;

import javax.swing.*;
import java.util.List;

public class controllerKerja {
    JFrame jFrame;
    JInternalFrame jInternalFrame;
    final kerjaDAO kerjaDAO;
    final List<kerja> kerjaList;

// --Commented out by Inspection START (25/11/2017 12.44.33 PM):
//    public controllerKerja (JFrame jFrame) {
//        this.jFrame = jFrame;
//        kerjaDAO = new kerjaDAOImpl();
//        kerjaList = kerjaDAO.GetAll();
//    }
// --Commented out by Inspection STOP (25/11/2017 12.44.33 PM)

    public controllerKerja (JInternalFrame jInternalFrame) {
        this.jInternalFrame = jInternalFrame;
        kerjaDAO = new kerjaDAOImpl();
        kerjaList = kerjaDAO.GetAll();
    }

    public void save (Object object1,Object object2,Object object3) {
        kerja kerja = new kerja();
        kerja.setNoRegistrasi(String.valueOf(object1));
        kerja.setTujuan(String.valueOf(object2));
        kerja.setKeterampilan(String.valueOf(object3));
        kerjaDAO.Save(kerja);
    }
}
