package com.epizy.mulialaksanasejahtera.DAOImpl;

import com.epizy.mulialaksanasejahtera.DAO.kerjaDAO;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;
import com.epizy.mulialaksanasejahtera.Model.kerja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class kerjaDAOImpl implements kerjaDAO {
    private final Connection connection;

    public  kerjaDAOImpl(){
        connection = dataBaseConncetionFactory.getConnection();
    }
    @Override
    public void Save(kerja kerja) {
        PreparedStatement preparedStatement = null;
        try {
            String insert = "INSERT INTO `kerja`(`no_reg`, `tujuan`, `keterampilan`) " +
                    "VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,kerja.getNoRegistrasi());
            preparedStatement.setString(2,kerja.getTujuan());
            preparedStatement.setString(3,kerja.getKeterampilan());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            try {
                String update = "UPDATE `kerja` SET `tujuan`=?,`keterampilan`=? WHERE `no_reg`=?";
                preparedStatement = connection.prepareStatement(update);
                preparedStatement.setString(3,kerja.getNoRegistrasi());
                preparedStatement.setString(1,kerja.getTujuan());
                preparedStatement.setString(2,kerja.getKeterampilan());
                preparedStatement.executeUpdate();
            }catch (SQLException ex) {
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
    public List<kerja> GetAll() {
        List<kerja> kerjaList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            String select = "SELECT * FROM `kerja`";
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                kerja kerja = new kerja();
                kerja.setNoRegistrasi(resultSet.getString(1));
                kerja.setTujuan(resultSet.getString(2));
                kerja.setKeterampilan(resultSet.getString(3));
                kerjaList.add(kerja);
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
        return  kerjaList;
    }

}
