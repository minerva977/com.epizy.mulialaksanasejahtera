package com.epizy.mulialaksanasejahtera.DAOImpelement;

import com.epizy.mulialaksanasejahtera.DAO.pertanyaanDAO;
import com.epizy.mulialaksanasejahtera.Model.pertanyaan;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;

import java.sql.Connection;
import java.util.List;

public class pertanyaanDAOImpl implements pertanyaanDAO {
    private final String insert = "INSERT INTO `pertanyaan`(`no_reg`, `rencana`, `perusahaan`) VALUES (?,?,?)";
    private final String update = "UPDATE `pertanyaan` SET `rencana`=[value-2],`perusahaan`=[value-3] WHERE `no_reg`=?";
    private final String delete = "DELETE FROM `pertanyaan` WHERE `no_reg`=?";
    private final String select = "SELECT * FROM `pertanyaan`";
    private final String selectWhere = "SELECT * FROM `pertanyaan` WHERE `no_reg`=? OR `rencana`=? OR `perusahaan`=?";
    private Connection connection;

    public pertanyaanDAOImpl() {
        connection = dataBaseConncetionFactory.getConnection();
    }
    @Override
    public void Save(pertanyaan pertanyaan) {

    }

    @Override
    public void Update(pertanyaan pertanyaan) {

    }

    @Override
    public void Delete(Object object) {

    }

    @Override
    public List<pertanyaan> GetAll() {
        return null;
    }

    @Override
    public List<pertanyaan> GetDataByOject(Object object) {
        return null;
    }
}
