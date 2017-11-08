package com.epizy.mulialaksanasejahtera.Controller;

import com.epizy.mulialaksanasejahtera.DAO.dataDiriDAO;
import com.epizy.mulialaksanasejahtera.DAOImpelement.dataDiriDAOImpl;
import com.epizy.mulialaksanasejahtera.Model.dataDiri;
import com.epizy.mulialaksanasejahtera.TabelModel.tabelModelDataDiri;

import javax.swing.*;
import java.util.List;

public class controllerDataDiri {
    JFrame jFrame;
    dataDiriDAO dataDiriDAO;
    List<dataDiri> dataDiriList;

    public controllerDataDiri(JFrame jFrames) {
        this.jFrame = jFrames;
        dataDiriDAO = new dataDiriDAOImpl();
        dataDiriList = dataDiriDAO.GetAll();
    }

    public void reset(Object object,JTextField jTextField1,JTextField jTextField2,JTextField jTextField3
            ,JTextField jTextField4,JTextField jTextField5,JTextField jTextField6,JTextField jTextField7
            ,JTextField jTextField8,JTextField jTextField9,JTextField jTextField10,JTextField jTextField11
            ,JTextField jTextField12,JTextField jTextField13,JTextField jTextField14,JTextField jTextField15
            ,JTextField jTextField16,JTextField jTextField17,JTextField jTextField18,JTextField jTextField19
            ,JTextField jTextField20,JTextField jTextField21,JTextField jTextField22,JTextField jTextField23
            ,JTextField jTextField24,JTextField jTextField25,JTextField jTextField26,JTextField jTextField27) {
        dataDiriList = dataDiriDAO.GetDataByObject(object);
        if (dataDiriList.isEmpty()){
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
            jTextField8.setText("");
            jTextField9.setText("");
            jTextField10.setText("");
            jTextField11.setText("");
            jTextField12.setText("");
            jTextField13.setText("");
            jTextField14.setText("");
            jTextField15.setText("");
            jTextField16.setText("");
            jTextField17.setText("");
            jTextField18.setText("");
            jTextField19.setText("");
            jTextField20.setText("");
            jTextField21.setText("");
            jTextField22.setText("");
            jTextField23.setText("");
            jTextField24.setText("");
            jTextField25.setText("");
            jTextField26.setText("");
            jTextField27.setText("");
        }
        else {
            jTextField1.setText(dataDiriList.get(1).getNoRegistrasi());
            jTextField2.setText(dataDiriList.get(2).getTanggal());
            jTextField3.setText(dataDiriList.get(3).getKelamin());
            jTextField4.setText(dataDiriList.get(4).getPotonganGaji());
            jTextField5.setText(dataDiriList.get(5).getNoKTP());
            jTextField6.setText(dataDiriList.get(6).getTanggalKTPDiBuat());
            jTextField7.setText(dataDiriList.get(7).getTanggalKTPDiBuat());
            jTextField8.setText(dataDiriList.get(8).getNama());
            jTextField9.setText(dataDiriList.get(9).getUsia());
            jTextField10.setText(dataDiriList.get(10).getAlamat());
            jTextField11.setText(dataDiriList.get(11).getDesaKelurahan());
            jTextField12.setText(dataDiriList.get(12).getKecamatan());
            jTextField13.setText(dataDiriList.get(13).getKabupatenKota());
            jTextField14.setText(dataDiriList.get(14).getPropinsi());
            jTextField15.setText(dataDiriList.get(15).getTempatLahir());
            jTextField16.setText(dataDiriList.get(16).getTanggalLahir());
            jTextField17.setText(dataDiriList.get(17).getNoTelpon());
            jTextField18.setText(dataDiriList.get(18).getNoHPNoFlexy());
            jTextField19.setText(dataDiriList.get(19).getTinggiBadan());
            jTextField20.setText(dataDiriList.get(20).getBeratbadan());
            jTextField21.setText(dataDiriList.get(21).getSetatus());
            jTextField22.setText(dataDiriList.get(22).getTanggalSetatus());
            jTextField23.setText(dataDiriList.get(23).getPendidikan());
            jTextField24.setText(dataDiriList.get(24).getAgama());
            jTextField25.setText(dataDiriList.get(25).getFoto());
            jTextField26.setText(dataDiriList.get(26).getEmail());
            jTextField27.setText(dataDiriList.get(27).getKeterampilanKusus());
        }
    }

    public void setTabel(JTable jTable) {
        dataDiriList = dataDiriDAO.GetAll();
        tabelModelDataDiri tabelModelDataDiri = new tabelModelDataDiri(dataDiriList);
        jTable.setModel(tabelModelDataDiri);
    }


}
