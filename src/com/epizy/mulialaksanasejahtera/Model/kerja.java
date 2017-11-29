package com.epizy.mulialaksanasejahtera.Model;

public class kerja {
    private final dataDiri dataDiri = new dataDiri();
    private String NoRegistrasi = dataDiri.getNoRegistrasi();
    private String Tujuan;
    private String Keterampilan;

    public String getNoRegistrasi() {
        return NoRegistrasi;
    }

    public void setNoRegistrasi(String noRegistrasi) {
        NoRegistrasi = noRegistrasi;
    }

    public String getTujuan() {
        return Tujuan;
    }

    public void setTujuan(String tujuan) {
        Tujuan = tujuan;
    }

    public String getKeterampilan() {
        return Keterampilan;
    }

    public void setKeterampilan(String keterampilan) {
        Keterampilan = keterampilan;
    }

}
