package com.epizy.mulialaksanasejahtera.Controller;

import com.epizy.mulialaksanasejahtera.DAO.akunDAO;
import com.epizy.mulialaksanasejahtera.DAOImpl.akunDAOImpl;
import com.epizy.mulialaksanasejahtera.Model.akun;
import com.epizy.mulialaksanasejahtera.TabelModel.tabelModelAkun;

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
        tabelModelAkun tabelModelAkun = new tabelModelAkun(akunList);
        jTable.setModel(tabelModelAkun);
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
        akun akun = new akun();
        akun.setNoRegistrasi(NoRegistrasi.getText());
        akun.setUsername(Username.getText());
        akun.setPassword(Passowrd.getText());
        akunDAO.Save(akun);
    }

    public void update(JTextField NoRegistrasi,JTextField Username,JTextField Passowrd) {
        akun akun = new akun();
        akun.setNoRegistrasi(NoRegistrasi.getText());
        akun.setUsername(Username.getText());
        akun.setPassword(Passowrd.getText());
        akunDAO.Update(akun);
    }

    public void delete(JTextField NoRegistrasi) {
        if (!NoRegistrasi.getText().trim().isEmpty()) {
            akunDAO.Delete(NoRegistrasi.getText());
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
        akunList = akunDAO.GetDataByOject(target.getText());
        tabelModelAkun tabelModelAkun = new tabelModelAkun(akunList);
        jTable.setModel(tabelModelAkun);
    }

    public void serchByObject(JTable jTable,JTextField target) {
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
