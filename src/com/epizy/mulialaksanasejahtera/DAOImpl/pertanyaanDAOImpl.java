package com.epizy.mulialaksanasejahtera.DAOImpl;

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
    private final Connection connection;

    public pertanyaanDAOImpl() {
        connection = dataBaseConncetionFactory.getConnection();
    }
    @Override
    public void Save(pertanyaan pertanyaan) {
        PreparedStatement preparedStatement = null;
        try {
            String insert = "INSERT INTO `pertanyaan`(`no_reg`, `pernyataan`, `persetujuan`) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,pertanyaan.getNoRegistrasi());
            preparedStatement.setString(2,pertanyaan.getPernyataan());
            preparedStatement.setString(3,pertanyaan.getPersetujuan());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            try {
                String update = "UPDATE `pertanyaan` SET `pernyataan`=?,`persetujuan`=? WHERE `no_reg`=?";
                preparedStatement = connection.prepareStatement(update);
                preparedStatement.setString(3,pertanyaan.getNoRegistrasi());
                preparedStatement.setString(1,pertanyaan.getPernyataan());
                preparedStatement.setString(2,pertanyaan.getPersetujuan());
                preparedStatement.executeUpdate();
            } catch (Exception ex) {
                e.printStackTrace();
                ex.printStackTrace();
            }
        }
        finally {
            if (connection != null) {
                try {
                    assert preparedStatement != null;
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
            String select = "SELECT * FROM `pertanyaan`";
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pertanyaan pertanyaan = new pertanyaan();
                pertanyaan.setNoRegistrasi(resultSet.getString(1));
                pertanyaan.setPernyataan(resultSet.getString(2));
                pertanyaan.setPersetujuan(resultSet.getString(3));
                pertanyaanList.add(pertanyaan);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
                try {
                    assert preparedStatement != null;
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return  pertanyaanList;
    }

}
