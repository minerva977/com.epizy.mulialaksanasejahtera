package com.epizy.mulialaksanasejahtera.TabelModel;

import com.epizy.mulialaksanasejahtera.Model.akun;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class tabelModelAkun extends AbstractTableModel {
    List<akun> akunList;

    public tabelModelAkun(List<akun> akuns) {
        this.akunList = akuns;
    }

    @Override
    public int getColumnCount(){
        return 3;
    }

    public int getRowCount() {
        return akunList.size();
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "No Registrasi";
            case 1:
                return "Username";
            case 2:
                return "Passowrd";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column){
        switch (column){
            case 0:
                return akunList.get(row).getNoRegistrasi();
            case 1:
                return akunList.get(row).getNoRegistrasi();
            case 2:
                return akunList.get(row).getNoRegistrasi();
            default:
                return null;
        }
    }
}
