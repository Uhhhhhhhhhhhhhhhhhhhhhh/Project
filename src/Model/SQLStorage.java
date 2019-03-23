/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.time.LocalTime;
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
        String query = "INSERT into Faculty(PSU_ID, Last_Name, First_Name, Major_College, Preferred_Days) values(?, ?, ?, ?, ?)";
        psInsertFaculty = c.prepareStatement(query);
        
        query = "INSERT into ProfessorTimePref(Faculty_PSU_ID, TimePeriod_Period) values (?, ?)";
        psInsertFacultyTimePref = c.prepareStatement(query);
        
        query = "INSERT into timeperiod(period, start_time, end_time) values(?, ?, ?)";
        psInsertTimePeriod = c.prepareStatement(query);
        
        query = "INSERT into room(room_id, building, occupancy, num_of_computers, lab_type) values (?, ?, ?, ?, ?)";
        psInsertRoom = c.prepareStatement(query);
        
        query = "INSERT into course(course_id, sub, course_num, description, units) values(?, ?, ?, ?, ?)";
        psInsertCourse = c.prepareStatement(query);
        
        query = "INSERT into prereqs(course_id, prereq_course_id) values(?, ?)";
        psInsertPreReq = c.prepareStatement(query);
        
        query = "INSERT into section(course_num, course_course_id) values(?, ?)";
        psInsertSection = c.prepareStatement(query);
        
        query = "INSERT into Select(room_room_id, room_building, section_class_num, course_course_id, faculty_psu_id, time_period, days, class_capacity, enrollment, course_type) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        psInsertFinalCourseAssignment = c.prepareStatement(query);
        
        query = "SELECT * from faculty";
        psSelectAllFaculty = c.prepareStatement(query);
        
        query = "SELECT * from professortimepref";
        psSelectAllFacultyTimePref = c.prepareStatement(query);
        
        query = "SELECT * from timeperiod";
        psSelectAllTimePeriod = c.prepareStatement(query);
        
        query = "SELECT * from room";
        psSelectAllRoom = c.prepareStatement(query);
        
        query = "SELECT * from course";
        psSelectAllCourse = c.prepareStatement(query);
        
        query = "SELECT * from prereqs";
        psSelectAllPreReq = c.prepareStatement(query);
        
        query = "SELECT * from section";
        psSelectAllSection = c.prepareStatement(query);
        
        query = "SELECT * from finalcourseassignment";
        psSelectAllFinalCourseAssignment = c.prepareStatement(query);
        
        query = "select * from faculty where psu_id like ?";
        psSelectFacultyByPsuID = c.prepareStatement(query);
        
        query = "select * from faculty where first_name like ?";
        psSelectFacultyByFirstName = c.prepareStatement(query);
        
        query = "select * from faculty where last_name like ?";
        psSelectFacultyByLastName = c.prepareStatement(query);
        
        query = "select * from faculty where last_name like ? and first_name like ?";
        psSelectFacultyByLastAndFirstName = c.prepareStatement(query);
        
        query = "select * from ProfessorTimePref where faculty_psu_id like ?";
        psSelectFacultyTimeByPsuID = c.prepareStatement(query);
        
        query = "select * from ProfessorTimePref where timeperiod_period = ?";
        psSelectTimePeriodByID = c.prepareStatement(query);
        
        query = "select * from room where building like ?";
        psSelectRoomByBuilding = c.prepareStatement(query);
        
        query = "select * from room where room_id like ?";
        psSelectRoomByNumber = c.prepareStatement(query);
        
        query = "select * from room where building like ? and room_id like ?";
        psSelectRoomByBuildingAndNumber = c.prepareStatement(query);
        
        query = "select * from room where lab_type like ?";
        psSelectRoomByLabType = c.prepareStatement(query);
        
        query = "select * from course where course_id like ?";
        psSelectCourseByID = c.prepareStatement(query);
        
        query = "select * from course where sub like ?";
        psSelectCourseBySubject = c.prepareStatement(query);
        
        query = "select * from course where sub like ? and course_num like ?";
        psSelectCourseBySubjectAndNumber = c.prepareStatement(query);
        
        query = "select * from course where course_num like ?";
        psSelectCourseByNumber = c.prepareStatement(query);
        
        query = "select * from course where description like ?";
        psSelectCourseByDescription = c.prepareStatement(query);
        
        query = "select * from course where units = ?";
        psSelectCourseByUnits = c.prepareStatement(query);
        
        query = "select * from prereqs where course_id like ?";
        psSelectPreReqByCourseID = c.prepareStatement(query);
        
        query = "select * from prereqs where course_id like (select course_id from course where sub like ? and course_num like ?)";
        psSelectPreReqByCourseSubjectAndNumber = c.prepareStatement(query);
           
        query = "select * from prereqs where prereq_course_id like ?";
        psSelectPreReqByPreReqCourseID = c.prepareStatement(query);
        
        query = "select * from prereqs where prereq_course_id like (select course_id from course where sub like ? and course_num like ?)";
        psSelectPreReqByPreReqSubjectAndNumber = c.prepareStatement(query);
        
        query = "select * from section where course_course_id like ?";
        psSelectSectionByCourseID = c.prepareStatement(query);
        
        query = "select * from section where course_course_id like (select course_id from course where sub like ? and course_num like ?)";
        psSelectSectionByCourseSubjectAndNumber = c.prepareStatement(query);
        
        query = "select * from finalcourseassignment where room_room_id like ? and room_building like ?";
        psSelectFCAByBuildingAndRoom = c.prepareStatement(query);
        
        query = "select * from finalcourseassignment where course_course_id like (select course_id from course where sub like ? and course_num like ?)";
        psSelectFCAByCourseSubjectAndSection = c.prepareStatement(query);
        
        query = "select * from finalcourseassignment where faculty_psu_id like ?";
        psSelectFCAByCourseFacultyPSUID = c.prepareStatement(query);
        
        query = "select * from finalcourseassignment where faculty_psu_id like (select psu_id from faculty where last_name like ?)";
        psSelectFCAByFacultyLastName = c.prepareStatement(query);
        
        query = "select * from finalcourseassignment where faculty_psu_id like (select psu_id from faculty where first_name like ?)";
        psSelectFCAByFacultyFirstName = c.prepareStatement(query);
        
        query = "select * from finalcourseassignment where faculty_psu_id like (select psu_id from faculty where last_name like ? and first_name like ?)";
        psSelectFCAByFacultyLastAndFirstName = c.prepareStatement(query);
    }
    
    public static boolean ConnectSQLStorage(String ip, String db, String username, String password){
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + db, username, password);
            JOptionPane.showMessageDialog(null, "Connection to db successful!", "DB Storage Connection", JOptionPane.INFORMATION_MESSAGE);
            createPreparedStatements();
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
    
    public static boolean addNewFaculty(String psu_id, String first_name, String last_name, String major_college, boolean[] preferred_days, int[] timePref){
        boolean success;

        try {
            psInsertFaculty.setString (1, psu_id);
            psInsertFaculty.setString (2, last_name);
            psInsertFaculty.setString (3, first_name);
            psInsertFaculty.setString (4, major_college);
            psInsertFaculty.setInt    (5, Faculty.daysToInt(preferred_days));
            
            success = psInsertFaculty.execute();
            JOptionPane.showMessageDialog(null, first_name + "'s information is saved.", "MySQL: Faculty", JOptionPane.INFORMATION_MESSAGE);
            
            for(int i:timePref){ 
                psInsertFacultyTimePref.setString(1, psu_id);
                psInsertFacultyTimePref.setInt(1, i);
                psInsertFacultyTimePref.execute();
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! FACULTY NOT CREATED!\n" + e.getMessage(), "MySQL: Faculty", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        
        return success;
    }
    
    public static boolean addNewTimePeriod(int period, LocalTime start_time, LocalTime end_time) {
        boolean success;
        
        try {
            psInsertTimePeriod.setInt(1, period);
            psInsertTimePeriod.setTime(2, java.sql.Time.valueOf(start_time));
            psInsertTimePeriod.setTime(3, java.sql.Time.valueOf(end_time));
            
            success = psInsertTimePeriod.execute();
            JOptionPane.showMessageDialog(null, start_time.toString() + " - " + end_time.toString() + "'s information is saved.", "MySQL: Time", JOptionPane.INFORMATION_MESSAGE);
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! TIME NOT CREATED!\n" + e.getMessage(), "MySQL: Time", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        
        return success;
    }
    
    public static boolean addNewRoom(String building, String number, int occupancy, int num_comp, String lab) {
        boolean success;
        
        try {
            
            psInsertRoom.setString(1, number);
            psInsertRoom.setString(2, building);
            psInsertRoom.setInt(3, occupancy);
            psInsertRoom.setInt(4, num_comp);
            psInsertRoom.setString(5, lab);
            
            success = psInsertRoom.execute();
            JOptionPane.showMessageDialog(null, building + " " + number + "'s information is saved.", "MySQL: Room", JOptionPane.INFORMATION_MESSAGE);
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Room NOT CREATED!\n" + e.getMessage(), "MySQL: Room", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        
        return success;
    }

    public static boolean addNewCourse() {
        boolean success;
        
        try {
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Course NOT CREATED!\n" + e.getMessage(), "MySQL: Course", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        
        return success;
    }
    
    
    
    
    private static Connection c;
    
    //Insert
    private static PreparedStatement psInsertFaculty;
    private static PreparedStatement psInsertFacultyTimePref;
    private static PreparedStatement psInsertTimePeriod;
    private static PreparedStatement psInsertRoom;
    private static PreparedStatement psInsertCourse;
    private static PreparedStatement psInsertPreReq;
    private static PreparedStatement psInsertSection;
    private static PreparedStatement psInsertFinalCourseAssignment;
    
    //Select All
    private static PreparedStatement psSelectAllFaculty;
    private static PreparedStatement psSelectAllFacultyTimePref;
    private static PreparedStatement psSelectAllTimePeriod;
    private static PreparedStatement psSelectAllRoom;
    private static PreparedStatement psSelectAllCourse;
    private static PreparedStatement psSelectAllPreReq;
    private static PreparedStatement psSelectAllSection;
    private static PreparedStatement psSelectAllFinalCourseAssignment;
    
    //Select By Topics
    // Faculty
    private static PreparedStatement psSelectFacultyByPsuID;
    private static PreparedStatement psSelectFacultyByFirstName;
    private static PreparedStatement psSelectFacultyByLastName;
    private static PreparedStatement psSelectFacultyByLastAndFirstName;
    
    //Faculty Time
    private static PreparedStatement psSelectFacultyTimeByPsuID;
    
    //Time Period
    private static PreparedStatement psSelectTimePeriodByID;
    
    //Room
    private static PreparedStatement psSelectRoomByBuilding;
    private static PreparedStatement psSelectRoomByNumber;
    private static PreparedStatement psSelectRoomByBuildingAndNumber;
    private static PreparedStatement psSelectRoomByLabType;
    
    //Course
    private static PreparedStatement psSelectCourseByID;
    private static PreparedStatement psSelectCourseBySubject;
    private static PreparedStatement psSelectCourseBySubjectAndNumber;
    private static PreparedStatement psSelectCourseByNumber;
    private static PreparedStatement psSelectCourseByDescription;
    private static PreparedStatement psSelectCourseByUnits;
    
    //PreReq
    private static PreparedStatement psSelectPreReqByCourseID;
    private static PreparedStatement psSelectPreReqByCourseSubjectAndNumber;
    private static PreparedStatement psSelectPreReqByPreReqCourseID;
    private static PreparedStatement psSelectPreReqByPreReqSubjectAndNumber;
    
    //Section
    private static PreparedStatement psSelectSectionByCourseID;
    private static PreparedStatement psSelectSectionByCourseSubjectAndNumber;
    
    //FCA
    private static PreparedStatement psSelectFCAByBuildingAndRoom;
    private static PreparedStatement psSelectFCAByCourseSubjectAndSection;
    private static PreparedStatement psSelectFCAByCourseFacultyPSUID;
    private static PreparedStatement psSelectFCAByFacultyLastName;
    private static PreparedStatement psSelectFCAByFacultyFirstName;
    private static PreparedStatement psSelectFCAByFacultyLastAndFirstName;
    
}
