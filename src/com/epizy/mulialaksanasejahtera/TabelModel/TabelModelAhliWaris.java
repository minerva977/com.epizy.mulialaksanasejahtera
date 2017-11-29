package com.epizy.mulialaksanasejahtera.TabelModel;

import com.epizy.mulialaksanasejahtera.Model.ahliWaris;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class tabelModelAhliWaris extends AbstractTableModel {
    final List<ahliWaris> ahliWarisList;

    public tabelModelAhliWaris(List<ahliWaris> warisList) {
        this.ahliWarisList = warisList;
    }

    @Override
    public int getColumnCount(){
        return 3;
    }

    public int getRowCount() {
        return ahliWarisList.size();
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "No Registrasi";
            case 1:
                return "Nama";
            case 2:
                return "Hubungan";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column){
        switch (column){
            case 0:
                return ahliWarisList.get(row).getNoRegistrasi();
            case 1:
                return ahliWarisList.get(row).getNama();
            case 2:
                return ahliWarisList.get(row).getHubungan();
            default:
                return null;
        }
    }
}
