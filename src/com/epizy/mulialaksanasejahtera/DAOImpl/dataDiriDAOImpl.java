package com.epizy.mulialaksanasejahtera.DAOImpl;

import com.epizy.mulialaksanasejahtera.DAO.dataDiriDAO;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;
import com.epizy.mulialaksanasejahtera.Model.dataDiri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dataDiriDAOImpl implements dataDiriDAO {
    private final String insert = "INSERT INTO `data_pribadi`\n" +
            "(`no_reg`, `tgl`, `kelamin`, `pot_gaji`, `no_ktp`\n" +
            ", `tempat_ktp_dibuat`, `tgl_ktp_dibuat`, `nama`, `usia`, `alamat`\n" +
            ", `desa/kel`, `kecamatan`, `kab/kota`, `propinsi`, `tempat_lahir`\n" +
            ", `tgl_lahir`, `no_tlpn`, `no_hp/flexy`, `tinggi_badan`, `berat_badan`\n" +
            ", `setatus`, `tgl_setatus`, `pendidikan`, `agama`, `foto`\n" +
            ", `email`, `keterampilan_kusus`) \n" +
            "VALUES \n" +
            "(?,?,?,?,?\n" +
            ",?,?,?,?,?\n" +
            ",?,?,?,?,?\n" +
            ",?,?,?,?,?\n" +
            ",?,?,?,?,?\n" +
            ",?,?)";
    private final String update = "UPDATE `data_pribadi` \n" +
            "SET \n" +
            "`tgl`=?,`kelamin`=?,`pot_gaji`=?,`no_ktp`=?,`tempat_ktp_dibuat`=?\n" +
            ",`tgl_ktp_dibuat`=?,`nama`=?,`usia`=?,`alamat`=?,`desa/kel`=?\n" +
            ",`kecamatan`=?,`kab/kota`=?,`propinsi`=?,`tempat_lahir`=?,`tgl_lahir`=?\n" +
            ",`no_tlpn`=?,`no_hp/flexy`=?,`tinggi_badan`=?,`berat_badan`=?,`setatus`=?\n" +
            ",`tgl_setatus`=?,`pendidikan`=?,`agama`=?,`foto`=?,`email`=?\n" +
            ",`keterampilan_kusus`=? \n" +
            "WHERE \n" +
            "`no_reg`=?";
    private final String delete = "DELETE FROM `data_pribadi` WHERE `no_reg`=?";
    private final String select = "SELECT * FROM `data_pribadi`";
    private final String selectWhere = "SELECT * \n" +
            "FROM\n" +
            "`data_pribadi` \n" +
            "WHERE\n" +
            "`no_reg` like ? OR `tgl` like ? OR `kelamin` like ? OR `pot_gaji` like ? OR `no_ktp` like ? OR\n" +
            "`tempat_ktp_dibuat` like ? OR `tgl_ktp_dibuat` like ? OR `nama` like ? OR `usia` like ? OR `alamat` like ? OR\n" +
            "`desa/kel` like ? OR `kecamatan` like ? OR `kab/kota` like ? OR `propinsi` like ? OR `tempat_lahir` like ? OR\n" +
            "`tgl_lahir` like ? OR `no_tlpn` like ? OR `no_hp/flexy` like ? OR `tinggi_badan` like ? OR `berat_badan` like ? OR\n"+
            "`setatus` like ? OR `tgl_setatus` like ? OR `pendidikan` like ? OR `agama` like ? OR `foto` like ? OR\n" +
            "`email` like ? OR `keterampilan_kusus` like ?";
    private Connection connection;

    public dataDiriDAOImpl(){
        connection = dataBaseConncetionFactory.getConnection();
    }

    @Override
    public void Save(dataDiri dataDiri) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,dataDiri.getNoRegistrasi());
            preparedStatement.setString(2,dataDiri.getTanggal());
            preparedStatement.setString(3,dataDiri.getKelamin());
            preparedStatement.setString(4,dataDiri.getPotonganGaji());
            preparedStatement.setString(5,dataDiri.getNoKTP());
            preparedStatement.setString(6,dataDiri.getTempatKTPDiBuat());
            preparedStatement.setString(7,dataDiri.getTanggalKTPDiBuat());
            preparedStatement.setString(8,dataDiri.getNama());
            preparedStatement.setString(9,dataDiri.getUsia());
            preparedStatement.setString(10,dataDiri.getAlamat());
            preparedStatement.setString(11,dataDiri.getDesaKelurahan());
            preparedStatement.setString(12,dataDiri.getKecamatan());
            preparedStatement.setString(13,dataDiri.getKabupatenKota());
            preparedStatement.setString(14,dataDiri.getPropinsi());
            preparedStatement.setString(15,dataDiri.getTempatLahir());
            preparedStatement.setString(16,dataDiri.getTanggalLahir());
            preparedStatement.setString(17,dataDiri.getNoTelpon());
            preparedStatement.setString(18,dataDiri.getNoHPNoFlexy());
            preparedStatement.setString(19,dataDiri.getTinggiBadan());
            preparedStatement.setString(20,dataDiri.getBeratbadan());
            preparedStatement.setString(21,dataDiri.getSetatus());
            preparedStatement.setString(22,dataDiri.getTanggalSetatus());
            preparedStatement.setString(23,dataDiri.getPendidikan());
            preparedStatement.setString(24,dataDiri.getAgama());
            preparedStatement.setString(25,dataDiri.getFoto());
            preparedStatement.setString(26,dataDiri.getEmail());
            preparedStatement.setString(27,dataDiri.getKeterampilanKusus());
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
    public void Update(dataDiri dataDiri) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1,dataDiri.getTanggal());
            preparedStatement.setString(2,dataDiri.getKelamin());
            preparedStatement.setString(3,dataDiri.getPotonganGaji());
            preparedStatement.setString(4,dataDiri.getNoKTP());
            preparedStatement.setString(5,dataDiri.getTempatKTPDiBuat());
            preparedStatement.setString(6,dataDiri.getTanggalKTPDiBuat());
            preparedStatement.setString(7,dataDiri.getNama());
            preparedStatement.setString(8,dataDiri.getUsia());
            preparedStatement.setString(9,dataDiri.getAlamat());
            preparedStatement.setString(10,dataDiri.getDesaKelurahan());
            preparedStatement.setString(11,dataDiri.getKecamatan());
            preparedStatement.setString(12,dataDiri.getKabupatenKota());
            preparedStatement.setString(13,dataDiri.getPropinsi());
            preparedStatement.setString(14,dataDiri.getTempatLahir());
            preparedStatement.setString(15,dataDiri.getTanggalLahir());
            preparedStatement.setString(16,dataDiri.getNoTelpon());
            preparedStatement.setString(17,dataDiri.getNoHPNoFlexy());
            preparedStatement.setString(18,dataDiri.getTinggiBadan());
            preparedStatement.setString(19,dataDiri.getBeratbadan());
            preparedStatement.setString(20,dataDiri.getSetatus());
            preparedStatement.setString(21,dataDiri.getTanggalSetatus());
            preparedStatement.setString(22,dataDiri.getPendidikan());
            preparedStatement.setString(23,dataDiri.getAgama());
            preparedStatement.setString(24,dataDiri.getFoto());
            preparedStatement.setString(25,dataDiri.getEmail());
            preparedStatement.setString(26,dataDiri.getKeterampilanKusus());
            preparedStatement.setString(27,dataDiri.getNoRegistrasi());
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
    public void Delete(Object object) {
        PreparedStatement preparedStatement = null;
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
    public List<dataDiri> GetAll() {
        List<dataDiri> dataDiriList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                dataDiri dataDiri = new dataDiri();
                dataDiri.setNoRegistrasi(resultSet.getString(1));
                dataDiri.setTanggal(resultSet.getString(2));
                dataDiri.setKelamin(resultSet.getString(3));
                dataDiri.setPotonganGaji(resultSet.getString(4));
                dataDiri.setNoKTP(resultSet.getString(5));
                dataDiri.setTempatKTPDiBuat(resultSet.getString(6));
                dataDiri.setTanggalKTPDiBuat(resultSet.getString(7));
                dataDiri.setNama(resultSet.getString(8));
                dataDiri.setUsia(resultSet.getString(9));
                dataDiri.setAlamat(resultSet.getString(10));
                dataDiri.setDesaKelurahan(resultSet.getString(11));
                dataDiri.setKecamatan(resultSet.getString(12));
                dataDiri.setKabupatenKota(resultSet.getString(13));
                dataDiri.setPropinsi(resultSet.getString(14));
                dataDiri.setTempatLahir(resultSet.getString(15));
                dataDiri.setTanggalLahir(resultSet.getString(16));
                dataDiri.setNoTelpon(resultSet.getString(17));
                dataDiri.setNoHPNoFlexy(resultSet.getString(18));
                dataDiri.setTinggiBadan(resultSet.getString(19));
                dataDiri.setBeratbadan(resultSet.getString(20));
                dataDiri.setSetatus(resultSet.getString(21));
                dataDiri.setTanggalSetatus(resultSet.getString(22));
                dataDiri.setPendidikan(resultSet.getString(23));
                dataDiri.setAgama(resultSet.getString(24));
                dataDiri.setFoto(resultSet.getString(25));
                dataDiri.setEmail(resultSet.getString(26));
                dataDiri.setKeterampilanKusus(resultSet.getString(27));
                dataDiriList.add(dataDiri);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataDiriList;
    }

    @Override
    public List<dataDiri> GetDataByObject(Object object) {
        List<dataDiri> dataDiriList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(selectWhere);
            preparedStatement.setString(1, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(2, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(3, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(4, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(5, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(6, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(7, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(8, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(9, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(10, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(11, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(12, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(13, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(14, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(15, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(16, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(17, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(18, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(19, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(20, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(21, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(22, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(23, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(24, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(25, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(26, "%"+String.valueOf(object)+"%");
            preparedStatement.setString(27, "%"+String.valueOf(object)+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                dataDiri dataDiri = new dataDiri();
                dataDiri.setNoRegistrasi(resultSet.getString(1));
                dataDiri.setTanggal(resultSet.getString(2));
                dataDiri.setKelamin(resultSet.getString(3));
                dataDiri.setPotonganGaji(resultSet.getString(4));
                dataDiri.setNoKTP(resultSet.getString(5));
                dataDiri.setTempatKTPDiBuat(resultSet.getString(6));
                dataDiri.setTanggalKTPDiBuat(resultSet.getString(7));
                dataDiri.setNama(resultSet.getString(8));
                dataDiri.setUsia(resultSet.getString(9));
                dataDiri.setAlamat(resultSet.getString(10));
                dataDiri.setDesaKelurahan(resultSet.getString(11));
                dataDiri.setKecamatan(resultSet.getString(12));
                dataDiri.setKabupatenKota(resultSet.getString(13));
                dataDiri.setPropinsi(resultSet.getString(14));
                dataDiri.setTempatLahir(resultSet.getString(15));
                dataDiri.setTanggalLahir(resultSet.getString(16));
                dataDiri.setNoTelpon(resultSet.getString(17));
                dataDiri.setNoHPNoFlexy(resultSet.getString(18));
                dataDiri.setTinggiBadan(resultSet.getString(19));
                dataDiri.setBeratbadan(resultSet.getString(20));
                dataDiri.setSetatus(resultSet.getString(21));
                dataDiri.setTanggalSetatus(resultSet.getString(22));
                dataDiri.setPendidikan(resultSet.getString(23));
                dataDiri.setAgama(resultSet.getString(24));
                dataDiri.setFoto(resultSet.getString(25));
                dataDiri.setEmail(resultSet.getString(26));
                dataDiri.setKeterampilanKusus(resultSet.getString(27));
                dataDiriList.add(dataDiri);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataDiriList;
    }
}
