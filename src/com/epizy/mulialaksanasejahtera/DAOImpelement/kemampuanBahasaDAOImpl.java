package com.epizy.mulialaksanasejahtera.DAOImpelement;

import com.epizy.mulialaksanasejahtera.DAO.kemampuanBahasaDAO;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;
import com.epizy.mulialaksanasejahtera.Model.kemampuanBahasa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class kemampuanBahasaDAOImpl implements kemampuanBahasaDAO {
    private final String insert = "INSERT INTO " +
            "`kemampuan_bahasa`(`no_reg`, `bhs_inggris`, `bhs_mandarin`, `bhs_hokian`, `bhs_hokka`, `bhs_lain`) " +
            "VALUES " +
            "(?,?,?,?,?,?)";
    private final String update = "UPDATE `kemampuan_bahasa` " +
            "SET `bhs_inggris`=?,`bhs_mandarin`=?,`bhs_hokian`=?,`bhs_hokka`=?,`bhs_lain`=? " +
            "WHERE " +
            "`no_reg`=?";
    private final String delete = "DELETE FROM `kemampuan_bahasa` WHERE `no_reg`=?";
    private final String select = "SELECT * FROM `kemampuan_bahasa`";
    private final String selectWhere = "SELECT * FROM `akun` WHERE `no_reg` LIKE %?% OR `username` LIKE %?% OR `username` LIKE %?%";
    private Connection connection;

    public kemampuanBahasaDAOImpl() {
        connection = dataBaseConncetionFactory.getConnection();
    }
    @Override
    public void Save(kemampuanBahasa kemampuanBahasa) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,kemampuanBahasa.getNoRegistrasi());
            preparedStatement.setString(2,kemampuanBahasa.getInggris());
            preparedStatement.setString(3,kemampuanBahasa.getMandarin());
            preparedStatement.setString(4,kemampuanBahasa.getHokian());
            preparedStatement.setString(5,kemampuanBahasa.getLain());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    preparedStatement.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void Update(kemampuanBahasa kemampuanBahasa) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,kemampuanBahasa.getInggris());
            preparedStatement.setString(2,kemampuanBahasa.getMandarin());
            preparedStatement.setString(3,kemampuanBahasa.getHokian());
            preparedStatement.setString(4,kemampuanBahasa.getLain());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    preparedStatement.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void Delete(Object object) {

    }

    @Override
    public List<kemampuanBahasa> GetAll() {
        return null;
    }

    @Override
    public List<kemampuanBahasa> GetDataByOject(Object object) {
        return null;
    }
}
