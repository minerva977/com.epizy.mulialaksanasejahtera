package com.epizy.mulialaksanasejahtera.Controller;

import com.epizy.mulialaksanasejahtera.DAO.ahliWarisDAO;
import com.epizy.mulialaksanasejahtera.DAOImpelement.ahliWarisDAOImpl;
import com.epizy.mulialaksanasejahtera.Model.ahliWaris;
import com.epizy.mulialaksanasejahtera.TabelModel.tabelModelAhliWaris;

import javax.swing.*;
import java.util.List;

public class controllerAhliWaris {
    JFrame jFrame;
    JInternalFrame jInternalFrame;
    ahliWarisDAO ahliWarisDAO;
    List<ahliWaris> controllerahliWarisList;

    public controllerAhliWaris(JFrame jFrame) {
        this.jFrame = jFrame;
        ahliWarisDAO = new ahliWarisDAOImpl();
        controllerahliWarisList = ahliWarisDAO.GetAll();
    }
    public controllerAhliWaris(JInternalFrame jInternalFrame) {
        this.jInternalFrame = jInternalFrame;
        ahliWarisDAO = new ahliWarisDAOImpl();
        controllerahliWarisList = ahliWarisDAO.GetAll();
    }

    public void reset(JTextField NoRegistrasi,JTextField Nama,JTextField Hubungan) {
        NoRegistrasi.setText("");
        Nama.setText("");
        Hubungan.setText("");
    }

    public void setTabel(JTable jTable) {
        controllerahliWarisList = ahliWarisDAO.GetAll();
        tabelModelAhliWaris tabelModelAhliWaris = new tabelModelAhliWaris(controllerahliWarisList);
        jTable.setModel(tabelModelAhliWaris);
    }

    public void getToTabel(int row,JTextField NoRegistrasi,JTextField Nama,JTextField Hubungan) {
        NoRegistrasi.setText(controllerahliWarisList.get(row).getNoRegistrasi());
        Nama.setText(controllerahliWarisList.get(row).getNama());
        Hubungan.setText(controllerahliWarisList.get(row).getHubungan());
    }

    public String getNoRegistrasiFromTabel(int Row) {
        return controllerahliWarisList.get(Row).getNoRegistrasi();
    }

    public void getAllDataFromTabel(int row,JTextField NoRegistrasi,JTextField Nama,JTextField Hubungan) {
        NoRegistrasi.setText(controllerahliWarisList.get(row).getNoRegistrasi());
        Nama.setText(controllerahliWarisList.get(row).getNama());
        Hubungan.setText(controllerahliWarisList.get(row).getHubungan());
    }

    public void save(Object NoRegistrasi,Object Nama,Object Hubungan) {
        ahliWaris ahliWaris = new ahliWaris();
        ahliWaris.setNoRegistrasi(String.valueOf(NoRegistrasi));
        ahliWaris.setNama(String.valueOf(Nama));
        ahliWaris.setHubungan(String.valueOf(Hubungan));
        ahliWarisDAO.Save(ahliWaris);
    }

    public void delete(JTextField NoRegistrasi) {
        if (NoRegistrasi.getText().trim().isEmpty()) {
            ahliWarisDAO.Delete(NoRegistrasi.getText());
        }
        else {
            JOptionPane.showMessageDialog(
                    null , "Maaf NoRegistrasi kosong mohon di isi"
                    ,"Peringatan !!" ,JOptionPane.WARNING_MESSAGE
            );
            NoRegistrasi.requestFocus();
        }
    }

    public void search(JTable jTable,JTextField target) {
        controllerahliWarisList = ahliWarisDAO.GetDataByOject(target.getText());
        tabelModelAhliWaris tabelModelAhliWaris = new tabelModelAhliWaris(controllerahliWarisList);
        jTable.setModel(tabelModelAhliWaris);
    }

    public void searchByObject(JTable jTable,JTextField target) {
        if (!target.getText().trim().isEmpty()) {
            search(jTable,target);
        }
        else {
            JOptionPane.showMessageDialog(
                    null, "Maaf Cari Kosong Mohon Di isi"
                    ,"Peringatan !!" ,JOptionPane.WARNING_MESSAGE
            );
            target.requestFocus();
        }
    }
}
