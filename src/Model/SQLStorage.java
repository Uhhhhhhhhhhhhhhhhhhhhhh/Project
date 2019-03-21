/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Derek
 */
public class SQLStorage {
    
    private static Connection c;
    
    public static boolean ConnectSQLStorage(String ip, String username, String password){
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
    
    public static boolean DisconnectSQLStorage(String ip, String username, String password){
        if(c != null)
            try {
                c.close();
                JOptionPane.showMessageDialog(null, "Disconnected from db successful!", "DB Storage Disconnect", JOptionPane.INFORMATION_MESSAGE);
            return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Disconnected from db unsuccessful!", "DB Storage Disconnect", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
                return false;
            }
        else
            return false;
    }
    
    public static boolean addNewFaculty(String psu_id, String first_name, String last_name, String major_college, boolean[] preferred_days) {
        boolean success;
        String query = "INSERT into Faculty(PSU_ID, Last_Name, First_Name, Major, days) values(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.setString (1, psu_id);
            preparedStmt.setString (2, last_name);
            preparedStmt.setString (3, first_name);
            preparedStmt.setString (4, major_college);
            preparedStmt.setInt    (5, Faculty.daysToInt(preferred_days));

            success = preparedStmt.execute();
            JOptionPane.showMessageDialog(null, first_name + "'s information is saved.", "Faculty", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR! FACULTY NOT CREATED!", "Faculty", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        
        return success;
    }

    public static Faculty getFacultyByPSUId(String psu_id) {
        boolean success;
        String query = "SELECT * FROM Faculty WHERE PSU_ID = '" + psu_id + "'";
        
        try {
            Statement st = c.createStatement();
            
            ResultSet rs = st.executeQuery(query);
            
            return new Faculty(rs.getString("PSU_ID"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("major"), Faculty.intToArray(rs.getInt("days")));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR! COULD NOT GRAB INFORMATION!", "Faculty", JOptionPane.ERROR_MESSAGE);
            success = false;
            return null;
        }
        
    }
    
    
    
    
}
