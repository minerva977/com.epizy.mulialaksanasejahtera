package com.epizy.mulialaksanasejahtera.TabelModel;

import com.epizy.mulialaksanasejahtera.Model.fisik;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class tabelModelFisik extends AbstractTableModel {
    List<fisik> fisikList;

    public tabelModelFisik (List<fisik> fisiks) {
        this.fisikList = fisiks;
    }

    @Override
    public int getColumnCount(){
        return 10;
    }

    public int getRowCount() {
        return fisikList.size();
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Merokok";
            case 1:
                return "Keterangan";
            case 2:
                return "Alkohol";
            case 3:
                return "keterangan";
            case 4:
                return "Buta Warna";
            case 5:
                return "Keterangan";
            case 6:
                return "Rabun jauh/Dekat";
            case 7:
                return "Keterangan";
            case 8:
                return "Alergi";
            case 9:
                return "keterangan";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column){
        switch (column){
            case 0:
                return fisikList.get(row).getMerokok();
            case 1:
                return fisikList.get(row).getKeteranganMerokok();
            case 2:
                return fisikList.get(row).getAlkohol();
            case 3:
                return fisikList.get(row).getKeteranganAlkohol();
            case 4:
                return fisikList.get(row).getButaWarna();
            case 5:
                return fisikList.get(row).getKeteranganButaWarna();
            case 6:
                return fisikList.get(row).getRabun();
            case 7:
                return fisikList.get(row).getKeteranganRabun();
            case 8:
                return fisikList.get(row).getAlergi();
            case 9:
                return fisikList.get(row).getKeteranganAlergi();
            default:
                return null;
        }
    }
}
