package com.epizy.mulialaksanasejahtera.DAOImpl;

import com.epizy.mulialaksanasejahtera.DAO.fisikDAO;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;
import com.epizy.mulialaksanasejahtera.Model.fisik;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class fisikDAOImpl implements fisikDAO {
    private String insert = "INSERT INTO `fisik`\n" +
            "(`no_reg`, `merokok`, `merokok_ket`, `alkohol`, `alkohol_ket`, `tato`, `tato_ket`\n" +
            ", `buta_warna`, `buta_warna_ket`, `rabun`, `rabun_ket`, `alergi`, `alergi_ket`) \n" +
            "VALUES \n" +
            "(?,?,?,?,?,?,?\n" +
            ",?,?,?,?,?,?)";
    private final String update = "UPDATE `fisik` \n" +
            "SET \n" +
            "`merokok`=?,`merokok_ket`=?,`alkohol`=?,`alkohol_ket`=?,`tato`=?\n" +
            ",`tato_ket`=?,`buta_warna`=?,`buta_warna_ket`=?,`rabun`=?,`rabun_ket`=?\n" +
            ",`alergi`=?,`alergi_ket`=? \n" +
            "WHERE \n" +
            "`no_reg`=?";
    private final String delete = "DELETE FROM `fisik` WHERE `no_reg`=?";
    private final String select = "SELECT * FROM `fisik`";
    private final String selectWhere = "SELECT * \n" +
            "FROM \n" +
            "`fisik` \n" +
            "WHERE \n" +
            "`no_reg` LIKE ? OR `merokok` LIKE ? OR `merokok_ket` LIKE ? OR `alkohol` LIKE ? OR `alkohol_ket` LIKE ? \n" +
            "OR `tato` LIKE ? OR `tato_ket` LIKE ? OR `buta_warna` LIKE ? OR `buta_warna_ket` LIKE ? \n" +
            "OR `rabun` LIKE ? OR `rabun_ket` LIKE ? OR `alergi` LIKE ? OR `alergi_ket` LIKE ?";
    private Connection connection;

    public fisikDAOImpl() {
        connection = dataBaseConncetionFactory.getConnection();
    }

    @Override
    public void Save(fisik fisik) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,fisik.getNoRegistrasi());
            preparedStatement.setString(2,fisik.getMerokok());
            preparedStatement.setString(3,fisik.getKeteranganMerokok());
            preparedStatement.setString(4,fisik.getAlkohol());
            preparedStatement.setString(5,fisik.getKeteranganAlkohol());
            preparedStatement.setString(6,fisik.getTato());
            preparedStatement.setString(7,fisik.getKeteranganTato());
            preparedStatement.setString(8,fisik.getButaWarna());
            preparedStatement.setString(9,fisik.getKeteranganButaWarna());
            preparedStatement.setString(10,fisik.getRabun());
            preparedStatement.setString(11,fisik.getKeteranganRabun());
            preparedStatement.setString(12,fisik.getAlergi());
            preparedStatement.setString(13,fisik.getKeteranganAlergi());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            try {
                preparedStatement = connection.prepareStatement(update);
                preparedStatement.setString(1,fisik.getMerokok());
                preparedStatement.setString(2,fisik.getKeteranganMerokok());
                preparedStatement.setString(3,fisik.getAlkohol());
                preparedStatement.setString(4,fisik.getKeteranganAlkohol());
                preparedStatement.setString(5,fisik.getTato());
                preparedStatement.setString(6,fisik.getKeteranganTato());
                preparedStatement.setString(7,fisik.getButaWarna());
                preparedStatement.setString(8,fisik.getKeteranganButaWarna());
                preparedStatement.setString(9,fisik.getRabun());
                preparedStatement.setString(10,fisik.getKeteranganRabun());
                preparedStatement.setString(11,fisik.getAlergi());
                preparedStatement.setString(12,fisik.getKeteranganAlergi());
                preparedStatement.setString(13,fisik.getNoRegistrasi());
                preparedStatement.executeUpdate();
            }catch (Exception ex) {
                e.printStackTrace();
                ex.printStackTrace();
            }
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
    public List<fisik> GetAll() {
        List<fisik> fisikList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                fisik fisik = new fisik();
                fisik.setNoRegistrasi(resultSet.getString(1));
                fisik.setMerokok(resultSet.getString(2));
                fisik.setKeteranganMerokok(resultSet.getString(3));
                fisik.setAlkohol(resultSet.getString(4));
                fisik.setKeteranganAlkohol(resultSet.getString(5));
                fisik.setTato(resultSet.getString(6));
                fisik.setKeteranganTato(resultSet.getString(7));
                fisik.setButaWarna(resultSet.getString(8));
                fisik.setKeteranganButaWarna(resultSet.getString(8));
                fisik.setRabun(resultSet.getString(10));
                fisik.setKeteranganRabun(resultSet.getString(11));
                fisik.setAlergi(resultSet.getString(12));
                fisik.setKeteranganAlergi(resultSet.getString(13));
                fisikList.add(fisik);
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
        return fisikList;
    }

    @Override
    public List<fisik> GetDataByOject(Object object) {
        List<fisik> fisikList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1, String.valueOf(object));
            preparedStatement.setString(2, String.valueOf(object));
            preparedStatement.setString(3, String.valueOf(object));
            preparedStatement.setString(4, String.valueOf(object));
            preparedStatement.setString(5, String.valueOf(object));
            preparedStatement.setString(6, String.valueOf(object));
            preparedStatement.setString(7, String.valueOf(object));
            preparedStatement.setString(8, String.valueOf(object));
            preparedStatement.setString(9, String.valueOf(object));
            preparedStatement.setString(10, String.valueOf(object));
            preparedStatement.setString(11, String.valueOf(object));
            preparedStatement.setString(12, String.valueOf(object));
            preparedStatement.setString(13, String.valueOf(object));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                fisik fisik = new fisik();
                fisik.setNoRegistrasi(resultSet.getString(1));
                fisik.setMerokok(resultSet.getString(2));
                fisik.setKeteranganMerokok(resultSet.getString(3));
                fisik.setAlkohol(resultSet.getString(4));
                fisik.setKeteranganAlkohol(resultSet.getString(5));
                fisik.setTato(resultSet.getString(6));
                fisik.setKeteranganTato(resultSet.getString(7));
                fisik.setButaWarna(resultSet.getString(8));
                fisik.setKeteranganButaWarna(resultSet.getString(8));
                fisik.setRabun(resultSet.getString(10));
                fisik.setKeteranganRabun(resultSet.getString(11));
                fisik.setAlergi(resultSet.getString(12));
                fisik.setKeteranganAlergi(resultSet.getString(13));
                fisikList.add(fisik);
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
        return fisikList;
    }
}
