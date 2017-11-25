package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.pertanyaan;

import java.util.List;

public interface pertanyaanDAO {
    public void Save(pertanyaan pertanyaan);
    public void Delete(Object object);
    public List<pertanyaan> GetAll();
    public List<pertanyaan> GetDataByOject(Object object);
}
