package com.epizy.mulialaksanasejahtera.DAOImpelement;

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
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,kerja.getNoRegistrasi());
            preparedStatement.setString(2,kerja.getTujuan());
            preparedStatement.setString(3,kerja.getKeterampilan());
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
    public void Update(kerja kerja) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1,kerja.getNoRegistrasi());
            preparedStatement.setString(2,kerja.getTujuan());
            preparedStatement.setString(3,kerja.getKeterampilan());
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
    public List<kerja> GetAll() {
        List<kerja> kerjaList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
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
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return  kerjaList;
    }

    @Override
    public List<kerja> GetDataByOject(Object object) {
        List<kerja> kerjaList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(selectWhere);
            preparedStatement.setString(1, String.valueOf(object));
            preparedStatement.setString(2, String.valueOf(object));
            preparedStatement.setString(3, String.valueOf(object));
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
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return  kerjaList;
    }
}
