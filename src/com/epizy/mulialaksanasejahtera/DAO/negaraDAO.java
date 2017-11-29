package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.negara;

import java.util.List;

// --Commented out by Inspection START (25/11/2017 12.44.33 PM):
public interface negaraDAO {
    void Save(negara negara);
    void Update(negara negara);
    void Delete(Object object);
    List<negara> GetAll();
    List<negara> GetDataByOject(Object object);
}
// --Commented out by Inspection STOP (25/11/2017 12.44.33 PM)
