package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.ahliWaris;

import java.util.List;

public interface ahliWarisDAO {
    void Save(ahliWaris ahliWaris);
    void Delete(Object object);
    List<ahliWaris> GetAll();
    List<ahliWaris> GetDataByOject(Object object);
}
