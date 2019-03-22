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
    
    
    
    private static void createPreparedStatements() throws SQLException {
        String query = "INSERT into faculty(PSU_ID, Last_Name, First_Name, Major_College, Preferred_Days) values(?, ?, ?, ?, ?)";
        psInsertFaculty = c.prepareStatement(query);
        
        query = "INSERT into ";
        
    }
    
    public static boolean ConnectSQLStorage(String ip, String db, String username, String password){
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + db, username, password);
            JOptionPane.showMessageDialog(null, "Connection to db successful!", "DB Storage Connection", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Connection to db unsuccessful!", "DB Storage Connection", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean DisconnectSQLStorage(){
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

        try {
            psInsertFaculty.setString (1, psu_id);
            psInsertFaculty.setString (2, last_name);
            psInsertFaculty.setString (3, first_name);
            psInsertFaculty.setString (4, major_college);
            psInsertFaculty.setInt    (5, Faculty.daysToInt(preferred_days));

            success = psInsertFaculty.execute();
            JOptionPane.showMessageDialog(null, first_name + "'s information is saved.", "MySQL: Faculty", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! FACULTY NOT CREATED!\n" + e.getMessage(), "MySQL: Faculty", JOptionPane.ERROR_MESSAGE);
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
    private static Connection c;
    private static PreparedStatement psInsertFaculty;
    
    
}
