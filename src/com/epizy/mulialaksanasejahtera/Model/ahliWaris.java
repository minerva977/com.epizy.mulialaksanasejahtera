package com.epizy.mulialaksanasejahtera.Model;

public class ahliWaris {
    private final dataDiri dataDiri = new dataDiri();
    private String NoRegistrasi = dataDiri.getNoRegistrasi();
    private String Nama;
    private String Hubungan;

    public String getNoRegistrasi() {
        return NoRegistrasi;
    }

    public void setNoRegistrasi(String noRegistrasi) {
        NoRegistrasi = noRegistrasi;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getHubungan() {
        return Hubungan;
    }

    public void setHubungan(String hubungan) {
        Hubungan = hubungan;
    }
}
