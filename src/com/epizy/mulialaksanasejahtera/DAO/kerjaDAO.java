package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.kerja;

import java.util.List;

public interface kerjaDAO {
    public void Save(kerja kerja);
    public void Update(kerja kerja);
    public void Delete(Object object);
    public List<kerja> GetAll();
    public List<kerja> GetDataByOject(Object object);
}
