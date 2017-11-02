package com.epizy.mulialaksanasejahtera.DAOImpelement;

import com.epizy.mulialaksanasejahtera.DAO.kerjaDAO;
import com.epizy.mulialaksanasejahtera.Model.kerja;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;

import java.sql.Connection;
import java.util.List;

public class kerjaDAOImpl implements kerjaDAO {
    private final String insert = "INSERT INTO `kerja`(`no_reg`, `tujuan`, `keterampilan`) " +
            "VALUES (?,?,?)";
    private final String update = "UPDATE `kerja` SET `tujuan`=?,`keterampilan`=? WHERE `no_reg`=?";
    private final String delete = "DELETE FROM `kerja` WHERE `no_reg`=?";
    private final String select = "SELECT * FROM `kerja`";
    private final String selectWhere = "SELECT * FROM `kerja` WHERE `no_reg`=? OR `tujuan`=? OR `keterampilan`=?";
    private Connection connection;

    public  kerjaDAOImpl(){
        connection = dataBaseConncetionFactory.getConnection();
    }
    @Override
    public void Save(kerja kerja) {

    }

    @Override
    public void Update(kerja kerja) {

    }

    @Override
    public void Delete(Object object) {

    }

    @Override
    public List<kerja> GetAll() {
        return null;
    }

    @Override
    public List<kerja> GetDataByOject(Object object) {
        return null;
    }
}
