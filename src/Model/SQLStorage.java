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
    private static PreparedStatement psInsFaculty;
    private static PreparedStatement psInsRoom;
    private static PreparedStatement psInsCourse;
    private static PreparedStatement psInsPreReq;
    private static PreparedStatement psInsSection;
    private static PreparedStatement psInsTimePeriod;
    private static PreparedStatement psInsProfTimePref;
    private static PreparedStatement psInsFinalCourseAssignment;
    private static PreparedStatement psGetFaculty;
    private static PreparedStatement psGetRooms;
    private static PreparedStatement psGetCourses;
    private static PreparedStatement psGetPreReqs;
    private static PreparedStatement psGetTimePeriod;
    private static PreparedStatement psGetProfTimePrefs;
    private static PreparedStatement psGetFinalCourseAssignments;
    
    public static void createPreparedStatements(Connection cnIn) throws SQLException {
    String query = "INSERT into Faculty(PSU_ID, Last_Name, First_Name, Major, days)" + "values(?, ?, ?, ?, ?)";
    psInsFaculty = c.prepareStatement(query);
    
    query = "INSERT into Room(building, room_id, occupancy, num_computers, lab_type)" + "values(?, ?, ?, ?, ?)";
    psInsRoom = c.prepareStatement(query);
    
    query = "INSERT into Course(course_id, subject, course_num, description, units, rap_priority)" + "values(?, ?, ?, ?, ?, ?)";
    psInsCourse = c.prepareStatement(query);
    
    query = "INSERT into Prereqs(course_id, prereq_id)" + "values(?, ?)";
    psInsPreReq = c.prepareStatement(query);
    
    query = "INSERT into Sections(class_num, course_course_id)" + "values(?, ?)";
    psInsSection = c.prepareStatement(query);
    
    query = "INSERT into Time_Period(building, room_id, occupancy, num_computers, lab_type)" + "values(?, ?, ?, ?, ?)";
    psInsTimePeriod = c.prepareStatement(query);
    
    query = "INSERT into Professor_Time_Pref(building, room_id, occupancy, num_computers, lab_type)" + "values(?, ?, ?, ?, ?)";
    psInsProfTimePref = c.prepareStatement(query);
    
    query = "INSERT into Final_Course_Assignment(building, room_id, occupancy, num_computers, lab_type)" + "values(?, ?, ?, ?, ?)";
    psInsFinalCourseAssignment = c.prepareStatement(query);
    
    }
    
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
        
        try {
            psInsFaculty.setString (1, psu_id);
            psInsFaculty.setString (2, last_name);
            psInsFaculty.setString (3, first_name);
            psInsFaculty.setString (4, major_college);
            psInsFaculty.setInt    (5, Faculty.daysToInt(preferred_days));

            success = psInsFaculty.execute();
            JOptionPane.showMessageDialog(null, first_name + "'s information is saved.", "Faculty", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR! FACULTY NOT CREATED!", "Faculty", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        
        return success;
    }
    public static boolean addNewRoom(String building, String room_id, int occupancy, int num_computers, String lab_type) {
        boolean success;
        
        try {
            psInsRoom.setString (1, building);
            psInsRoom.setString (2, room_id);
            psInsRoom.setInt (3, occupancy);
            psInsRoom.setInt (4, num_computers);
            psInsRoom.setString (5, lab_type);
            
            success = psInsRoom.execute();
            JOptionPane.showMessageDialog(null, building + room_id + " information is saved.", "Room", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR! ROOM NOT CREATED!", "Room", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        
        return success;
    }
    public static boolean addNewCourse(String course_id, String subject, String course_num, String description, int units, int rap_priority) {
        boolean success;
        
        try {
            psInsCourse.setString (1, course_id);
            psInsCourse.setString (2, subject);
            psInsCourse.setString (3, course_num);
            psInsCourse.setString (4, description);
            psInsCourse.setInt (5, units);
            psInsCourse.setInt (6, rap_priority);
            
            success = psInsCourse.execute();
            JOptionPane.showMessageDialog(null, subject + course_id + " information is saved.", "Room", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR! COURSE NOT CREATED!", "Course", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        return success;
    }
    
    
    
}
