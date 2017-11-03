package com.epizy.mulialaksanasejahtera.DAOImpelement;

import com.epizy.mulialaksanasejahtera.DAO.pertanyaanDAO;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;
import com.epizy.mulialaksanasejahtera.Model.pertanyaan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,pertanyaan.getNoRegistrasi());
            preparedStatement.setString(2,pertanyaan.getRencana());
            preparedStatement.setString(3,pertanyaan.getPrusahaan());
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
    public void Update(pertanyaan pertanyaan) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1,pertanyaan.getNoRegistrasi());
            preparedStatement.setString(2,pertanyaan.getRencana());
            preparedStatement.setString(3,pertanyaan.getPrusahaan());
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
    public List<pertanyaan> GetAll() {
        List<pertanyaan> pertanyaanList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pertanyaan pertanyaan = new pertanyaan();
                pertanyaan.setNoRegistrasi(resultSet.getString(1));
                pertanyaan.setRencana(resultSet.getString(2));
                pertanyaan.setPrusahaan(resultSet.getString(3));
                pertanyaanList.add(pertanyaan);
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
        return  pertanyaanList;
    }

    @Override
    public List<pertanyaan> GetDataByOject(Object object) {
        List<pertanyaan> pertanyaanList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(selectWhere);
            preparedStatement.setString(1, String.valueOf(object));
            preparedStatement.setString(2, String.valueOf(object));
            preparedStatement.setString(3, String.valueOf(object));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pertanyaan pertanyaan = new pertanyaan();
                pertanyaan.setNoRegistrasi(resultSet.getString(1));
                pertanyaan.setRencana(resultSet.getString(2));
                pertanyaan.setPrusahaan(resultSet.getString(3));
                pertanyaanList.add(pertanyaan);
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
        return  pertanyaanList;
    }
}
