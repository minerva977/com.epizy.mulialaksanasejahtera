package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.fisik;

import java.util.List;

public interface fisikDAO {
    void Save(fisik fisik);
    // --Commented out by Inspection (25/11/2017 12.44.33 PM):void Delete(Object object);
    List<fisik> GetAll();
    // --Commented out by Inspection (25/11/2017 12.44.33 PM):List<fisik> GetDataByOject(Object object);
}
