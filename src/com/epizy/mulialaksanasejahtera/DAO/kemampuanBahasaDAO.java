package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.kemampuanBahasa;

import java.util.List;

public interface kemampuanBahasaDAO {
    public void Save(kemampuanBahasa kemampuanBahasa);
    public void Delete(Object object);
    public List<kemampuanBahasa> GetAll();
    public List<kemampuanBahasa> GetDataByOject(Object object);
}
