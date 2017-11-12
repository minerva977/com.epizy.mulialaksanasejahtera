/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epizy.mulialaksanasejahtera.DAO;

import javax.swing.*;
import java.util.List;

/**
 *
 * @author Nier
 */
public interface configDAO {
    public void getImageFormWeb(String Name,JLabel jLabel);
    public void SendEmail(List<Object> listObjects);
}
