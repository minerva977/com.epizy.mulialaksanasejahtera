package com.epizy.mulialaksanasejahtera.Controller;

import com.epizy.mulialaksanasejahtera.DAO.dataDiriDAO;
import com.epizy.mulialaksanasejahtera.DAOImpl.dataDiriDAOImpl;
import com.epizy.mulialaksanasejahtera.Model.dataDiri;
import com.epizy.mulialaksanasejahtera.TabelModel.tabelModelDataDiri;

import javax.swing.*;
import java.util.List;

public class controllerDataDiri {
    JFrame jFrame;
    JInternalFrame jInternalFrame;
    final dataDiriDAO dataDiriDAO;
    List<dataDiri> dataDiriList;

 //--Commented out by Inspection START (25/11/2017 12.44.33 PM):
    public controllerDataDiri(JFrame jFrames) {
        this.jFrame = jFrames;
        dataDiriDAO = new dataDiriDAOImpl();
        dataDiriList = dataDiriDAO.GetAll();
    }
 //--Commented out by Inspection STOP (25/11/2017 12.44.33 PM)
    public controllerDataDiri(JInternalFrame jInternalFrame) {
        this.jInternalFrame = jInternalFrame;
        dataDiriDAO = new dataDiriDAOImpl();
        dataDiriList = dataDiriDAO.GetAll();
    }

    public void setTabel(JTable jTable) {
        dataDiriList = dataDiriDAO.GetAll();
        tabelModelDataDiri tabelModelDataDiri = new tabelModelDataDiri(dataDiriList);
        jTable.setModel(tabelModelDataDiri);
    }

 //--Commented out by Inspection START (25/11/2017 12.44.33 PM):
    public void save(JTextField jTextField1,JTextField jTextField2,JTextField jTextField3
            ,JTextField jTextField4,JTextField jTextField5,JTextField jTextField6,JTextField jTextField7
            ,JTextField jTextField8,JTextField jTextField9,JTextField jTextField10,JTextField jTextField11
            ,JTextField jTextField12,JTextField jTextField13,JTextField jTextField14,JTextField jTextField15
            ,JTextField jTextField16,JTextField jTextField17,JTextField jTextField18,JTextField jTextField19
            ,JTextField jTextField20,JTextField jTextField21,JTextField jTextField22,JTextField jTextField23
            ,JTextField jTextField24,JTextField jTextField25,JTextField jTextField26,JTextField jTextField27) {
        dataDiri dataDiri = new dataDiri();
        dataDiri.setNoRegistrasi(jTextField1.getText());
        dataDiri.setTanggal(jTextField2.getText());
        dataDiri.setKelamin(jTextField3.getText());
        dataDiri.setPotonganGaji(jTextField4.getText());
        dataDiri.setNoKTP(jTextField5.getText());
        dataDiri.setTempatKTPDiBuat(jTextField6.getText());
        dataDiri.setTanggalKTPDiBuat(jTextField7.getText());
        dataDiri.setNama(jTextField8.getText());
        dataDiri.setUsia(jTextField9.getText());
        dataDiri.setAlamat(jTextField10.getText());
        dataDiri.setDesaKelurahan(jTextField11.getText());
        dataDiri.setKecamatan(jTextField12.getText());
        dataDiri.setKabupatenKota(jTextField13.getText());
        dataDiri.setPropinsi(jTextField14.getText());
        dataDiri.setTempatLahir(jTextField15.getText());
        dataDiri.setTanggalLahir(jTextField16.getText());
        dataDiri.setNoTelpon(jTextField17.getText());
        dataDiri.setNoHPNoFlexy(jTextField18.getText());
        dataDiri.setTinggiBadan(jTextField19.getText());
        dataDiri.setBeratbadan(jTextField20.getText());
        dataDiri.setSetatus(jTextField21.getText());
        dataDiri.setTanggalSetatus(jTextField22.getText());
        dataDiri.setPendidikan(jTextField23.getText());
        dataDiri.setAgama(jTextField24.getText());
        dataDiri.setFoto(jTextField25.getText());
        dataDiri.setEmail(jTextField26.getText());
        dataDiri.setKeterampilanKusus(jTextField27.getText());
        dataDiriDAO.Save(dataDiri);
    }
 //--Commented out by Inspection STOP (25/11/2017 12.44.33 PM)

