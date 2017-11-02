package com.epizy.mulialaksanasejahtera.DAO;

import com.epizy.mulialaksanasejahtera.Model.informasiKeluarga;

import java.util.List;

public interface informasiKeluargaDAO {
    public void Save(informasiKeluarga informasiKeluarga);
    public void Update(informasiKeluarga informasiKeluarga);
    public void Delete(Object object);
    public List<informasiKeluarga> GetAll();
    public List<informasiKeluarga> GetDataByOject(Object object);
}
