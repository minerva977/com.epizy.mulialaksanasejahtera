package com.epizy.mulialaksanasejahtera.DataBaseConncetion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class dataBaseConncetionFactory {
    static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/";
    private static String nameDB = "mulia_laksana_sejatra";
    private static String idDB = "root";
    private static String pasDB = "";
    private static String Driver = "com.mysql.jdbc.Driver";
    public static Connection getConnection(){
        if(connection == null){
            try {
                Class.forName(Driver);
                connection = DriverManager.getConnection(url+nameDB,idDB,pasDB);
            }catch (Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(
                        null, "Maaf Anda Tidak Terkoneksi Dengan Internet !!!"
                        , "Peringatan !!!", JOptionPane.WARNING_MESSAGE
                );
                System.exit(0);
            }
        }
        return connection;
    }
}
