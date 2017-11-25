package com.epizy.mulialaksanasejahtera.DAOImpl;

import com.epizy.mulialaksanasejahtera.DAO.informasiKeluargaDAO;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;
import com.epizy.mulialaksanasejahtera.Model.informasiKeluarga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class informasiKeluargaDAOImpl implements informasiKeluargaDAO {
    private final String insert = "INSERT INTO `informasi_keluarga`(`no_reg`, `nama_bpk`, `kerja_bpk`" +
            ", `tempat_lhr_bpk`, `tgl_lhr_bpk`, `nama_ibuk`, `kerja_ibuk`, `tempat_lhr_ibuk`, `tgl_lhr_ibuk`" +
            ", `nama_pasangan`, `kerja_pasangan`, `jml_anak`, `umur_anak`, `jml_sdr_laki`, `jml_sdr_perempuan`" +
            ", `anak_ke`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String update = "UPDATE `informasi_keluarga` SET `nama_bpk`=?,`kerja_bpk`=?,`tempat_lhr_bpk`=?" +
            ",`tgl_lhr_bpk`=?,`nama_ibuk`=?,`kerja_ibuk`=?,`tempat_lhr_ibuk`=?,`tgl_lhr_ibuk`=?,`nama_pasangan`=?" +
            ",`kerja_pasangan`=?,`jml_anak`=?,`umur_anak`=?,`jml_sdr_laki`=?,`jml_sdr_perempuan`=?" +
            ",`anak_ke`=? WHERE `no_reg`=?";
    private final String delete = "DELETE FROM `informasi_keluarga` WHERE `no_reg`=?";
    private final String select = "SELECT * FROM `informasi_keluarga`";
    private final String selectWhere = "SELECT * FROM `informasi_keluarga` WHERE `no_reg`=? OR  `nama_bpk`=? OR " +
            " `kerja_bpk`=? OR  `tempat_lhr_bpk`=? OR `tgl_lhr_bpk`=? OR  `nama_ibuk`=? OR  `kerja_ibuk`=? OR" +
            " `tempat_lhr_ibuk`=? OR `tgl_lhr_ibuk`=? OR  `nama_pasangan`=? OR  `kerja_pasangan`=? OR" +
            " `jml_anak`=? OR  `umur_anak`=? OR  `jml_sdr_laki`=? OR  `jml_sdr_perempuan`=? OR  `anak_ke`=?";
    private Connection connection;

    public informasiKeluargaDAOImpl(){
        connection = dataBaseConncetionFactory.getConnection();
    }

    @Override
    public void Save(informasiKeluarga informasiKeluarga) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,informasiKeluarga.getNoRegistrasi());
            preparedStatement.setString(2,informasiKeluarga.getNamaBapak());
            preparedStatement.setString(3,informasiKeluarga.getKerjaBapak());
            preparedStatement.setString(4,informasiKeluarga.getTempatLahirBapak());
            preparedStatement.setString(5,informasiKeluarga.getTanggalLahirBapak());
            preparedStatement.setString(6,informasiKeluarga.getNamaIbu());
            preparedStatement.setString(7,informasiKeluarga.getKerjaIbu());
            preparedStatement.setString(8,informasiKeluarga.getTanggalLahirIbu());
            preparedStatement.setString(9,informasiKeluarga.getTanggalLahirIbu());
            preparedStatement.setString(10,informasiKeluarga.getNamaPasangan());
            preparedStatement.setString(11,informasiKeluarga.getKerjaPasagan());
            preparedStatement.setString(12,informasiKeluarga.getJumlahAnak());
            preparedStatement.setString(13,informasiKeluarga.getUmurAnak());
            preparedStatement.setString(14,informasiKeluarga.getJumlahSodaraLakiLaki());
            preparedStatement.setString(15,informasiKeluarga.getJumlahSodaraPerempuan());
            preparedStatement.setString(16,informasiKeluarga.getAnakKe());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            try {
                preparedStatement = connection.prepareStatement(update);
                preparedStatement.setString(16,informasiKeluarga.getNoRegistrasi());
                preparedStatement.setString(1,informasiKeluarga.getNamaBapak());
                preparedStatement.setString(2,informasiKeluarga.getKerjaBapak());
                preparedStatement.setString(3,informasiKeluarga.getTempatLahirBapak());
                preparedStatement.setString(4,informasiKeluarga.getTanggalLahirBapak());
                preparedStatement.setString(5,informasiKeluarga.getNamaIbu());
                preparedStatement.setString(6,informasiKeluarga.getKerjaIbu());
                preparedStatement.setString(7,informasiKeluarga.getTanggalLahirIbu());
                preparedStatement.setString(8,informasiKeluarga.getTanggalLahirIbu());
                preparedStatement.setString(9,informasiKeluarga.getNamaPasangan());
                preparedStatement.setString(10,informasiKeluarga.getKerjaPasagan());
                preparedStatement.setString(11,informasiKeluarga.getJumlahAnak());
                preparedStatement.setString(12,informasiKeluarga.getUmurAnak());
                preparedStatement.setString(13,informasiKeluarga.getJumlahSodaraLakiLaki());
                preparedStatement.setString(14,informasiKeluarga.getJumlahSodaraPerempuan());
                preparedStatement.setString(15,informasiKeluarga.getAnakKe());
                preparedStatement.executeUpdate();
            }catch (SQLException ex) {
                e.printStackTrace();
                ex.printStackTrace();
            }
        }
        finally {
            if (connection != null) {
                try {
                    preparedStatement.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void Delete(Object object) {    PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, String.valueOf(object));
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    preparedStatement.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<informasiKeluarga> GetAll() {
        List<informasiKeluarga> informasiKeluargaList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                informasiKeluarga informasiKeluarga = new informasiKeluarga();
                informasiKeluarga.setNoRegistrasi(resultSet.getString(1));
                informasiKeluarga.setNamaBapak(resultSet.getString(2));
                informasiKeluarga.setKerjaBapak(resultSet.getString(3));
                informasiKeluarga.setTempatLahirBapak(resultSet.getString(4));
                informasiKeluarga.setTanggalLahirBapak(resultSet.getString(5));
                informasiKeluarga.setNamaIbu(resultSet.getString(6));
                informasiKeluarga.setKerjaIbu(resultSet.getString(7));
                informasiKeluarga.setTempatLahirIbu(resultSet.getString(8));
                informasiKeluarga.setTanggalLahirIbu(resultSet.getString(9));
                informasiKeluarga.setNamaPasangan(resultSet.getString(10));
                informasiKeluarga.setKerjaPasagan(resultSet.getString(11));
                informasiKeluarga.setJumlahAnak(resultSet.getString(12));
                informasiKeluarga.setUmurAnak(resultSet.getString(13));
                informasiKeluarga.setJumlahSodaraLakiLaki(resultSet.getString(14));
                informasiKeluarga.setJumlahSodaraPerempuan(resultSet.getString(15));
                informasiKeluarga.setAnakKe(resultSet.getString(16));
                informasiKeluargaList.add(informasiKeluarga);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return  informasiKeluargaList;
    }

    @Override
    public List<informasiKeluarga> GetDataByOject(Object object) {
        List<informasiKeluarga> informasiKeluargaList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(selectWhere);
            preparedStatement.setString(1, String.valueOf(object));
            preparedStatement.setString(2, String.valueOf(object));
            preparedStatement.setString(3, String.valueOf(object));
            preparedStatement.setString(4, String.valueOf(object));
            preparedStatement.setString(5, String.valueOf(object));
            preparedStatement.setString(6, String.valueOf(object));
            preparedStatement.setString(7, String.valueOf(object));
            preparedStatement.setString(8, String.valueOf(object));
            preparedStatement.setString(9, String.valueOf(object));
            preparedStatement.setString(10, String.valueOf(object));
            preparedStatement.setString(11, String.valueOf(object));
            preparedStatement.setString(12, String.valueOf(object));
            preparedStatement.setString(13, String.valueOf(object));
            preparedStatement.setString(14, String.valueOf(object));
            preparedStatement.setString(15, String.valueOf(object));
            preparedStatement.setString(16, String.valueOf(object));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                informasiKeluarga informasiKeluarga = new informasiKeluarga();
                informasiKeluarga.setNoRegistrasi(resultSet.getString(1));
                informasiKeluarga.setNamaBapak(resultSet.getString(2));
                informasiKeluarga.setKerjaBapak(resultSet.getString(3));
                informasiKeluarga.setTempatLahirBapak(resultSet.getString(4));
                informasiKeluarga.setTanggalLahirBapak(resultSet.getString(5));
                informasiKeluarga.setNamaIbu(resultSet.getString(6));
                informasiKeluarga.setKerjaIbu(resultSet.getString(7));
                informasiKeluarga.setTempatLahirIbu(resultSet.getString(8));
                informasiKeluarga.setTanggalLahirIbu(resultSet.getString(9));
                informasiKeluarga.setNamaPasangan(resultSet.getString(10));
                informasiKeluarga.setKerjaPasagan(resultSet.getString(11));
                informasiKeluarga.setJumlahAnak(resultSet.getString(12));
                informasiKeluarga.setUmurAnak(resultSet.getString(13));
                informasiKeluarga.setJumlahSodaraLakiLaki(resultSet.getString(14));
                informasiKeluarga.setJumlahSodaraPerempuan(resultSet.getString(15));
                informasiKeluarga.setAnakKe(resultSet.getString(16));
                informasiKeluargaList.add(informasiKeluarga);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return  informasiKeluargaList;
    }
}
