package com.epizy.mulialaksanasejahtera.Model;

public class pertanyaan {
    private dataDiri dataDiri = new dataDiri();
    private String NoRegistrasi = dataDiri.getNoRegistrasi();
    private String Rencana;
    private String Prusahaan;

    public String getNoRegistrasi() {
        return NoRegistrasi;
    }

    public void setNoRegistrasi(String noRegistrasi) {
        NoRegistrasi = noRegistrasi;
    }

    public String getRencana() {
        return Rencana;
    }

    public void setRencana(String rencana) {
        Rencana = rencana;
    }

    public String getPrusahaan() {
        return Prusahaan;
    }

    public void setPrusahaan(String prusahaan) {
        Prusahaan = prusahaan;
    }
}
