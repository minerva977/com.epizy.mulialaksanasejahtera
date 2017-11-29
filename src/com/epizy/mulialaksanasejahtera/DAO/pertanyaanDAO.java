package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.pertanyaan;

import java.util.List;

public interface pertanyaanDAO {
    void Save(pertanyaan pertanyaan);
    // --Commented out by Inspection (25/11/2017 12.44.33 PM):void Delete(Object object);
    List<pertanyaan> GetAll();
    // --Commented out by Inspection (25/11/2017 12.44.33 PM):List<pertanyaan> GetDataByOject(Object object);
}
