package com.epizy.mulialaksanasejahtera.DAOImpelement;

import com.epizy.mulialaksanasejahtera.DAO.negaraDAO;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;
import com.epizy.mulialaksanasejahtera.Model.negara;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,negara.getId());
            preparedStatement.setString(2,negara.getNama_Negara());
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
    public void Update(negara negara) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1,negara.getId());
            preparedStatement.setString(2,negara.getNama_Negara());
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
    public List<negara> GetAll() {
        List<negara> negaraList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                negara negara = new negara();
                negara.setId(resultSet.getString(1));
                negara.setNama_Negara(resultSet.getString(2));
                negaraList.add(negara);
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
        return  negaraList;
    }

    @Override
    public List<negara> GetDataByOject(Object object) {
        List<negara> negaraList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(selectWhere);
            preparedStatement.setString(1, String.valueOf(object));
            preparedStatement.setString(2, String.valueOf(object));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                negara negara = new negara();
                negara.setId(resultSet.getString(1));
                negara.setNama_Negara(resultSet.getString(2));
                negaraList.add(negara);
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
        return  negaraList;
    }
}
