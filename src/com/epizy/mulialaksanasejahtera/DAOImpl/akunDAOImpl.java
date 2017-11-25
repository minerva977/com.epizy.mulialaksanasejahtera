package com.epizy.mulialaksanasejahtera.DAOImpl;

import com.epizy.mulialaksanasejahtera.DAO.akunDAO;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;
import com.epizy.mulialaksanasejahtera.Model.akun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class akunDAOImpl implements akunDAO {
    private final String insert = "INSERT INTO `akun`(`no_reg`, `username`, `password`) VALUES (?,?,?)";
    private final String update = "UPDATE `akun` SET `username`=?,`password`=? WHERE `no_reg`=?";
    private final String delete = "DELETE FROM `akun` WHERE `no_reg`=?";
    private final String select = "SELECT * FROM `akun`";
    private final String selectWhere = "SELECT * FROM `akun` WHERE `no_reg` LIKE ? OR `username` LIKE ? OR `username` LIKE ?";
    private Connection connection;

    public akunDAOImpl(){
        connection = dataBaseConncetionFactory.getConnection();
    }

    @Override
    public void Save(akun akun) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,akun.getNoRegistrasi());
            preparedStatement.setString(2,akun.getUsername());
            preparedStatement.setString(3,akun.getPassword());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void Update(akun akun) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1,akun.getUsername());
            preparedStatement.setString(2,akun.getPassword());
            preparedStatement.setString(3,akun.getNoRegistrasi());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
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
    public List<akun> GetAll() {
        List<akun> akunList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                akun akun = new akun();
                akun.setNoRegistrasi(resultSet.getString(1));
                akun.setUsername(resultSet.getString(2));
                akun.setPassword(resultSet.getString(3));
                akunList.add(akun);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return akunList;
    }

    @Override
    public List<akun> GetDataByOject(Object object) {
        List<akun> akunList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(selectWhere);
            preparedStatement.setString(1, String.valueOf(object));
            preparedStatement.setString(2, String.valueOf(object));
            preparedStatement.setString(3, String.valueOf(object));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                akun akun = new akun();
                akun.setNoRegistrasi(resultSet.getString(1));
                akun.setUsername(resultSet.getString(2));
                akun.setPassword(resultSet.getString(3));
                akunList.add(akun);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return akunList;
    }
}
