package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.informasiKeluarga;

import java.util.List;

public interface informasiKeluargaDAO {
    void Save(informasiKeluarga informasiKeluarga);
    // --Commented out by Inspection (25/11/2017 12.44.33 PM):void Delete(Object object);
    List<informasiKeluarga> GetAll();
    // --Commented out by Inspection (25/11/2017 12.44.33 PM):List<informasiKeluarga> GetDataByOject(Object object);
}
