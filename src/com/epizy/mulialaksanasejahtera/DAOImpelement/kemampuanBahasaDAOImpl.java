package com.epizy.mulialaksanasejahtera.DAOImpelement;

import com.epizy.mulialaksanasejahtera.DAO.kemampuanBahasaDAO;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;
import com.epizy.mulialaksanasejahtera.Model.kemampuanBahasa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private final String selectWhere = "SELECT * FROM `akun` WHERE `no_reg` LIKE ? OR `username` LIKE ? OR `username` LIKE ?";
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
            try {
                preparedStatement = connection.prepareStatement(update);
                preparedStatement.setString(1,kemampuanBahasa.getInggris());
                preparedStatement.setString(2,kemampuanBahasa.getMandarin());
                preparedStatement.setString(3,kemampuanBahasa.getHokian());
                preparedStatement.setString(4,kemampuanBahasa.getLain());
                preparedStatement.executeUpdate();
            }catch (SQLException ex) {
                e.printStackTrace();
                ex.printStackTrace();
            }
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
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, String.valueOf(object));
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
    public List<kemampuanBahasa> GetAll() {
        List<kemampuanBahasa> kemampuanBahasaList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                kemampuanBahasa kemampuanBahasa = new kemampuanBahasa();
                kemampuanBahasa.setNoRegistrasi(resultSet.getString(1));
                kemampuanBahasa.setInggris(resultSet.getString(2));
                kemampuanBahasa.setMandarin(resultSet.getString(3));
                kemampuanBahasa.setHokian(resultSet.getString(4));
                kemampuanBahasa.setHokka(resultSet.getString(5));
                kemampuanBahasa.setLain(resultSet.getString(6));
                kemampuanBahasaList.add(kemampuanBahasa);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return  kemampuanBahasaList;
    }

    @Override
    public List<kemampuanBahasa> GetDataByOject(Object object) {
        List<kemampuanBahasa> kemampuanBahasaList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(selectWhere);
            preparedStatement.setString(1, String.valueOf(object));
            preparedStatement.setString(2, String.valueOf(object));
            preparedStatement.setString(3, String.valueOf(object));
            preparedStatement.setString(4, String.valueOf(object));
            preparedStatement.setString(5, String.valueOf(object));
            preparedStatement.setString(6, String.valueOf(object));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                kemampuanBahasa kemampuanBahasa = new kemampuanBahasa();
                kemampuanBahasa.setNoRegistrasi(resultSet.getString(1));
                kemampuanBahasa.setInggris(resultSet.getString(2));
                kemampuanBahasa.setMandarin(resultSet.getString(3));
                kemampuanBahasa.setHokian(resultSet.getString(4));
                kemampuanBahasa.setHokka(resultSet.getString(5));
                kemampuanBahasa.setLain(resultSet.getString(6));
                kemampuanBahasaList.add(kemampuanBahasa);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return  kemampuanBahasaList;
    }
}
