/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Derek
 */
public class SQLPreparedStatements {
    
    private static Connection c;
    
    
    public static boolean checkConnection(){
        return c == null;
    }
    
    public static void connectToDB(String ip, String db, String username, String password) {
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + db, username, password);
            JOptionPane.showMessageDialog(null, "Connection to db successful!", "DB Storage Connection", JOptionPane.INFORMATION_MESSAGE);
            createPreparedStatements();
        } catch(HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection to db unsuccessful!", "DB Storage Connection", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
    
    public static void disconnectFromDB() {
        if(c != null) {
            try {
                c.close();
                JOptionPane.showMessageDialog(null, "Disconnected from db successful!", "DB Storage Disconnect", JOptionPane.INFORMATION_MESSAGE);
                c = null;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Disconnected from db unsuccessful!", "DB Storage Disconnect", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        }
    }
    
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
        
        query = "INSERT into prereqs(course_id, prereq_course_id) values(select course_id from course where sub like ? and course_num like ?, select course_id from course where sub like ? and course_num like ?)";
        psInsertPreReqWithSelects = c.prepareStatement(query);
        
        query = "INSERT into section(class_num, course_course_id) values(?, ?)";
        psInsertSection = c.prepareStatement(query);
        
        query = "INSERT into finalcourseassignment(room_room_id, room_building, section_class_num, course_course_id, faculty_psu_id, time_period, days, class_capacity, enrollment, course_type) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        psInsertFinalCourseAssignment = c.prepareStatement(query);
        
        query = "INSERT into finalcourseassignment(room_room_id, room_building, section_class_num, course_course_id, faculty_psu_id, time_period, days, class_capacity, enrollment, course_type) values(?, ?, ?, (select course_id from course where sub like ? and course_num like ?), ?, ?, ?, ?, ?, ?)";
        psInsertFinalCourseAssignmentWIthSelects = c.prepareStatement(query);
        
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
    
    public static boolean addNewFaculty(String psu_id, String first_name, String last_name, String major_college, boolean[] preferred_days, int[] timePref){
        boolean success;

        try {
            psInsertFaculty.setString (1, psu_id);
            psInsertFaculty.setString (2, last_name);
            psInsertFaculty.setString (3, first_name);
            psInsertFaculty.setString (4, major_college);
            psInsertFaculty.setInt    (5, daysToInt(preferred_days));
            
            success = psInsertFaculty.execute();
            JOptionPane.showMessageDialog(null, first_name + "'s information is saved.", "MySQL: Faculty", JOptionPane.INFORMATION_MESSAGE);
            
            for(int i:timePref){ 
                psInsertFacultyTimePref.setString(1, psu_id);
                psInsertFacultyTimePref.setInt(1, i);
                psInsertFacultyTimePref.execute();
            }
            
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
    
    
    
    public static int daysToInt(boolean[] days) {
        //MTWTFSS
        int mon, tues, wed, thurs, fri, sat, sun;
        mon = tues = wed = thurs = fri = sat = sun = 0;
        
        if(days[0])
            mon = 1000000;
        if(days[1])
            tues = 100000;
        if(days[2])
            wed = 10000;
        if(days[3])
            thurs = 1000;
        if(days[4])
            fri = 100;
        if(days[5])
            sat = 10;
        if(days[6])
            sun = 1;
        
        return mon + tues + wed + thurs + fri + sat + sun;
    }
    
    public static boolean[] intToArray(int days) {
        
        int sun = days % 10;
        days /= 10;
        
        int sat = days % 10;
        days /= 10;
        
        int fri = days % 10;
        days /= 10;
        
        int thurs = days % 10;
        days /= 10;
        
        int wed = days % 10;
        days /= 10;
        
        int tues = days % 10;
        days /= 10;
        
        int mon = days % 10;
        days /= 10;
        
        return new boolean[]{mon == 1, tues  == 1, wed  == 1, thurs  == 1, fri  == 1, sat  == 1, sun  == 1};
    }
    
    //Insert
    private static PreparedStatement psInsertFaculty;
    private static PreparedStatement psInsertFacultyTimePref;
    private static PreparedStatement psInsertTimePeriod;
    private static PreparedStatement psInsertRoom;
    private static PreparedStatement psInsertCourse;
    private static PreparedStatement psInsertPreReq;
    private static PreparedStatement psInsertPreReqWithSelects;
    private static PreparedStatement psInsertSection;
    private static PreparedStatement psInsertFinalCourseAssignment;
    private static PreparedStatement psInsertFinalCourseAssignmentWIthSelects;
    
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
