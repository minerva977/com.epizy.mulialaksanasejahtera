package com.epizy.mulialaksanasejahtera.Model;

public class kemampuanBahasa {
    private final dataDiri dataDiri = new dataDiri();
    private String NoRegistrasi = dataDiri.getNoRegistrasi();
    private String Inggris;
    private String Mandarin;
    private String Hokian;
    private String Hokka;
    private String Lain;

    public String getNoRegistrasi() {
        return NoRegistrasi;
    }

    public void setNoRegistrasi(String noRegistrasi) {
        NoRegistrasi = noRegistrasi;
    }

    public String getInggris() {
        return Inggris;
    }

    public void setInggris(String inggris) {
        Inggris = inggris;
    }

    public String getMandarin() {
        return Mandarin;
    }

    public void setMandarin(String mandarin) {
        Mandarin = mandarin;
    }

    public String getHokian() {
        return Hokian;
    }

    public void setHokian(String hokian) {
        Hokian = hokian;
    }

    public String getHokka() {
        return Hokka;
    }

    public void setHokka(String hokka) {
        Hokka = hokka;
    }

    public String getLain() {
        return Lain;
    }

    public void setLain(String lain) {
        Lain = lain;
    }
}
