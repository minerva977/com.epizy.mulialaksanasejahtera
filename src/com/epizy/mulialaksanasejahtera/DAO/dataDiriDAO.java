package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.dataDiri;

import java.util.List;

public interface dataDiriDAO {
    public void Save(dataDiri dataDiri);
    public void Update(dataDiri dataDiri);
    public void Delete(Object object);
    public List<dataDiri> GetAll();
    public List<dataDiri> GetDataByObject(Object object);
}
