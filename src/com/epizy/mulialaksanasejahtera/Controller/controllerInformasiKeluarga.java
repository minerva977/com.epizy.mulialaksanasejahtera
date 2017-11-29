package com.epizy.mulialaksanasejahtera.Controller;

import com.epizy.mulialaksanasejahtera.DAO.informasiKeluargaDAO;
import com.epizy.mulialaksanasejahtera.DAOImpl.informasiKeluargaDAOImpl;
import com.epizy.mulialaksanasejahtera.Model.informasiKeluarga;

import javax.swing.*;
import java.util.List;

public class controllerInformasiKeluarga {
    JFrame jFrame;
    JInternalFrame jInternalFrame;
    final informasiKeluargaDAO informasiKeluargaDAO;
    final List<informasiKeluarga> informasiKeluargaList;

// --Commented out by Inspection START (25/11/2017 12.44.33 PM):
//    public controllerInformasiKeluarga(JFrame jFrame) {
//        this.jFrame = jFrame;
//        informasiKeluargaDAO = new informasiKeluargaDAOImpl();
//        informasiKeluargaList = informasiKeluargaDAO.GetAll();
//    }
// --Commented out by Inspection STOP (25/11/2017 12.44.33 PM)

    public controllerInformasiKeluarga(JInternalFrame jInternalFrame) {
        this.jInternalFrame = jInternalFrame;
        informasiKeluargaDAO = new informasiKeluargaDAOImpl();
        informasiKeluargaList = informasiKeluargaDAO.GetAll();
    }

    public void save(Object object1,Object object2,Object object3,Object object4,Object object5,Object object6
            ,Object object7,Object object8,Object object9,Object object10,Object object11,Object object12,Object object13
            ,Object object14,Object object15,Object object16) {
        informasiKeluarga iKeluarga = new informasiKeluarga();
        iKeluarga.setNoRegistrasi(String.valueOf(object1));
        iKeluarga.setNamaBapak(String.valueOf(object2));
        iKeluarga.setKerjaBapak(String.valueOf(object3));
        iKeluarga.setTempatLahirBapak(String.valueOf(object4));
        iKeluarga.setTanggalLahirBapak(String.valueOf(object5));
        iKeluarga.setNamaIbu(String.valueOf(object6));
        iKeluarga.setKerjaIbu(String.valueOf(object7));
        iKeluarga.setTempatLahirIbu(String.valueOf(object8));
        iKeluarga.setTanggalLahirIbu(String.valueOf(object9));
        iKeluarga.setNamaPasangan(String.valueOf(object10));
        iKeluarga.setKerjaPasagan(String.valueOf(object11));
        iKeluarga.setJumlahAnak(String.valueOf(object12));
        iKeluarga.setUmurAnak(String.valueOf(object13));
        iKeluarga.setJumlahSodaraLakiLaki(String.valueOf(object14));
        iKeluarga.setJumlahSodaraPerempuan(String.valueOf(object15));
        iKeluarga.setAnakKe(String.valueOf(object16));
        informasiKeluargaDAO.Save(iKeluarga);
    }
}
