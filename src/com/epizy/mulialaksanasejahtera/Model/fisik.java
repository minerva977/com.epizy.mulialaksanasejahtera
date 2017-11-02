package com.epizy.mulialaksanasejahtera.Model;

public class fisik {
    private dataDiri dataDiri = new dataDiri();
    private String NoRegistrasi = dataDiri.getNoRegistrasi();
    private String Merokok;
    private String KeteranganMerokok;
    private String Alkohol;
    private String KeteranganAlkohol;
    private String Tato;
    private String KeteranganTato;
    private String ButaWarna;
    private String KeteranganButaWarna;
    private String Rabun;
    private String keteranganRabun;
    private String Alergi;
    private String KeteranganAlergi;

    public String getNoRegistrasi() {
        return NoRegistrasi;
    }

    public void setNoRegistrasi(String noRegistrasi) {
        NoRegistrasi = noRegistrasi;
    }

    public String getMerokok() {
        return Merokok;
    }

    public void setMerokok(String merokok) {
        Merokok = merokok;
    }

    public String getKeteranganMerokok() {
        return KeteranganMerokok;
    }

    public void setKeteranganMerokok(String keteranganMerokok) {
        KeteranganMerokok = keteranganMerokok;
    }

    public String getAlkohol() {
        return Alkohol;
    }

    public void setAlkohol(String alkohol) {
        Alkohol = alkohol;
    }

    public String getKeteranganAlkohol() {
        return KeteranganAlkohol;
    }

    public void setKeteranganAlkohol(String keteranganAlkohol) {
        KeteranganAlkohol = keteranganAlkohol;
    }

    public String getTato() {
        return Tato;
    }

    public void setTato(String tato) {
        Tato = tato;
    }

    public String getKeteranganTato() {
        return KeteranganTato;
    }

    public void setKeteranganTato(String keteranganTato) {
        KeteranganTato = keteranganTato;
    }

    public String getButaWarna() {
        return ButaWarna;
    }

    public void setButaWarna(String butaWarna) {
        ButaWarna = butaWarna;
    }

    public String getKeteranganButaWarna() {
        return KeteranganButaWarna;
    }

    public void setKeteranganButaWarna(String keteranganButaWarna) {
        KeteranganButaWarna = keteranganButaWarna;
    }

    public String getRabun() {
        return Rabun;
    }

    public void setRabun(String rabun) {
        Rabun = rabun;
    }

    public String getKeteranganRabun() {
        return keteranganRabun;
    }

    public void setKeteranganRabun(String keteranganRabun) {
        this.keteranganRabun = keteranganRabun;
    }

    public String getAlergi() {
        return Alergi;
    }

    public void setAlergi(String alergi) {
        Alergi = alergi;
    }

    public String getKeteranganAlergi() {
        return KeteranganAlergi;
    }

    public void setKeteranganAlergi(String keteranganAlergi) {
        KeteranganAlergi = keteranganAlergi;
    }
}
