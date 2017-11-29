package com.epizy.mulialaksanasejahtera.TabelModel;

import com.epizy.mulialaksanasejahtera.Model.akun;

import javax.swing.table.AbstractTableModel;
import java.util.List;

 //--Commented out by Inspection START (25/11/2017 12.44.33 PM):
public class tabelModelAkun extends AbstractTableModel {
    final List<akun> akunList;

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
 //--Commented out by Inspection STOP (25/11/2017 12.44.33 PM)
