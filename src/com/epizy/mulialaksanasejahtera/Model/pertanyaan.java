package com.epizy.mulialaksanasejahtera.Model;

public class pertanyaan {
    private dataDiri dataDiri = new dataDiri();
    private String NoRegistrasi = dataDiri.getNoRegistrasi();
    private String Pernyataan;
    private String Persetujuan;

    public String getNoRegistrasi() {
        return NoRegistrasi;
    }

    public void setNoRegistrasi(String noRegistrasi) {
        NoRegistrasi = noRegistrasi;
    }

    public String getPernyataan() {
        return Pernyataan;
    }

    public void setPernyataan(String Pernyataan) {
        this.Pernyataan = Pernyataan;
    }

    public String getPersetujuan() {
        return Persetujuan;
    }

    public void setPersetujuan(String persetujuan) {
        Persetujuan = persetujuan;
    }
}
