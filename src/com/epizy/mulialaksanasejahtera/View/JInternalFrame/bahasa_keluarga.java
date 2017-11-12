/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epizy.mulialaksanasejahtera.View.JInternalFrame;

import com.epizy.mulialaksanasejahtera.Controller.controllerAhliWaris;
import com.epizy.mulialaksanasejahtera.Controller.controllerInformasiKeluarga;
import com.epizy.mulialaksanasejahtera.Controller.controllerKemampuanBahasa;
import mv.lib.BuildDB.CodeDataBase;
import mv.lib.ProsesDB.GetDataFromDB;
import mv.lib.ProsesDB.InputToDB;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nier
 */
public class bahasa_keluarga extends javax.swing.JInternalFrame {

    /**
     * Creates new form intervew
     */
    InputToDB itdb=new InputToDB();
    GetDataFromDB gdfdb=new GetDataFromDB();
    public String par=interview.parameter;
    public bahasa_keluarga() {
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        initComponents();
        clr();
        jLabel1.setText("Kealihan Bahasa Dan Informasi Keluarga Dengan Nomer Registrasi : "+par);
    }
    void clr(){
        bahasa_lain.setText("Tidak ADA");
        nama_ayah.setText("");
        kerja_ayah.setText("");
        lahir_ayah.setText("");
        tgl_ayah.setDate(new Date());
        nama_ibu.setText("");
        kerja_ibu.setText("");
        lahir_ibu.setText("");
        tgl_ibu.setDate(new Date());
        nama_sum_is.setText("");
        kerja_sum_is.setText("");
        jum_anak.setText("");
        umur_anak.setText("");
        so_laki.setText("");
        so_cewek.setText("");
        anak_ke.setText("");
        ahli_war.setText("");
        hub_ahli_war.setText("");
        CodeDataBase cdb = new CodeDataBase();
        String sql="SELECT "
                + "`kemampuan_bahasa`.*, `informasi_keluarga`.*, `ahli_waris`.* "
                + "FROM "
                + "`informasi_keluarga`, `ahli_waris`, `kemampuan_bahasa` "
                + "WHERE "
                + "informasi_keluarga.no_reg = '"+par+"' AND ahli_waris.no_reg = '"+par+"' "
                + "AND kemampuan_bahasa.no_reg = '"+par+"'";
        try {
            PreparedStatement preparedStatement = cdb.Connect().prepareCall(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bahasa_lain.setText(resultSet.getString(6));
                nama_ayah.setText(resultSet.getString(8));
                kerja_ayah.setText(resultSet.getString(9));
                lahir_ayah.setText(resultSet.getString(10));
                tgl_ayah.setDate(new Date(resultSet.getString(11)));
                nama_ibu.setText(resultSet.getString(12));
                kerja_ibu.setText(resultSet.getString(13));
                lahir_ibu.setText(resultSet.getString(14));
                tgl_ibu.setDate(new Date(resultSet.getString(15)));
                nama_sum_is.setText(resultSet.getString(16));
                kerja_sum_is.setText(resultSet.getString(17));
                jum_anak.setText(resultSet.getString(18));
                umur_anak.setText(resultSet.getString(19));
                so_laki.setText(resultSet.getString(20));
                so_cewek.setText(resultSet.getString(21));
                anak_ke.setText(resultSet.getString(22));
                ahli_war.setText(resultSet.getString(24));
                hub_ahli_war.setText(resultSet.getString(25));
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(bahasa_keluarga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void cek(){
        if("".equals(bahasa_lain.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            bahasa_lain.requestFocus();
        }
        else if("".equals(nama_ayah.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf nama ayah masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            nama_ayah.requestFocus();
        }
        else if("".equals(kerja_ayah.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf pekerjaan ayah masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            kerja_ayah.requestFocus();
        }
        else if("".equals(lahir_ayah.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf tampat lahir ayah masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            lahir_ayah.requestFocus();
        }
        else if("".equals(tgl_ayah.getDateFormatString())){
            JOptionPane.showMessageDialog(
                    null, "maaf tanggal lahir ayah masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            tgl_ayah.requestFocus();
        }
        else if("".equals(nama_ibu.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            nama_ibu.requestFocus();
        }
        else if("".equals(kerja_ibu.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            kerja_ibu.requestFocus();
        }
        else if("".equals(lahir_ibu.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            lahir_ibu.requestFocus();
        }
        else if("".equals(tgl_ibu.getDateFormatString())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            tgl_ibu.requestFocus();
        }
        else if("".equals(nama_sum_is.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            nama_sum_is.requestFocus();
        }
        else if("".equals(kerja_sum_is.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            kerja_sum_is.requestFocus();
        }
        else if("".equals(jum_anak.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            jum_anak.requestFocus();
        }
        else if("".equals(umur_anak.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            umur_anak.requestFocus();
        }
        else if("".equals(so_laki.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            so_laki.requestFocus();
        }
        else if("".equals(so_cewek.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            so_cewek.requestFocus();
        }
        else if("".equals(anak_ke.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            anak_ke.requestFocus();
        }
        else if("".equals(ahli_war.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            ahli_war.requestFocus();
        }
        else if("".equals(hub_ahli_war.getText())){
            JOptionPane.showMessageDialog(
                    null, "maaf bahasa lain masih kosong mohon di isi"
                    ,"Peringatan !!!",JOptionPane.WARNING_MESSAGE);
            hub_ahli_war.requestFocus();
        }
        else{
            negara_ket_fisik negara_ket_fisik = new negara_ket_fisik();
            this.getParent().add(negara_ket_fisik);
            try {
                negara_ket_fisik.setMaximum(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            negara_ket_fisik.setVisible(true);
            input();
            this.setVisible(false);
        }
    }
    void input(){
        controllerAhliWaris controllerAhliWaris = new controllerAhliWaris(this);
        controllerInformasiKeluarga controllerInformasiKeluarga = new controllerInformasiKeluarga(this);
        controllerKemampuanBahasa controllerKemampuanBahasa = new controllerKemampuanBahasa(this);
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-yyyy");
        String b1,b2,b3,b4,tgl_bpk,tgl_ibuk;
        tgl_bpk=sdf.format(tgl_ayah.getDate());
        tgl_ibuk=sdf.format(tgl_ibu.getDate());
        b1=bhs1();
        b2=bhs2();
        b3=bhs3();
        b4=bhs4();
        controllerKemampuanBahasa.save(par, b1, b2, b3, b4, bahasa_lain.getText());
        controllerInformasiKeluarga.save(par, nama_ayah.getText(), kerja_ayah.getText(), lahir_ayah.getText()
                , tgl_bpk, nama_ibu.getText(), kerja_ibu.getText(), lahir_ibu.getText()
                , tgl_ibuk, nama_sum_is.getText(), kerja_sum_is.getText(), jum_anak.getText()
                , umur_anak.getText(), so_laki.getText(), so_cewek.getText(), anak_ke.getText());
        controllerAhliWaris.save(par, ahli_war.getText(), hub_ahli_war.getText());
    }
    String bhs1(){
        if(inggris.isSelected()){
            return "Bisa";
        }
        else if(inggris2.isSelected()){
            return "Cukup";
        }
        else{
            return "Tidak Bisa";
        }
    }
    String bhs2(){
        if(mandarin.isSelected()){
            return "Bisa";
        }
        else if(mandarin2.isSelected()){
            return "Cukup";
        }
        else{
            return "Tidak Bisa";
        }
    }
    String bhs3(){
        if(hokian.isSelected()){
            return "Bisa";
        }
        else if(hokian2.isSelected()){
            return "Cukup";
        }
        else{
            return "Tidak Bisa";
        }
    }
    String bhs4(){
        if(hakkan.isSelected()){
            return "Bisa";
        }
        else if(hakkan2.isSelected()){
            return "Cukup";
        }
        else{
            return "Tidak Bisa";
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

        bhs_inggris = new javax.swing.ButtonGroup();
        bhs_mandarin = new javax.swing.ButtonGroup();
        bhs_hokian = new javax.swing.ButtonGroup();
        bhs_hakkan = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inggris = new javax.swing.JRadioButton();
        inggris2 = new javax.swing.JRadioButton();
        inggris3 = new javax.swing.JRadioButton();
        mandarin = new javax.swing.JRadioButton();
        mandarin2 = new javax.swing.JRadioButton();
        mandarin3 = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        hokian = new javax.swing.JRadioButton();
        hokian2 = new javax.swing.JRadioButton();
        hokian3 = new javax.swing.JRadioButton();
        hakkan3 = new javax.swing.JRadioButton();
        hakkan2 = new javax.swing.JRadioButton();
        hakkan = new javax.swing.JRadioButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        bahasa_lain = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        nama_ayah = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        kerja_ayah = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lahir_ayah = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tgl_ayah = new com.toedter.calendar.JDateChooser();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nama_sum_is = new javax.swing.JTextField();
        kerja_sum_is = new javax.swing.JTextField();
        lahir_ibu = new javax.swing.JTextField();
        tgl_ibu = new com.toedter.calendar.JDateChooser();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        nama_ibu = new javax.swing.JTextField();
        kerja_ibu = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jum_anak = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        umur_anak = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        so_laki = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        so_cewek = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        anak_ke = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        ahli_war = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        hub_ahli_war = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(63, 224, 43));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kealihan Bahasa Dan Informasi Keluarga");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Kealihan Bahasa :");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Bahasa Inggris :");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Bahasa Mandarin :");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Bahasa Hokian :");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Bahasa Hakkan :");

        inggris.setBackground(new java.awt.Color(204, 204, 204));
        bhs_inggris.add(inggris);
        inggris.setForeground(new java.awt.Color(0, 0, 0));
        inggris.setSelected(true);
        inggris.setText("Bisa");
        inggris.setPreferredSize(new java.awt.Dimension(91, 28));

        inggris2.setBackground(new java.awt.Color(204, 204, 204));
        bhs_inggris.add(inggris2);
        inggris2.setForeground(new java.awt.Color(0, 0, 0));
        inggris2.setText("Cukup");
        inggris2.setPreferredSize(new java.awt.Dimension(91, 28));

        inggris3.setBackground(new java.awt.Color(204, 204, 204));
        bhs_inggris.add(inggris3);
        inggris3.setForeground(new java.awt.Color(0, 0, 0));
        inggris3.setText("Tidak Bisa");

        mandarin.setBackground(new java.awt.Color(204, 204, 204));
        bhs_mandarin.add(mandarin);
        mandarin.setForeground(new java.awt.Color(0, 0, 0));
        mandarin.setSelected(true);
        mandarin.setText("Bisa");
        mandarin.setPreferredSize(new java.awt.Dimension(91, 28));

        mandarin2.setBackground(new java.awt.Color(204, 204, 204));
        bhs_mandarin.add(mandarin2);
        mandarin2.setForeground(new java.awt.Color(0, 0, 0));
        mandarin2.setText("Cukup");
        mandarin2.setPreferredSize(new java.awt.Dimension(91, 28));

        mandarin3.setBackground(new java.awt.Color(204, 204, 204));
        bhs_mandarin.add(mandarin3);
        mandarin3.setForeground(new java.awt.Color(0, 0, 0));
        mandarin3.setText("Tidak Bisa");

        jSeparator2.setBackground(new java.awt.Color(153, 255, 153));
        jSeparator2.setForeground(new java.awt.Color(63, 224, 43));

        jSeparator3.setBackground(new java.awt.Color(153, 255, 153));
        jSeparator3.setForeground(new java.awt.Color(63, 224, 43));

        hokian.setBackground(new java.awt.Color(204, 204, 204));
        bhs_hokian.add(hokian);
        hokian.setForeground(new java.awt.Color(0, 0, 0));
        hokian.setSelected(true);
        hokian.setText("Bisa");
        hokian.setPreferredSize(new java.awt.Dimension(91, 28));

        hokian2.setBackground(new java.awt.Color(204, 204, 204));
        bhs_hokian.add(hokian2);
        hokian2.setForeground(new java.awt.Color(0, 0, 0));
        hokian2.setText("Cukup");
        hokian2.setPreferredSize(new java.awt.Dimension(91, 28));

        hokian3.setBackground(new java.awt.Color(204, 204, 204));
        bhs_hokian.add(hokian3);
        hokian3.setForeground(new java.awt.Color(0, 0, 0));
        hokian3.setText("Tidak Bisa");

        hakkan3.setBackground(new java.awt.Color(204, 204, 204));
        bhs_hakkan.add(hakkan3);
        hakkan3.setForeground(new java.awt.Color(0, 0, 0));
        hakkan3.setText("Tidak Bisa");

        hakkan2.setBackground(new java.awt.Color(204, 204, 204));
        bhs_hakkan.add(hakkan2);
        hakkan2.setForeground(new java.awt.Color(0, 0, 0));
        hakkan2.setText("Cukup");
        hakkan2.setPreferredSize(new java.awt.Dimension(91, 28));

        hakkan.setBackground(new java.awt.Color(204, 204, 204));
        bhs_hakkan.add(hakkan);
        hakkan.setForeground(new java.awt.Color(0, 0, 0));
        hakkan.setSelected(true);
        hakkan.setText("Bisa");
        hakkan.setPreferredSize(new java.awt.Dimension(91, 28));

        jSeparator4.setBackground(new java.awt.Color(153, 255, 153));
        jSeparator4.setForeground(new java.awt.Color(63, 224, 43));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Bahasa Lain :");

        bahasa_lain.setText("jTextField1");
        bahasa_lain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bahasa_lainMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inggris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inggris2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inggris3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mandarin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mandarin2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mandarin3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hokian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hokian2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hokian3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hakkan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hakkan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hakkan3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bahasa_lain)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inggris3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mandarin3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(inggris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inggris2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(mandarin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mandarin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(hokian3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hokian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hokian2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(hakkan3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hakkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hakkan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(bahasa_lain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Informasi Keluarga :");

        jSeparator5.setBackground(new java.awt.Color(153, 255, 153));
        jSeparator5.setForeground(new java.awt.Color(63, 224, 43));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Nama Ayah :");

        nama_ayah.setText("jTextField1");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Pekerjaan :");

        kerja_ayah.setText("jTextField2");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Tempat Lahir :");

        lahir_ayah.setText("jTextField3");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Tanggal Lahir :");

        tgl_ayah.setDateFormatString("dd-MMMM-yyyy");

        jSeparator6.setBackground(new java.awt.Color(153, 255, 153));
        jSeparator6.setForeground(new java.awt.Color(63, 224, 43));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator7.setBackground(new java.awt.Color(153, 255, 153));
        jSeparator7.setForeground(new java.awt.Color(63, 224, 43));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Nama Ibu :");

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Pekerjaan :");

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Tempat Lahir :");

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Tanggal Lahir :");

        nama_sum_is.setText("jTextField1");

        kerja_sum_is.setText("jTextField2");

        lahir_ibu.setText("jTextField3");

        tgl_ibu.setDateFormatString("dd-MMMM-yyyy");

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator9.setBackground(new java.awt.Color(153, 255, 153));
        jSeparator9.setForeground(new java.awt.Color(63, 224, 43));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Nama Suami / Istri :");

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Pekerjaan :");

        nama_ibu.setText("jTextField1");

        kerja_ibu.setText("jTextField2");

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Jumlah Anak :");

        jum_anak.setText("jTextField1");

        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Umur Masing-Masing Anak :");

        umur_anak.setText("jTextField1");

        jSeparator10.setBackground(new java.awt.Color(153, 255, 153));
        jSeparator10.setForeground(new java.awt.Color(63, 224, 43));

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Jumlah Saudara Laki-Laki :");

        so_laki.setText("jTextField1");

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Jumlah Saudara Perempuan :");

        so_cewek.setText("jTextField1");

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Saya Anak Ke :");

        anak_ke.setText("jTextField1");

        jSeparator11.setBackground(new java.awt.Color(153, 255, 153));
        jSeparator11.setForeground(new java.awt.Color(63, 224, 43));

        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Nama Ahli Waris :");

        ahli_war.setText("jTextField1");

        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Nama Ahli Waris :");

        hub_ahli_war.setText("jTextField2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(568, 568, 568)
                .addComponent(jSeparator8)
                .addGap(266, 266, 266))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama_ayah, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kerja_ayah, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lahir_ayah))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tgl_ayah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nama_ibu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kerja_ibu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lahir_ibu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tgl_ibu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nama_sum_is)
                    .addComponent(kerja_sum_is))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jum_anak)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(umur_anak)
                .addGap(124, 124, 124))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(so_laki)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(so_cewek)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(anak_ke)
                .addGap(129, 129, 129))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator5)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator10)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator7)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator11)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(ahli_war, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(hub_ahli_war)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(nama_ayah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(kerja_ayah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lahir_ayah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tgl_ayah, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(nama_ibu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(kerja_ibu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lahir_ibu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tgl_ibu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nama_sum_is, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(kerja_sum_is, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jum_anak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(umur_anak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))))
                .addGap(6, 6, 6)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(so_laki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(so_cewek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anak_ke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(ahli_war, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(hub_ahli_war, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epizy/mulialaksanasejahtera/icon/icons8-Back_25.png"))); // NOI18N
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epizy/mulialaksanasejahtera/icon/icons8-Next_25.png"))); // NOI18N
        jButton2.setText("Lanjutkan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bahasa_lainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bahasa_lainMouseClicked
        // TODO add your handling code here:
        bahasa_lain.setText("");
    }//GEN-LAST:event_bahasa_lainMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        interview interview = new interview();
        this.getParent().add(interview);
        try {
            interview.setMaximum(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        interview.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cek();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ahli_war;
    private javax.swing.JTextField anak_ke;
    private javax.swing.JTextField bahasa_lain;
    private javax.swing.ButtonGroup bhs_hakkan;
    private javax.swing.ButtonGroup bhs_hokian;
    private javax.swing.ButtonGroup bhs_inggris;
    private javax.swing.ButtonGroup bhs_mandarin;
    private javax.swing.JRadioButton hakkan;
    private javax.swing.JRadioButton hakkan2;
    private javax.swing.JRadioButton hakkan3;
    private javax.swing.JRadioButton hokian;
    private javax.swing.JRadioButton hokian2;
    private javax.swing.JRadioButton hokian3;
    private javax.swing.JTextField hub_ahli_war;
    private javax.swing.JRadioButton inggris;
    private javax.swing.JRadioButton inggris2;
    private javax.swing.JRadioButton inggris3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jum_anak;
    private javax.swing.JTextField kerja_ayah;
    private javax.swing.JTextField kerja_ibu;
    private javax.swing.JTextField kerja_sum_is;
    private javax.swing.JTextField lahir_ayah;
    private javax.swing.JTextField lahir_ibu;
    private javax.swing.JRadioButton mandarin;
    private javax.swing.JRadioButton mandarin2;
    private javax.swing.JRadioButton mandarin3;
    private javax.swing.JTextField nama_ayah;
    private javax.swing.JTextField nama_ibu;
    private javax.swing.JTextField nama_sum_is;
    private javax.swing.JTextField so_cewek;
    private javax.swing.JTextField so_laki;
    private com.toedter.calendar.JDateChooser tgl_ayah;
    private com.toedter.calendar.JDateChooser tgl_ibu;
    private javax.swing.JTextField umur_anak;
    // End of variables declaration//GEN-END:variables
}
