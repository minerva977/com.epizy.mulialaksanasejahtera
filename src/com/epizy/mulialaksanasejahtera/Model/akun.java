package com.epizy.mulialaksanasejahtera.Model;

// --Commented out by Inspection START (25/11/2017 12.44.33 PM):
public class akun {
    private final dataDiri dataDiri = new dataDiri();
    private String NoRegistrasi = dataDiri.getNoRegistrasi();
    private String Username;
    private String Password;

    public String getNoRegistrasi() {
        return NoRegistrasi;
    }

    public void setNoRegistrasi(String noRegistrasi) {
        NoRegistrasi = noRegistrasi;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
// --Commented out by Inspection STOP (25/11/2017 12.44.33 PM)
