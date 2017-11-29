package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.kerja;

import java.util.List;

public interface kerjaDAO {
    void Save(kerja kerja);
    // --Commented out by Inspection (25/11/2017 12.44.33 PM):void Delete(Object object);
    List<kerja> GetAll();
    // --Commented out by Inspection (25/11/2017 12.44.33 PM):List<kerja> GetDataByOject(Object object);
}
