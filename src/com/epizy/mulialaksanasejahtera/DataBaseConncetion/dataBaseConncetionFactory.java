package com.epizy.mulialaksanasejahtera.DataBaseConncetion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataBaseConncetionFactory {
    static Connection connection;
    private static String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/";
    private static String nameDB = "sql12207627";
    private static String idDB = "sql12207627";
    private static String pasDB = "5MVFBayeBt";
    private static String Driver = "com.mysql.jdbc.Driver";
    public static Connection getConnection(){
        if (connection == null) {
            try {
                //Class.forName(Driver);
                connection = DriverManager.getConnection(url+nameDB,idDB,pasDB);
                System.out.println("koneksi sukses");
            }catch (SQLException e){
                System.out.println("koneksi gagal");
                /*try {
                    url = "jdbc:mysql://localhost:3306/";
                    nameDB = "mulia_laksana_sejatra";
                    idDB = "root";
                    pasDB = "";
                    Driver = "com.mysql.jdbc.Driver";
                    connection = DriverManager.getConnection(url+nameDB,idDB,pasDB);
                }catch (Exception ex) {
                    e.printStackTrace();
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(
                            null, "Maaf Anda Tidak Terkoneksi Dengan Internet !!!"
                            , "Peringatan !!!", JOptionPane.WARNING_MESSAGE
                    );
                    System.exit(0);
                }*/
                JOptionPane.showMessageDialog(
                        null, "Maaf Anda Tidak Terkoneksi Dengan Internet !!!"
                        , "Peringatan !!!", JOptionPane.WARNING_MESSAGE
                );
                System.exit(0);
                e.printStackTrace();
            }
        }
        return connection;
    }
}
