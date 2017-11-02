package com.epizy.mulialaksanasejahtera.DAOImpelement;

import com.epizy.mulialaksanasejahtera.DAO.negaraDAO;
import com.epizy.mulialaksanasejahtera.Model.negara;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;

import java.sql.Connection;
import java.util.List;

public class negaraDAOImpl implements negaraDAO {
    private final String insert = "INSERT INTO `negara`(`id`, `nama_negara`) VALUES (?,?)";
    private final String update = "UPDATE `negara` SET `nama_negara`=? WHERE `id`=?";
    private final String delete = "DELETE FROM `negara` WHERE `id`=?";
    private final String select = "SELECT * FROM `negara`";
    private final String selectWhere = "SELECT * FROM `negara` WHERE `id`=? OR `nama_negara`=?";
    private Connection connection;

    public negaraDAOImpl(){
        connection = dataBaseConncetionFactory.getConnection();
    }
    @Override
    public void Save(negara negara) {

    }

    @Override
    public void Update(negara negara) {

    }

    @Override
    public void Delete(Object object) {

    }

    @Override
    public List<negara> GetAll() {
        return null;
    }

    @Override
    public List<negara> GetDataByOject(Object object) {
        return null;
    }
}
