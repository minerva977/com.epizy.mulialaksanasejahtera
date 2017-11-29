/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epizy.mulialaksanasejahtera.View.JInternalFrame;

import com.epizy.mulialaksanasejahtera.Controller.controllerFisik;
import com.epizy.mulialaksanasejahtera.Controller.controllerKerja;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nier
 */
public class negara_ket_fisik extends javax.swing.JInternalFrame {

    /**
     * Creates new form negara_ket_fisik
     */
    private final String par = interview.parameter;
    public negara_ket_fisik() {
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        initComponents();
        jLabel1.setText("Tujuan Dan Data Fisik Dengan Nomer Registrasi : "+par);
        clr();
        setNegara();
    }
    
    private void clr () {
        keterampilan.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        String sql = "SELECT kerja.*, fisik.* "
                + "FROM kerja, fisik "
                + "WHERE kerja.no_reg = '"+par+"' AND fisik.no_reg = '"+par+"'";
        PreparedStatement preparedStatement;
        try {
            
            preparedStatement = dataBaseConncetionFactory.getConnection().prepareCall(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                
                negara.setSelectedItem(resultSet.getString(2));
                keterampilan.setText(resultSet.getString(3));
                
                if ("YA".equals(resultSet.getString(5))) {
                    rokok.setSelected(true);
                }
                else {
                    rokok2.setSelected(true);
                }
                
                jTextField1.setText(resultSet.getString(6));
                
                if ("YA".equals(resultSet.getString(7))) {
                    keras.setSelected(true);
                }
                else {
                    keras2.setSelected(true);
                }
                
                jTextField2.setText(resultSet.getString(8));
                
                if ("YA".equals(resultSet.getString(9))) {
                    tato.setSelected(true);
                }
                else {
                    tato2.setSelected(true);
                }
                
                jTextField3.setText(resultSet.getString(10));
                
                if ("YA".equals(resultSet.getString(11))) {
                    buta.setSelected(true);
                }
                else {
                    buta2.setSelected(true);
                }
                
                jTextField4.setText(resultSet.getString(12));
                
                if ("YA".equals(resultSet.getString(13))) {
                    rabun.setSelected(true);
                }
                else {
                    rabun2.setSelected(true);
                }
                
                jTextField5.setText(resultSet.getString(14));
                
                if ("YA".equals(resultSet.getString(15))) {
                    alergi.setSelected(true);
                }
                else {
                    alergi2.setSelected(true);
                }
                
                jTextField6.setText(resultSet.getString(16));
            }
        } catch (Exception ignored) {
            
        }
    }
    
