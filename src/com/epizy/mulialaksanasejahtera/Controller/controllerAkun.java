package com.epizy.mulialaksanasejahtera.Controller;

import com.epizy.mulialaksanasejahtera.DAO.akunDAO;
import com.epizy.mulialaksanasejahtera.DAOImpelement.akunDAOImpl;
import com.epizy.mulialaksanasejahtera.Model.akun;
import com.epizy.mulialaksanasejahtera.TabelModel.tabelModeAkun;

import javax.swing.*;
import java.util.List;

public class controllerAkun {
    JFrame jFrame;
    akunDAO akunDAO;
    List<akun> akunList;

    public controllerAkun(JFrame jFrame) {
        this.jFrame = jFrame;
        akunDAO = new akunDAOImpl();
        akunList = akunDAO.GetAll();
    }

    public void reset(JTextField NoRegistrasi,JTextField Username,JTextField Password) {
        NoRegistrasi.setText("");
        Username.setText("");
        Password.setText("");
    }

    public void setTabel(JTable jTable) {
        akunList = akunDAO.GetAll();
        tabelModeAkun tabelModeAkun = new tabelModeAkun(akunList);
        jTable.setModel(tabelModeAkun);
    }

    public void getToTabel(int row,JTextField NoRegistrasi,JTextField Username,JTextField Password) {
        NoRegistrasi.setText(akunList.get(row).getNoRegistrasi());
        Username.setText(akunList.get(row).getUsername());
        Password.setText(akunList.get(row).getPassword());
    }

    public String getNoRegistrasiFromTabel(int Row) {
        return akunList.get(Row).getNoRegistrasi();
    }

    public void getAllDataFromTabel(int row,JTextField NoRegistrasi,JTextField Username,JTextField Passowrd) {
        NoRegistrasi.setText(akunList.get(row).getNoRegistrasi());
        Username.setText(akunList.get(row).getUsername());
        Passowrd.setText(akunList.get(row).getPassword());
    }
    public void save(JTextField NoRegistrasi,JTextField Username,JTextField Passowrd) {

    }
}
