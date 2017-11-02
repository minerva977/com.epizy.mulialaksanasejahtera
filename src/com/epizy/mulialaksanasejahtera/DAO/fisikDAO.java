package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.fisik;

import java.util.List;

public interface fisikDAO {
    public void Save(fisik fisik);
    public void Update(fisik fisik);
    public void Delete(Object object);
    public List<fisik> GetAll();
    public List<fisik> GetDataByOject(Object object);
}