    private void cek () {
        if ("".equals(keterampilan.getText())) {
            JOptionPane.showMessageDialog(null, "Maaf keterampilan harap di isi !!"
                    , "Perignatan !!", JOptionPane.WARNING_MESSAGE);
            keterampilan.requestFocus();
        }
        else if ("".equals(jTextField1.getText())) {
            JOptionPane.showMessageDialog(null, "Maaf Keterangan harap di isi !!"
                    , "Perignatan !!", JOptionPane.WARNING_MESSAGE);
            jTextField1.requestFocus();
        }
        else if ("".equals(jTextField2.getText())) {
            JOptionPane.showMessageDialog(null, "Maaf Keterangan harap di isi !!"
                    , "Perignatan !!", JOptionPane.WARNING_MESSAGE);
            jTextField2.requestFocus();
        }
        else if ("".equals(jTextField3.getText())) {
            JOptionPane.showMessageDialog(null, "Maaf Keterangan harap di isi !!"
                    , "Perignatan !!", JOptionPane.WARNING_MESSAGE);
            jTextField3.requestFocus();
        }
        else if ("".equals(jTextField4.getText())) {
            JOptionPane.showMessageDialog(null, "Maaf Keterangan harap di isi !!"
                    , "Perignatan !!", JOptionPane.WARNING_MESSAGE);
            jTextField4.requestFocus();
        }
        else if ("".equals(jTextField5.getText())) {
            JOptionPane.showMessageDialog(null, "Maaf Keterangan harap di isi !!"
                    , "Perignatan !!", JOptionPane.WARNING_MESSAGE);
            jTextField5.requestFocus();
        }
        else if ("".equals(jTextField6.getText())) {
            JOptionPane.showMessageDialog(null, "Maaf Keterangan harap di isi !!"
                    , "Perignatan !!", JOptionPane.WARNING_MESSAGE);
            jTextField6.requestFocus();
        }
        else {
            pertanyaan pertanyaan = new pertanyaan();
            this.getParent().add(pertanyaan);
            try {
                pertanyaan.setMaximum(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            pertanyaan.setVisible(true);
            input();
            this.setVisible(false);
        }
    }
    
    private void input () {
        controllerKerja cKerja = new controllerKerja(this);
        controllerFisik cFisik = new controllerFisik(this);
        cKerja.save(par, negara.getSelectedItem(), keterampilan.getText());
        cFisik.save(par, merokokString(), jTextField1.getText()
                , kerasString(), jTextField2.getText()
                , tatoString(), jTextField3.getText()
                , butaString(), jTextField4.getText()
                , rabunString(), jTextField5.getText()
                , alergiString(), jTextField6.getText());
    }
    
    private void setNegara () {
        String sql = "SELECT * FROM `negara`";
        PreparedStatement preparedStatement;
        negara.removeAllItems();
        try {
            preparedStatement = dataBaseConncetionFactory.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                negara.addItem(resultSet.getString(2));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private String merokokString () {
        if (rokok.isSelected()) {
            return "YA";
        }
        else {
            return "TIDAK";
        }
    }
    
    private String kerasString () {
        if (keras.isSelected()) {
            return "YA";
        }
        else {
            return "TIDAK";
        }
    }
    
    private String tatoString () {
        if (tato.isSelected()) {
            return "YA";
        }
        else {
            return "TIDAK";
        }
    }
    
    private String butaString () {
        if (buta.isSelected()) {
            return "YA";
        }
        else {
            return "TIDAK";
        }
    }
    
    private String rabunString () {
        if (rabun.isSelected()) {
            return "YA";
        }
        else {
            return "TIDAK";
        }
    }
    
    private String alergiString () {
        if (alergi.isSelected()) {
            return "YA";
        }
        else {
            return "TIDAK";
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

        ButtonGroup merokok = new ButtonGroup();
        ButtonGroup minum_minuman_keras = new ButtonGroup();
        ButtonGroup tatto = new ButtonGroup();
        ButtonGroup buta_warna = new ButtonGroup();
        ButtonGroup rabun_dekat = new ButtonGroup();
        ButtonGroup alergiGrub = new ButtonGroup();
        JPanel jPanel1 = new JPanel();
        jLabel1 = new javax.swing.JLabel();
        JPanel jPanel2 = new JPanel();
        JLabel jLabel2 = new JLabel();
        negara = new javax.swing.JComboBox<>();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JSeparator jSeparator1 = new JSeparator();
        keterampilan = new javax.swing.JTextField();
        JPanel jPanel3 = new JPanel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JSeparator jSeparator2 = new JSeparator();
        JLabel jLabel7 = new JLabel();
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel();
        JLabel jLabel10 = new JLabel();
        JLabel jLabel11 = new JLabel();
        rokok = new javax.swing.JRadioButton();
        rokok2 = new javax.swing.JRadioButton();
        keras = new javax.swing.JRadioButton();
        keras2 = new javax.swing.JRadioButton();
        tato = new javax.swing.JRadioButton();
        tato2 = new javax.swing.JRadioButton();
        buta = new javax.swing.JRadioButton();
        buta2 = new javax.swing.JRadioButton();
        rabun = new javax.swing.JRadioButton();
        rabun2 = new javax.swing.JRadioButton();
        alergi = new javax.swing.JRadioButton();
        alergi2 = new javax.swing.JRadioButton();
        JLabel jLabel12 = new JLabel();
        JLabel jLabel13 = new JLabel();
        JLabel jLabel14 = new JLabel();
        JLabel jLabel15 = new JLabel();
        JLabel jLabel16 = new JLabel();
        JLabel jLabel17 = new JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(63, 224, 43));

        jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tujuan Dan Data Fisik");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Negara Tujuan :");

        negara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Keterampilan :");

        jLabel4.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tujuan :");

        jSeparator1.setBackground(new java.awt.Color(153, 255, 153));
        jSeparator1.setForeground(new java.awt.Color(63, 224, 43));

        keterampilan.setText("jTextField7");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(negara, 0, 198, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(keterampilan, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(negara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(keterampilan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Merokok :");

        jLabel6.setFont(new java.awt.Font("Dialog", Font.BOLD, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fisik :");

        jSeparator2.setBackground(new java.awt.Color(153, 255, 153));
        jSeparator2.setForeground(new java.awt.Color(63, 224, 43));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Minum Minuman Keras :");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("TATTO :");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Buta Warna :");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Rabun Dekat :");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Alergi :");

        rokok.setBackground(new java.awt.Color(204, 204, 204));
        merokok.add(rokok);
        rokok.setForeground(new java.awt.Color(0, 0, 0));
        rokok.setSelected(true);
        rokok.setText("YA");

        rokok2.setBackground(new java.awt.Color(204, 204, 204));
        merokok.add(rokok2);
        rokok2.setForeground(new java.awt.Color(0, 0, 0));
        rokok2.setText("TIDAK");

        keras.setBackground(new java.awt.Color(204, 204, 204));
        minum_minuman_keras.add(keras);
        keras.setForeground(new java.awt.Color(0, 0, 0));
        keras.setSelected(true);
        keras.setText("YA");

        keras2.setBackground(new java.awt.Color(204, 204, 204));
        minum_minuman_keras.add(keras2);
        keras2.setForeground(new java.awt.Color(0, 0, 0));
        keras2.setText("TIDAK");

        tato.setBackground(new java.awt.Color(204, 204, 204));
        tatto.add(tato);
        tato.setForeground(new java.awt.Color(0, 0, 0));
        tato.setSelected(true);
        tato.setText("YA");

        tato2.setBackground(new java.awt.Color(204, 204, 204));
        tatto.add(tato2);
        tato2.setForeground(new java.awt.Color(0, 0, 0));
        tato2.setText("TIDAK");

        buta.setBackground(new java.awt.Color(204, 204, 204));
        buta_warna.add(buta);
        buta.setForeground(new java.awt.Color(0, 0, 0));
        buta.setSelected(true);
        buta.setText("YA");

        buta2.setBackground(new java.awt.Color(204, 204, 204));
        buta_warna.add(buta2);
        buta2.setForeground(new java.awt.Color(0, 0, 0));
        buta2.setText("TIDAK");

        rabun.setBackground(new java.awt.Color(204, 204, 204));
        rabun_dekat.add(rabun);
        rabun.setForeground(new java.awt.Color(0, 0, 0));
        rabun.setSelected(true);
        rabun.setText("YA");

        rabun2.setBackground(new java.awt.Color(204, 204, 204));
        rabun_dekat.add(rabun2);
        rabun2.setForeground(new java.awt.Color(0, 0, 0));
        rabun2.setText("TIDAK");

        alergi.setBackground(new java.awt.Color(204, 204, 204));
        alergiGrub.add(alergi);
        alergi.setForeground(new java.awt.Color(0, 0, 0));
        alergi.setSelected(true);
        alergi.setText("YA");

        alergi2.setBackground(new java.awt.Color(204, 204, 204));
        alergiGrub.add(alergi2);
        alergi2.setForeground(new java.awt.Color(0, 0, 0));
        alergi2.setText("TIDAK");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Keterangan :");

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Keterangan :");

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Keterangan :");

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Keterangan :");

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Keterangan :");

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Keterangan :");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField1");

        jTextField3.setText("jTextField1");

        jTextField4.setText("jTextField1");

        jTextField5.setText("jTextField1");

        jTextField6.setText("jTextField1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(tato, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tato2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(buta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buta2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(rabun, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rabun2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(alergi, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(alergi2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rokok, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rokok2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(keras, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(keras2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rokok)
                    .addComponent(rokok2)
                    .addComponent(jLabel12)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(keras)
                    .addComponent(keras2)
                    .addComponent(jLabel13)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(tato)
                        .addComponent(tato2)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(buta)
                    .addComponent(buta2)
                    .addComponent(jLabel15)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rabun)
                    .addComponent(rabun2)
                    .addComponent(jLabel16)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(alergi)
                    .addComponent(alergi2)
                    .addComponent(jLabel17)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epizy/mulialaksanasejahtera/icon/icons8-Back_25.png"))); // NOI18N
        jButton1.setText("Kembali");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epizy/mulialaksanasejahtera/icon/icons8-Next_25.png"))); // NOI18N
        jButton2.setText("Lanjutkan");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        bahasa_keluarga bahasa_keluarga = new bahasa_keluarga();
        this.getParent().add(bahasa_keluarga);
        try {
            bahasa_keluarga.setMaximum(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bahasa_keluarga.setVisible(true);
        input();
        this.setVisible(false);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        cek();
        this.setCursor(Cursor.getDefaultCursor());
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton alergi;
    private javax.swing.JRadioButton alergi2;
    private javax.swing.JRadioButton buta;
    private javax.swing.JRadioButton buta2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JRadioButton keras;
    private javax.swing.JRadioButton keras2;
    private javax.swing.JTextField keterampilan;
    private javax.swing.JComboBox<String> negara;
    private javax.swing.JRadioButton rabun;
    private javax.swing.JRadioButton rabun2;
    private javax.swing.JRadioButton rokok;
    private javax.swing.JRadioButton rokok2;
    private javax.swing.JRadioButton tato;
    private javax.swing.JRadioButton tato2;
    // End of variables declaration//GEN-END:variables
}
