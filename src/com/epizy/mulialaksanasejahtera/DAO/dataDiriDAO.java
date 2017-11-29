package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.dataDiri;

import java.util.List;

public interface dataDiriDAO {
    void Save(dataDiri dataDiri);
    void Update(dataDiri dataDiri);
    void Delete(Object object);
    List<dataDiri> GetAll();
    List<dataDiri> GetDataByObject(Object object);
}
