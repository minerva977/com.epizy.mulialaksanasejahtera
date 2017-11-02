package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.ahliWaris;

import java.util.List;

public interface ahliWarisDAO {
    public void Save(ahliWaris ahliWaris);
    public void Update(ahliWaris ahliWaris);
    public void Delete(Object object);
    public List<ahliWaris> GetAll();
    public List<ahliWaris> GetDataByOject(Object object);
}
