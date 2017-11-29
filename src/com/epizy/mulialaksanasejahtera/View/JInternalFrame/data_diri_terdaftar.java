/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epizy.mulialaksanasejahtera.View.JInternalFrame;

import com.epizy.mulialaksanasejahtera.Controller.controllerConfig;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;
import mv.lib.ProsesDB.GetDataFromDB;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Wisnu_Putra_Dewa
 */
public class data_diri_terdaftar extends javax.swing.JInternalFrame {

    /**
     * Creates new form data_diri_baru
     */
    GetDataFromDB gdfdb=new GetDataFromDB();
    final controllerConfig config = new controllerConfig();
    public final String parameter=homeTerdaftar.par;
    public data_diri_terdaftar() {
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        initComponents();
        grabDataDiriSelesai(parameter);
        bahasa(parameter);
        keluarga(parameter);
        hubunganAhliWaris(parameter);
        fisik(parameter);
        kerja(parameter);
        pernyataan(parameter);
    }
    
    private void grabDataDiriSelesai(String par){
        String sql = "SELECT * FROM `data_pribadi_selesai` WHERE `no_reg` = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dataBaseConncetionFactory.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,par);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                kelamin.setText(resultSet.getString(3));
                gaji.setText("Gaji : Rp."+resultSet.getString(4));
                no_ktp.setText(resultSet.getString(5));
                tempat_ktp.setText(resultSet.getString(6));
                tgl_ktp.setText(resultSet.getString(7));
                nama.setText("Data Diri Dari : "+resultSet.getString(8));
                usia.setText(resultSet.getString(9));
                alamat.setText(resultSet.getString(10));
                desa_kel.setText(resultSet.getString(11));
                kecamatan.setText(resultSet.getString(12));
                kab_kota.setText(resultSet.getString(13));
                propinsi.setText(resultSet.getString(14));
                tempat_lahir.setText(resultSet.getString(15));
                tgl_lahir.setText(resultSet.getString(16));
                no_tlp.setText(resultSet.getString(17));
                no_hp.setText(resultSet.getString(18));
                tinggi.setText(resultSet.getString(19));
                berat.setText(resultSet.getString(20));
                setatus.setText(resultSet.getString(21));
                tgl_setatus.setText(resultSet.getString(22));
                pendidikan.setText(resultSet.getString(23));
                agama.setText(resultSet.getString(24));
                jPanel2.setMaximumSize(new Dimension(1000,200));
                jPanel2.setMinimumSize(new Dimension(1000,200));
                config.getIamge(resultSet.getString(25), gambar);
                email.setText(resultSet.getString(26));
                ket.setText(resultSet.getString(27));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (dataBaseConncetionFactory.getConnection() != null) {
                try {
                    assert preparedStatement != null;
                    preparedStatement.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void bahasa (String par) {
        String sql = "SELECT * FROM `kemampuan_bahasa` WHERE `no_reg` = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dataBaseConncetionFactory.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, par);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                inggris.setText(resultSet.getString(2));
                mandarin.setText(resultSet.getString(3));
                hokian.setText(resultSet.getString(4));
                hakkan.setText(resultSet.getString(5));
                lain.setText(resultSet.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(dataBaseConncetionFactory.getConnection() != null) {
                try {
                    assert preparedStatement != null;
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void keluarga (String par) {
        String sql = "SELECT * FROM `informasi_keluarga` WHERE `no_reg` = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dataBaseConncetionFactory.getConnection().prepareCall(sql);
            preparedStatement.setString(1, par);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                nBapak.setText(resultSet.getString(2));
                pBapak.setText(resultSet.getString(3));
                tmpBapak.setText(resultSet.getString(4));
                tglBapak.setText(resultSet.getString(5));
                nIbu.setText(resultSet.getString(6));
                pIbu.setText(resultSet.getString(7));
                tmpIbu.setText(resultSet.getString(8));
                tglIbu.setText(resultSet.getString(9));
                nSumIs.setText(resultSet.getString(10));
                pSumIs.setText(resultSet.getString(11));
                jumAnak.setText(resultSet.getString(12));
                umurAnak.setText(resultSet.getString(13));
                jumLaki.setText(resultSet.getString(14));
                jumPere.setText(resultSet.getString(15));
                anakKe.setText(resultSet.getString(16));
            }
        } catch (SQLException ignored) {
        }
        finally {
            if(dataBaseConncetionFactory.getConnection() != null) {
                try {
                    assert preparedStatement != null;
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void hubunganAhliWaris (String par) {
        String sql = "SELECT * FROM `ahli_waris` WHERE `no_reg` = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dataBaseConncetionFactory.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, par);
            ResultSet resultSet= preparedStatement.executeQuery();
            if (resultSet.next()) {
                nAhliWaris.setText(resultSet.getString(2));
                hAhliWaris.setText(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(dataBaseConncetionFactory.getConnection() != null) {
                try {
                    assert preparedStatement != null;
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void fisik (String par) {
        String sql = "SELECT * FROM `fisik` WHERE `no_reg` = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dataBaseConncetionFactory.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, par);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                merokok.setText(resultSet.getString(2));
                ketMerokok.setText(resultSet.getString(3));
                alkohol.setText(resultSet.getString(4));
                ketAlkohol.setText(resultSet.getString(5));
                tatto.setText(resultSet.getString(6));
                ketTatto.setText(resultSet.getString(7));
                buta.setText(resultSet.getString(8));
                ketButa.setText(resultSet.getString(9));
                rabun.setText(resultSet.getString(10));
                ketRabun.setText(resultSet.getString(11));
                alergi.setText(resultSet.getString(12));
                ketAlergi.setText(resultSet.getString(13));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(dataBaseConncetionFactory.getConnection() != null) {
                try {
                    assert preparedStatement != null;
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void kerja (String par) {
        String sql = "SELECT * FROM `kerja` WHERE `no_reg` = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = dataBaseConncetionFactory.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, par);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                negaraTujuan.setText(resultSet.getString(2));
                keterampilan.setText(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void pernyataan (String par) {
        String sql = "SELECT * FROM `pertanyaan` WHERE `no_reg` = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = dataBaseConncetionFactory.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, par);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pernyataan.setText(
                        "SAYA "+resultSet.getString(3)+" BILA MENDAPATKAN"
                                + "JOB DI PELABUAN LOGAM"
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JPanel jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        kelamin = new javax.swing.JLabel();
        alamat = new javax.swing.JLabel();
        kab_kota = new javax.swing.JLabel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        tgl_ktp = new javax.swing.JLabel();
        desa_kel = new javax.swing.JLabel();
        kecamatan = new javax.swing.JLabel();
        javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel14 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel15 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel16 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel17 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel18 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        no_ktp = new javax.swing.JLabel();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        tempat_ktp = new javax.swing.JLabel();
        propinsi = new javax.swing.JLabel();
        javax.swing.JLabel jLabel19 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel20 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel21 = new javax.swing.JLabel();
        tgl_lahir = new javax.swing.JLabel();
        no_tlp = new javax.swing.JLabel();
        no_hp = new javax.swing.JLabel();
        tinggi = new javax.swing.JLabel();
        berat = new javax.swing.JLabel();
        setatus = new javax.swing.JLabel();
        tgl_setatus = new javax.swing.JLabel();
        pendidikan = new javax.swing.JLabel();
        agama = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator2 = new javax.swing.JSeparator();
        nama = new javax.swing.JLabel();
        usia = new javax.swing.JLabel();
        javax.swing.JLabel jLabel22 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel23 = new javax.swing.JLabel();
        tempat_lahir = new javax.swing.JLabel();
        gaji = new javax.swing.JLabel();
        gambar = new javax.swing.JLabel();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        ket = new javax.swing.JLabel();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel24 = new javax.swing.JLabel();
        inggris = new javax.swing.JLabel();
        javax.swing.JLabel jLabel26 = new javax.swing.JLabel();
        mandarin = new javax.swing.JLabel();
        javax.swing.JLabel jLabel28 = new javax.swing.JLabel();
        hakkan = new javax.swing.JLabel();
        javax.swing.JLabel jLabel30 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel31 = new javax.swing.JLabel();
        lain = new javax.swing.JLabel();
        hokian = new javax.swing.JLabel();
        javax.swing.JPanel jPanel6 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel34 = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator4 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel35 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel36 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel37 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel38 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel39 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel40 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel41 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel42 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel43 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel44 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel45 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel46 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel47 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel48 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel49 = new javax.swing.JLabel();
        nBapak = new javax.swing.JLabel();
        pBapak = new javax.swing.JLabel();
        tmpBapak = new javax.swing.JLabel();
        tglBapak = new javax.swing.JLabel();
        tglIbu = new javax.swing.JLabel();
        tmpIbu = new javax.swing.JLabel();
        pIbu = new javax.swing.JLabel();
        nIbu = new javax.swing.JLabel();
        pSumIs = new javax.swing.JLabel();
        nSumIs = new javax.swing.JLabel();
        jumAnak = new javax.swing.JLabel();
        umurAnak = new javax.swing.JLabel();
        jumLaki = new javax.swing.JLabel();
        jumPere = new javax.swing.JLabel();
        anakKe = new javax.swing.JLabel();
        javax.swing.JPanel jPanel5 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel50 = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator3 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel25 = new javax.swing.JLabel();
        nAhliWaris = new javax.swing.JLabel();
        javax.swing.JLabel jLabel27 = new javax.swing.JLabel();
        hAhliWaris = new javax.swing.JLabel();
        javax.swing.JPanel jPanel7 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel29 = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator5 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel32 = new javax.swing.JLabel();
        merokok = new javax.swing.JLabel();
        ketMerokok = new javax.swing.JLabel();
        javax.swing.JLabel jLabel52 = new javax.swing.JLabel();
        alkohol = new javax.swing.JLabel();
        ketAlkohol = new javax.swing.JLabel();
        javax.swing.JLabel jLabel55 = new javax.swing.JLabel();
        tatto = new javax.swing.JLabel();
        ketTatto = new javax.swing.JLabel();
        javax.swing.JLabel jLabel58 = new javax.swing.JLabel();
        buta = new javax.swing.JLabel();
        ketButa = new javax.swing.JLabel();
        javax.swing.JLabel jLabel61 = new javax.swing.JLabel();
        rabun = new javax.swing.JLabel();
        ketRabun = new javax.swing.JLabel();
        javax.swing.JLabel jLabel64 = new javax.swing.JLabel();
        alergi = new javax.swing.JLabel();
        ketAlergi = new javax.swing.JLabel();
        javax.swing.JPanel jPanel8 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel33 = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator6 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel51 = new javax.swing.JLabel();
        negaraTujuan = new javax.swing.JLabel();
        javax.swing.JLabel jLabel53 = new javax.swing.JLabel();
        keterampilan = new javax.swing.JLabel();
        javax.swing.JPanel jPanel9 = new javax.swing.JPanel();
        pernyataan = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(null);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setForeground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));

        jLabel3.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Kelamin :");

        jLabel5.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Alamat :");

        jLabel7.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Propinsi :");

        kelamin.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        kelamin.setForeground(new java.awt.Color(0, 0, 0));
        kelamin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        kelamin.setText("isi data");

        alamat.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        alamat.setForeground(new java.awt.Color(0, 0, 0));
        alamat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        alamat.setText("isi data");

        kab_kota.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        kab_kota.setForeground(new java.awt.Color(0, 0, 0));
        kab_kota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        kab_kota.setText("isi data");

        jLabel8.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Kabupaten/Kota :");

        jLabel10.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Tanggal KTP Dibuat :");

        jLabel6.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Desa/Kelurahan :");

        jLabel11.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Kecamatan :");

        tgl_ktp.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        tgl_ktp.setForeground(new java.awt.Color(0, 0, 0));
        tgl_ktp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tgl_ktp.setText("isi data");

        desa_kel.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        desa_kel.setForeground(new java.awt.Color(0, 0, 0));
        desa_kel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        desa_kel.setText("isi data");

        kecamatan.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        kecamatan.setForeground(new java.awt.Color(0, 0, 0));
        kecamatan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        kecamatan.setText("isi data");

        jLabel13.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Tanggal Lahir :");

        jLabel14.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("No. Telepon :");

        jLabel15.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("No. HP/Flexy :");

        jLabel16.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Tinggi Badan :");

        jLabel17.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Berat Badan :");

        jLabel18.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Setatus :");

        jLabel4.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("No KTP :");

        no_ktp.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        no_ktp.setForeground(new java.awt.Color(0, 0, 0));
        no_ktp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        no_ktp.setText("isi data");

        jLabel9.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Tempat KTP Dibuat :");

        tempat_ktp.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        tempat_ktp.setForeground(new java.awt.Color(0, 0, 0));
        tempat_ktp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tempat_ktp.setText("isi data");

        propinsi.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        propinsi.setForeground(new java.awt.Color(0, 0, 0));
        propinsi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        propinsi.setText("isi data");

        jLabel19.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Tanggal Setatus :");

        jLabel20.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Pendidikan Teraakhir :");

        jLabel21.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Agama :");

        tgl_lahir.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        tgl_lahir.setForeground(new java.awt.Color(0, 0, 0));
        tgl_lahir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tgl_lahir.setText("isi data");

        no_tlp.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        no_tlp.setForeground(new java.awt.Color(0, 0, 0));
        no_tlp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        no_tlp.setText("isi data");

        no_hp.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        no_hp.setForeground(new java.awt.Color(0, 0, 0));
        no_hp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        no_hp.setText("isi data");

        tinggi.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        tinggi.setForeground(new java.awt.Color(0, 0, 0));
        tinggi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tinggi.setText("isi data");

        berat.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        berat.setForeground(new java.awt.Color(0, 0, 0));
        berat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        berat.setText("isi data");

        setatus.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        setatus.setForeground(new java.awt.Color(0, 0, 0));
        setatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        setatus.setText("isi data");

        tgl_setatus.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        tgl_setatus.setForeground(new java.awt.Color(0, 0, 0));
        tgl_setatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tgl_setatus.setText("isi data");

        pendidikan.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        pendidikan.setForeground(new java.awt.Color(0, 0, 0));
        pendidikan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pendidikan.setText("isi data");

        agama.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        agama.setForeground(new java.awt.Color(0, 0, 0));
        agama.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        agama.setText("isi data");

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        nama.setFont(new java.awt.Font("Dialog", Font.BOLD, 18)); // NOI18N
        nama.setForeground(new java.awt.Color(0, 0, 0));
        nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nama.setText("Data Diri");

        usia.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        usia.setForeground(new java.awt.Color(0, 0, 0));
        usia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        usia.setText("isi data");

        jLabel22.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Usia :");

        jLabel23.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Tempat Lahir :");

        tempat_lahir.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        tempat_lahir.setForeground(new java.awt.Color(0, 0, 0));
        tempat_lahir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tempat_lahir.setText("isi data");

        gaji.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        gaji.setForeground(new java.awt.Color(0, 0, 0));
        gaji.setText("Tempat Lahir :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(tempat_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(tgl_ktp, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(66, 66, 66)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kelamin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(no_ktp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(tempat_ktp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(kab_kota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(propinsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(alamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(desa_kel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(kecamatan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(no_tlp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(no_hp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tinggi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(berat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tgl_setatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pendidikan, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(agama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(setatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(usia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(tgl_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(gaji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(kelamin)
                    .addComponent(jLabel13)
                    .addComponent(tgl_lahir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(usia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(no_ktp)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tempat_ktp)
                    .addComponent(jLabel14)
                    .addComponent(no_tlp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tgl_ktp)
                    .addComponent(jLabel15)
                    .addComponent(no_hp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(tinggi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desa_kel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(berat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(setatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kab_kota, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(tgl_setatus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(propinsi, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(pendidikan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(tempat_lahir)
                    .addComponent(jLabel21)
                    .addComponent(agama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gaji)
                .addContainerGap())
        );

        gambar.setBackground(new java.awt.Color(102, 255, 102));
        gambar.setForeground(new java.awt.Color(0, 0, 0));
        gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gambar.setText("Gambar");
        gambar.setToolTipText("");
        gambar.setPreferredSize(new java.awt.Dimension(200, 200));

        jPanel3.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Pernah mengikuti Pendidikan Non Formal/ Sertifikat Ketrampilan /kursus :");

        ket.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        ket.setForeground(new java.awt.Color(0, 0, 0));
        ket.setText("jLabel2");

        jLabel12.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Email :");

        email.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        email.setForeground(new java.awt.Color(0, 0, 0));
        email.setText("jLabel65");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(462, 462, 462)))
                        .addGap(217, 217, 217))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ket)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel2.setFont(new java.awt.Font("Dialog", Font.BOLD, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Kealihan Bahasa");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel24.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Bahasa Inggirs :");

        inggris.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        inggris.setForeground(new java.awt.Color(0, 0, 0));
        inggris.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        inggris.setText("isi data");

        jLabel26.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Bahasa Mandarin :");

        mandarin.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        mandarin.setForeground(new java.awt.Color(0, 0, 0));
        mandarin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mandarin.setText("isi data");

        jLabel28.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Bahasa Hakka :");

        hakkan.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        hakkan.setForeground(new java.awt.Color(0, 0, 0));
        hakkan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hakkan.setText("isi data");

        jLabel30.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Bahasa Hokian :");

        jLabel31.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Bahasa Lain :");

        lain.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        lain.setForeground(new java.awt.Color(0, 0, 0));
        lain.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lain.setText("isi data");

        hokian.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        hokian.setForeground(new java.awt.Color(0, 0, 0));
        hokian.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hokian.setText("isi data");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(mandarin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(hokian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(inggris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(hakkan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lain))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(inggris))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(mandarin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(hokian)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(hakkan))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(102, 255, 102));

        jLabel34.setFont(new java.awt.Font("Dialog", Font.BOLD, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Infromasi Keluarga");

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));

        jLabel35.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Nama Bapak :");

        jLabel36.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Pekerjaan :");

        jLabel37.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Tempat Lahir :");

        jLabel38.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Tanggal Lahir :");

        jLabel39.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Nama Bapak :");

        jLabel40.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Pekerjaan :");

        jLabel41.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Tempat Lahir :");

        jLabel42.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Tanggal Lahir :");

        jLabel43.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Nama Suami/Istri :");

        jLabel44.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Pekerjaan :");

        jLabel45.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Jumlah Anak :");

        jLabel46.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Umur Masing-Masing :");

        jLabel47.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("Jumlah Saudara Laki-Laki :");

        jLabel48.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("Jumlah Saudara Perempuan :");

        jLabel49.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setText("Saya Anak Ke :");

        nBapak.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        nBapak.setForeground(new java.awt.Color(0, 0, 0));
        nBapak.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nBapak.setText("isi data");

        pBapak.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        pBapak.setForeground(new java.awt.Color(0, 0, 0));
        pBapak.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pBapak.setText("isi data");

        tmpBapak.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        tmpBapak.setForeground(new java.awt.Color(0, 0, 0));
        tmpBapak.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tmpBapak.setText("isi data");

        tglBapak.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        tglBapak.setForeground(new java.awt.Color(0, 0, 0));
        tglBapak.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tglBapak.setText("isi data");

        tglIbu.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        tglIbu.setForeground(new java.awt.Color(0, 0, 0));
        tglIbu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tglIbu.setText("isi data");

        tmpIbu.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        tmpIbu.setForeground(new java.awt.Color(0, 0, 0));
        tmpIbu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tmpIbu.setText("isi data");

        pIbu.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        pIbu.setForeground(new java.awt.Color(0, 0, 0));
        pIbu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pIbu.setText("isi data");

        nIbu.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        nIbu.setForeground(new java.awt.Color(0, 0, 0));
        nIbu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nIbu.setText("isi data");

        pSumIs.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        pSumIs.setForeground(new java.awt.Color(0, 0, 0));
        pSumIs.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pSumIs.setText("isi data");

        nSumIs.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        nSumIs.setForeground(new java.awt.Color(0, 0, 0));
        nSumIs.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nSumIs.setText("isi data");

        jumAnak.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jumAnak.setForeground(new java.awt.Color(0, 0, 0));
        jumAnak.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jumAnak.setText("isi data");

        umurAnak.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        umurAnak.setForeground(new java.awt.Color(0, 0, 0));
        umurAnak.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        umurAnak.setText("isi data");

        jumLaki.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jumLaki.setForeground(new java.awt.Color(0, 0, 0));
        jumLaki.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jumLaki.setText("isi data");

        jumPere.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jumPere.setForeground(new java.awt.Color(0, 0, 0));
        jumPere.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jumPere.setText("isi data");

        anakKe.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        anakKe.setForeground(new java.awt.Color(0, 0, 0));
        anakKe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        anakKe.setText("isi data");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(226, 226, 226)
                        .addComponent(pSumIs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(95, 95, 95)
                                .addComponent(nBapak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(66, 66, 66)
                                .addComponent(pBapak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(116, 116, 116)
                                .addComponent(tmpBapak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(99, 99, 99)
                                .addComponent(tglBapak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(190, 190, 190)
                                .addComponent(nSumIs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(211, 211, 211)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(umurAnak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jumAnak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3))
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(44, 44, 44)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jumLaki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jumPere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(anakKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(9, 9, 9))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4))
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pIbu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nIbu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tmpIbu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tglIbu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator4))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addGap(669, 669, 669)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel34)
                .addGap(6, 6, 6)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(nBapak)
                    .addComponent(jLabel39)
                    .addComponent(nIbu))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(pBapak)
                    .addComponent(jLabel40)
                    .addComponent(pIbu))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(tmpBapak)
                    .addComponent(jLabel41)
                    .addComponent(tmpIbu))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(tglBapak)
                    .addComponent(jLabel42)
                    .addComponent(tglIbu))
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(nSumIs)
                    .addComponent(jLabel47)
                    .addComponent(jumLaki))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(pSumIs)
                    .addComponent(jLabel48)
                    .addComponent(jumPere))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jumAnak)
                    .addComponent(jLabel49)
                    .addComponent(anakKe))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(umurAnak))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 255, 102));

        jLabel50.setFont(new java.awt.Font("Dialog", Font.BOLD, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Ahli Waris");

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));

        jLabel25.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Nama Ahli Waris :");

        nAhliWaris.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        nAhliWaris.setForeground(new java.awt.Color(0, 0, 0));
        nAhliWaris.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nAhliWaris.setText("isiData");

        jLabel27.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Hubungan Ahli Waris :");

        hAhliWaris.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        hAhliWaris.setForeground(new java.awt.Color(0, 0, 0));
        hAhliWaris.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hAhliWaris.setText("Hubungan Ahli Waris :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nAhliWaris, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(hAhliWaris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(nAhliWaris)
                    .addComponent(jLabel27)
                    .addComponent(hAhliWaris))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(102, 255, 102));

        jLabel29.setFont(new java.awt.Font("Dialog", Font.BOLD, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Keterangan Fisik");

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(153, 153, 153));

        jLabel32.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Merokok");

        merokok.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        merokok.setForeground(new java.awt.Color(0, 0, 0));
        merokok.setText("isiData");

        ketMerokok.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        ketMerokok.setForeground(new java.awt.Color(0, 0, 0));
        ketMerokok.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ketMerokok.setText("isiDataKeterangan");

        jLabel52.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("Alkohol");

        alkohol.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        alkohol.setForeground(new java.awt.Color(0, 0, 0));
        alkohol.setText("isiData");

        ketAlkohol.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        ketAlkohol.setForeground(new java.awt.Color(0, 0, 0));
        ketAlkohol.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ketAlkohol.setText("isiDataKeterangan");

        jLabel55.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setText("Bertatto");

        tatto.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        tatto.setForeground(new java.awt.Color(0, 0, 0));
        tatto.setText("isiData");

        ketTatto.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        ketTatto.setForeground(new java.awt.Color(0, 0, 0));
        ketTatto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ketTatto.setText("isiDataKeterangan");

        jLabel58.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setText("Buta Warna");

        buta.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        buta.setForeground(new java.awt.Color(0, 0, 0));
        buta.setText("isiData");

        ketButa.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        ketButa.setForeground(new java.awt.Color(0, 0, 0));
        ketButa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ketButa.setText("isiDataKeterangan");

        jLabel61.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("Rabun");

        rabun.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        rabun.setForeground(new java.awt.Color(0, 0, 0));
        rabun.setText("isiData");

        ketRabun.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        ketRabun.setForeground(new java.awt.Color(0, 0, 0));
        ketRabun.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ketRabun.setText("isiDataKeterangan");

        jLabel64.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 0, 0));
        jLabel64.setText("Alergi");

        alergi.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        alergi.setForeground(new java.awt.Color(0, 0, 0));
        alergi.setText("isiData");

        ketAlergi.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        ketAlergi.setForeground(new java.awt.Color(0, 0, 0));
        ketAlergi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ketAlergi.setText("isiDataKeterangan");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(merokok))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel52)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(alkohol))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel55)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                    .addComponent(tatto))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ketAlkohol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ketTatto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ketMerokok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addGap(18, 18, 18)
                                .addComponent(buta))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rabun))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(alergi)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ketAlergi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ketRabun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ketButa, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(merokok)
                    .addComponent(ketMerokok))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(alkohol)
                    .addComponent(ketAlkohol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(tatto)
                    .addComponent(ketTatto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(buta)
                    .addComponent(ketButa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(rabun)
                    .addComponent(ketRabun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(alergi)
                    .addComponent(ketAlergi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(102, 255, 102));

        jLabel33.setFont(new java.awt.Font("Dialog", Font.BOLD, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Tujuan Kerja");

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));

        jLabel51.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("Negara Tujuan");

        negaraTujuan.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        negaraTujuan.setForeground(new java.awt.Color(0, 0, 0));
        negaraTujuan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        negaraTujuan.setText("isiData");

        jLabel53.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setText("Keterampilan");

        keterampilan.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        keterampilan.setForeground(new java.awt.Color(0, 0, 0));
        keterampilan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        keterampilan.setText("Keterampilan");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keterampilan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator6)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel53))
                        .addGap(18, 18, 18)
                        .addComponent(negaraTujuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(negaraTujuan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keterampilan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(102, 255, 102));

        pernyataan.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        pernyataan.setForeground(new java.awt.Color(0, 0, 0));
        pernyataan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pernyataan.setText("Keterampilan");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pernyataan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pernyataan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1152, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agama;
    private javax.swing.JLabel alamat;
    private javax.swing.JLabel alergi;
    private javax.swing.JLabel alkohol;
    private javax.swing.JLabel anakKe;
    private javax.swing.JLabel berat;
    private javax.swing.JLabel buta;
    private javax.swing.JLabel desa_kel;
    private javax.swing.JLabel email;
    private javax.swing.JLabel gaji;
    private javax.swing.JLabel gambar;
    private javax.swing.JLabel hAhliWaris;
    private javax.swing.JLabel hakkan;
    private javax.swing.JLabel hokian;
    private javax.swing.JLabel inggris;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jumAnak;
    private javax.swing.JLabel jumLaki;
    private javax.swing.JLabel jumPere;
    private javax.swing.JLabel kab_kota;
    private javax.swing.JLabel kecamatan;
    private javax.swing.JLabel kelamin;
    private javax.swing.JLabel ket;
    private javax.swing.JLabel ketAlergi;
    private javax.swing.JLabel ketAlkohol;
    private javax.swing.JLabel ketButa;
    private javax.swing.JLabel ketMerokok;
    private javax.swing.JLabel ketRabun;
    private javax.swing.JLabel ketTatto;
    private javax.swing.JLabel keterampilan;
    private javax.swing.JLabel lain;
    private javax.swing.JLabel mandarin;
    private javax.swing.JLabel merokok;
    private javax.swing.JLabel nAhliWaris;
    private javax.swing.JLabel nBapak;
    private javax.swing.JLabel nIbu;
    private javax.swing.JLabel nSumIs;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel negaraTujuan;
    private javax.swing.JLabel no_hp;
    private javax.swing.JLabel no_ktp;
    private javax.swing.JLabel no_tlp;
    private javax.swing.JLabel pBapak;
    private javax.swing.JLabel pIbu;
    private javax.swing.JLabel pSumIs;
    private javax.swing.JLabel pendidikan;
    private javax.swing.JLabel pernyataan;
    private javax.swing.JLabel propinsi;
    private javax.swing.JLabel rabun;
    private javax.swing.JLabel setatus;
    private javax.swing.JLabel tatto;
    private javax.swing.JLabel tempat_ktp;
    private javax.swing.JLabel tempat_lahir;
    private javax.swing.JLabel tglBapak;
    private javax.swing.JLabel tglIbu;
    private javax.swing.JLabel tgl_ktp;
    private javax.swing.JLabel tgl_lahir;
    private javax.swing.JLabel tgl_setatus;
    private javax.swing.JLabel tinggi;
    private javax.swing.JLabel tmpBapak;
    private javax.swing.JLabel tmpIbu;
    private javax.swing.JLabel umurAnak;
    private javax.swing.JLabel usia;
    // End of variables declaration//GEN-END:variables
}
