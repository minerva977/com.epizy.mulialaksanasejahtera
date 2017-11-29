/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epizy.mulialaksanasejahtera.DAO;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Nier
 */
public interface configDAO {
    void getImageFormWeb(String Name, JLabel jLabel);
    void SendEmail(String[] Object);
    void setIcon (JFrame jFrame);
    void setIcon (Frame frame);
}