 //--Commented out by Inspection START (25/11/2017 12.44.33 PM):
    public void update(JTextField jTextField1,JTextField jTextField2,JTextField jTextField3
            ,JTextField jTextField4,JTextField jTextField5,JTextField jTextField6,JTextField jTextField7
            ,JTextField jTextField8,JTextField jTextField9,JTextField jTextField10,JTextField jTextField11
            ,JTextField jTextField12,JTextField jTextField13,JTextField jTextField14,JTextField jTextField15
            ,JTextField jTextField16,JTextField jTextField17,JTextField jTextField18,JTextField jTextField19
            ,JTextField jTextField20,JTextField jTextField21,JTextField jTextField22,JTextField jTextField23
            ,JTextField jTextField24,JTextField jTextField25,JTextField jTextField26,JTextField jTextField27) {
        dataDiri dataDiri = new dataDiri();
        dataDiri.setNoRegistrasi(jTextField1.getText());
        dataDiri.setTanggal(jTextField2.getText());
        dataDiri.setKelamin(jTextField3.getText());
        dataDiri.setPotonganGaji(jTextField4.getText());
        dataDiri.setNoKTP(jTextField5.getText());
        dataDiri.setTempatKTPDiBuat(jTextField6.getText());
        dataDiri.setTanggalKTPDiBuat(jTextField7.getText());
        dataDiri.setNama(jTextField8.getText());
        dataDiri.setUsia(jTextField9.getText());
        dataDiri.setAlamat(jTextField10.getText());
        dataDiri.setDesaKelurahan(jTextField11.getText());
        dataDiri.setKecamatan(jTextField12.getText());
        dataDiri.setKabupatenKota(jTextField13.getText());
        dataDiri.setPropinsi(jTextField14.getText());
        dataDiri.setTempatLahir(jTextField15.getText());
        dataDiri.setTanggalLahir(jTextField16.getText());
        dataDiri.setNoTelpon(jTextField17.getText());
        dataDiri.setNoHPNoFlexy(jTextField18.getText());
        dataDiri.setTinggiBadan(jTextField19.getText());
        dataDiri.setBeratbadan(jTextField20.getText());
        dataDiri.setSetatus(jTextField21.getText());
        dataDiri.setTanggalSetatus(jTextField22.getText());
        dataDiri.setPendidikan(jTextField23.getText());
        dataDiri.setAgama(jTextField24.getText());
        dataDiri.setFoto(jTextField25.getText());
        dataDiri.setEmail(jTextField26.getText());
        dataDiri.setKeterampilanKusus(jTextField27.getText());
        dataDiriDAO.Update(dataDiri);
    }
 //--Commented out by Inspection STOP (25/11/2017 12.44.33 PM)

    public void delete(Object NoRegistrasi) {
        if (!"".equals(NoRegistrasi)) {
            dataDiriDAO.Delete(NoRegistrasi);
        }
        else {
            JOptionPane.showMessageDialog(
                    null , "Maaf NoRegistrasi kosong mohon di isi"
                    ,"Peringatan !!" ,JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public void saerch(JTable jTable,JTextField target) {
        dataDiriList = dataDiriDAO.GetDataByObject(target.getText());
        tabelModelDataDiri tabelModelDataDiri = new tabelModelDataDiri(dataDiriList);
        jTable.setModel(tabelModelDataDiri);
    }

    public void searchByOject(JTable jTable,JTextField target) {
        if (!target.getText().trim().isEmpty()) {
            saerch(jTable,target);
        }
        else {
            JOptionPane.showMessageDialog(
                    null , "Maaf Cari kosong mohon di isi"
                    ,"Peringatan !!" ,JOptionPane.WARNING_MESSAGE
            );
            target.requestFocus();
        }
    }
}
