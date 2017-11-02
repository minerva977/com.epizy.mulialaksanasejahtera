package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.negara;

import java.util.List;

public interface negaraDAO {
    public void Save(negara negara);
    public void Update(negara negara);
    public void Delete(Object object);
    public List<negara> GetAll();
    public List<negara> GetDataByOject(Object object);
}
