package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.dataDiriTerdaftar;

import java.util.List;

public interface dataDiriTerdaftarDAO {
    public void Save(dataDiriTerdaftar diriTerdaftar);
    public void Delete(Object object);
    public List<dataDiriTerdaftar> GetAll();
    public List<dataDiriTerdaftar> GetDataByObject(Object object);
}
