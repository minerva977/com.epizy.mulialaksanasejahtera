package com.epizy.mulialaksanasejahtera.DAOImpelement;

import com.epizy.mulialaksanasejahtera.DAO.informasiKeluargaDAO;
import com.epizy.mulialaksanasejahtera.Model.informasiKeluarga;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;

import java.sql.Connection;
import java.util.List;

public class informasiKeluargaDAOImpl implements informasiKeluargaDAO {

    private Connection connection;

    public informasiKeluargaDAOImpl(){
        connection = dataBaseConncetionFactory.getConnection();
    }

    @Override
    public void Save(informasiKeluarga informasiKeluarga) {

    }

    @Override
    public void Update(informasiKeluarga informasiKeluarga) {

    }

    @Override
    public void Delete(Object object) {

    }

    @Override
    public List<informasiKeluarga> GetAll() {
        return null;
    }

    @Override
    public List<informasiKeluarga> GetDataByOject(Object object) {
        return null;
    }
}
