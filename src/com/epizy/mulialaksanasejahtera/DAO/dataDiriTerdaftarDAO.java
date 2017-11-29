package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.dataDiriTerdaftar;

import java.util.List;

public interface dataDiriTerdaftarDAO {
    void Save(dataDiriTerdaftar diriTerdaftar);
    void Delete(Object object);
    List<dataDiriTerdaftar> GetAll();
    List<dataDiriTerdaftar> GetDataByObject(Object object);
}
