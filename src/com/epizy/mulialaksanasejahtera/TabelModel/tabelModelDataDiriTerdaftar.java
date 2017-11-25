package com.epizy.mulialaksanasejahtera.TabelModel;

import com.epizy.mulialaksanasejahtera.Model.dataDiriTerdaftar;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class tabelModelDataDiriTerdaftar extends AbstractTableModel {
    List<dataDiriTerdaftar> dataDiriList;

    public tabelModelDataDiriTerdaftar(List<dataDiriTerdaftar> dataDiris) {
        this.dataDiriList = dataDiris;
    }

    @Override
    public int getColumnCount(){
        return 5;
    }

    public int getRowCount() {
        return dataDiriList.size();
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "No Registrasi";
            case 1:
                return "Tanggal Daftar";
            case 2:
                return "Nama";
            case 3:
                return "No Telfon";
            case 4:
                return "Alamat";
            case 5:
                return "No KTP";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column){
        switch (column){
            case 0:
                return dataDiriList.get(row).getNoRegistrasi();
            case 1:
                return dataDiriList.get(row).getTanggal();
            case 2:
                return dataDiriList.get(row).getNama();
            case 3:
                return dataDiriList.get(row).getNoTelpon();
            case 4:
                return dataDiriList.get(row).getAlamat();
            case 5:
                return dataDiriList.get(row).getNoKTP();
            default:
                return null;
        }
    }
}
