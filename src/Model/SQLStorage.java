/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Derek
 */
public class SQLStorage {
    
    private static Connection c;
    
    public static boolean SQLStorage(String ip, String username, String password){
        try{  
            c = DriverManager.getConnection(ip, username, password);
            JOptionPane.showMessageDialog(null, "Connection to db successful!", "DB Storage Connection", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Connection to db unsuccessful!", "DB Storage Connection", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            return false;
        }
    }
    
    
    
    
}
