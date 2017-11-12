package com.epizy.mulialaksanasejahtera.Controller;

import com.epizy.mulialaksanasejahtera.DAO.informasiKeluargaDAO;
import com.epizy.mulialaksanasejahtera.DAOImpelement.informasiKeluargaDAOImpl;
import com.epizy.mulialaksanasejahtera.Model.informasiKeluarga;

import javax.swing.*;
import java.util.List;

public class controllerInformasiKeluarga {
    JFrame jFrame;
    JInternalFrame jInternalFrame;
    informasiKeluargaDAO informasiKeluargaDAO;
    List<informasiKeluarga> informasiKeluargaList;

    public controllerInformasiKeluarga(JFrame jFrame) {
        this.jFrame = jFrame;
        informasiKeluargaDAO = new informasiKeluargaDAOImpl();
        informasiKeluargaList = informasiKeluargaDAO.GetAll();
    }

    public controllerInformasiKeluarga(JInternalFrame jInternalFrame) {
        this.jInternalFrame = jInternalFrame;
        informasiKeluargaDAO = new informasiKeluargaDAOImpl();
        informasiKeluargaList = informasiKeluargaDAO.GetAll();
    }

    public void save(Object object1,Object object2,Object object3,Object object4,Object object5,Object object6
            ,Object object7,Object object8,Object object9,Object object10,Object object11,Object object12,Object object13
            ,Object object14,Object object15,Object object16) {
        
    }
}
