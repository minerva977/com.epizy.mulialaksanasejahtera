package com.epizy.mulialaksanasejahtera.DataBaseConncetion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class dataBaseConncetionFactory {
    static Connection connection;
    private static String url = "sql200.epizy.com";
    private static String nameDB = "epiz_20585881_mulia_laksana_sejatra";
    private static String idDB = "epiz_20585881";
    private static String pasDB = "ika120517";
    private static String Driver = "com.mysql.jdbc.Driver";
    public static Connection getConnection(){
        if (connection == null) {
            try {
                Class.forName(Driver);
                connection = DriverManager.getConnection(url+nameDB,idDB,pasDB);
            }catch (Exception e){
                try {
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
                }
            }
        }
        return connection;
    }
}
