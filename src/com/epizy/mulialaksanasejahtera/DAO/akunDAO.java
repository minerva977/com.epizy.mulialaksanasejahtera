package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.akun;

import java.util.List;

public interface akunDAO {
    void Save(akun akun);
    void Update(akun akun);
    void Delete(Object object);
    List<akun> GetAll();
    List<akun> GetDataByOject(Object object);
}
