package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.akun;

import java.util.List;

public interface akunDAO {
    public void Save(akun akun);
    public void Update(akun akun);
    public void Delete(Object object);
    public List<akun> GetAll();
    public List<akun> GetDataByOject(Object object);
}
