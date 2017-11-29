package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.kemampuanBahasa;

import java.util.List;

public interface kemampuanBahasaDAO {
    void Save(kemampuanBahasa kemampuanBahasa);
    // --Commented out by Inspection (25/11/2017 12.44.33 PM):void Delete(Object object);
    List<kemampuanBahasa> GetAll();
    // --Commented out by Inspection (25/11/2017 12.44.33 PM):List<kemampuanBahasa> GetDataByOject(Object object);
}
