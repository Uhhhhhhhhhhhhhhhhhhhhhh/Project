/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
        try {
            return !c.isClosed();
        } catch (Exception ex) {
            return false;
        }
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
        
        query = "INSERT into timeperiod(start_time, end_time) values(?, ?)";
        psInsertTimePeriod = c.prepareStatement(query);
        
        query = "INSERT into room(room_id, building, occupancy, num_of_computers, lab_type) values (?, ?, ?, ?, ?)";
        psInsertRoom = c.prepareStatement(query);
        
        query = "INSERT into course(course_id, sub, course_num, course_name, description, units) values(?, ?, ?, ?, ?, ?)";
        psInsertCourse = c.prepareStatement(query);
        
        query = "INSERT into prereqs(course_id, prereq_course_id) values(?, ?)";
        psInsertPreReq = c.prepareStatement(query);
        
        query = "INSERT into prereqs(course_id, prereq_course_id) values(select course_id from course where sub like ? and course_num like ?, select course_id from course where sub like ? and course_num like ?)";
        psInsertPreReqWithSelects = c.prepareStatement(query);
        
        query = "INSERT into section(class_num, course_course_id) values(?, ?)";
        psInsertSection = c.prepareStatement(query);
        
        query = "INSERT into finalcourseassignment(room_room_id, room_building, section_num, course_course_id, faculty_psu_id, time_period, days, start_date, end_date, class_capacity, enrollment, course_type) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        psInsertFinalCourseAssignment = c.prepareStatement(query);
        
        query = "INSERT into finalcourseassignment(room_room_id, room_building, section_class_num, course_course_id, faculty_psu_id, time_period, days, start_date, end_date, class_capacity, enrollment, course_type) values(?, ?, ?, (select course_id from course where sub like ? and course_num like ?), ?, ?, ?, ?, ?, ?)";
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
        
        query = "select * from timeperiod where period = ?";
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
        
        query = "select * from finalcourseassignment where course_course_id like ? AND Section_Num like ?";
        psSelectFCAByCourseAndSection = c.prepareStatement(query);
        
        query = "select * from finalcourseassignment where faculty_psu_id like ?";
        psSelectFCAByCourseFacultyPSUID = c.prepareStatement(query);
        
        query = "select * from finalcourseassignment where faculty_psu_id like (select psu_id from faculty where last_name like ?)";
        psSelectFCAByFacultyLastName = c.prepareStatement(query);
        
        query = "select * from finalcourseassignment where faculty_psu_id like (select psu_id from faculty where first_name like ?)";
        psSelectFCAByFacultyFirstName = c.prepareStatement(query);
        
        query = "select * from finalcourseassignment where faculty_psu_id like (select psu_id from faculty where last_name like ? and first_name like ?)";
        psSelectFCAByFacultyLastAndFirstName = c.prepareStatement(query);
        
        query = "select sub, course_num from course where course_id like ?";
        psSelectSubNumByCourseId = c.prepareStatement(query);
        
        query = "select exists(select * from faculty where Last_Name like ? and first_name like ?) as result";
        psConflictFaculty = c.prepareStatement(query);
        
    }
    
    public static boolean addNewFaculty(String psu_id, String first_name, String last_name, String major_college, boolean[] preferred_days, int[] timePref){
        boolean success;

        try {
            
            //Conflict Detection w/ First & Last Name
            psConflictFaculty.setString(1, last_name);
            psConflictFaculty.setString(2, first_name);
            
            ResultSet rsConflict = psConflictFaculty.executeQuery();
            
            int result = rsConflict.getInt(0);
            if(result > 0)
                throw new Exception("Data already found");
            
            psInsertFaculty.setString (1, psu_id);
            psInsertFaculty.setString (2, last_name);
            psInsertFaculty.setString (3, first_name);
            psInsertFaculty.setString (4, major_college);
            psInsertFaculty.setInt    (5, daysToInt(preferred_days));
            
            success = psInsertFaculty.execute();
            JOptionPane.showMessageDialog(null, first_name + "'s information is saved.", "MySQL: Faculty", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! FACULTY NOT CREATED!\n" + e.getMessage(), "MySQL: Faculty", JOptionPane.ERROR_MESSAGE);
            success = false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR! FACULTY NOT CREATED!\n" + e.getMessage(), "Duplicate: Faculty", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        
        if(success) {
            try {
                for(int i:timePref){ 
                    psInsertFacultyTimePref.setString(1, psu_id);
                    psInsertFacultyTimePref.setInt(2, i + 1);
                    psInsertFacultyTimePref.execute();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR! FACULTY TIME NOT CREATED!\n" + e.getMessage(), "MySQL: Faculty Time", JOptionPane.ERROR_MESSAGE);
                success = false;
            }
        }
        return success;
    }
    
    public static boolean addNewTime(LocalTime start, LocalTime end) {
        boolean success;
        
        try {
            
            // Conflict Detection with Time Period
            
            psInsertTimePeriod.setTime(1, java.sql.Time.valueOf(start));
            psInsertTimePeriod.setTime(2, java.sql.Time.valueOf(end));
            
            success = psInsertTimePeriod.execute();
            JOptionPane.showMessageDialog(null, start.toString() + " - " + end.toString() + " time period saved", "MySQL: Time", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! TIME NOT CREATED!\n" + e.getMessage(), "MySQL: Time", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        
        return success;
    }
    
    public static boolean addNewRoom(String building, String number, int occupancy, int num_comp, String lab) {
        boolean success;
        
        try { //No Conflict Detection Needed            
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
    
    public static boolean addNewCourse(String course_id, String sub, String num, String name, String description, double units) {
        boolean success;
        
        try {
            
            //Conflict Detection
            
            psInsertCourse.setString(1, course_id);
            psInsertCourse.setString(2, sub);
            psInsertCourse.setString(3, num);
            psInsertCourse.setString(4, name);
            psInsertCourse.setString(5, description);
            psInsertCourse.setDouble(6, units);
            
            success = psInsertCourse.execute();
            JOptionPane.showMessageDialog(null, sub + " " + num + "'s information is saved.", "MySQL: Course", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Course NOT CREATED!\n" + e.getMessage(), "MySQL: Course", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        
        return success;
    }
    
    public static boolean addNewCourse(String course_id, String sub, String num, String name, String description, double units, List<String> prereqs) {
        boolean success;
        
        try {
            
            //Conflict Detection with Sub & Num
            
            psInsertCourse.setString(1, course_id);
            psInsertCourse.setString(2, sub);
            psInsertCourse.setString(3, num);
            psInsertCourse.setString(4, name);
            psInsertCourse.setString(5, description);
            psInsertCourse.setDouble(6, units);
            
            success = psInsertCourse.execute();
            JOptionPane.showMessageDialog(null, sub + " " + num + "'s information is saved.", "MySQL: Course", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Course NOT CREATED!\n" + e.getMessage(), "MySQL: Course", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        if(success)
            try {
                for(String pr:prereqs){ 
                    psInsertPreReq.setString(1, course_id);
                    psInsertPreReq.setString(2, pr);
                    psInsertPreReq.execute();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR! PreReq NOT CREATED!\n" + e.getMessage(), "MySQL: PreReq", JOptionPane.ERROR_MESSAGE);
                success = false;
            }
        
        return success;
    }
    
    public static String getCourseBySubAndNum(String sub, String num) {
        try {
            psSelectCourseBySubjectAndNumber.setString(1, sub);
            psSelectCourseBySubjectAndNumber.setString(2, num);
            
            ResultSet rsSelectCourseBySubAndNum = psSelectCourseBySubjectAndNumber.executeQuery();
            
            rsSelectCourseBySubAndNum.beforeFirst();
            rsSelectCourseBySubAndNum.next();
            
            return rsSelectCourseBySubAndNum.getString("course_id");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Course not found!\n" + e.getMessage(), "MySQL: Course", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
    }
    
    public static ArrayList<ArrayList> getTimePeriods() {
        try {
            ResultSet rsSelectAllTime = psSelectAllTimePeriod.executeQuery();

            ArrayList<ArrayList> times = new ArrayList<>();
            times.add(new ArrayList<>());
            times.add(new ArrayList<>());
            times.add(new ArrayList<>());
            
            while(rsSelectAllTime.next()) {
                times.get(0).add(rsSelectAllTime.getInt("period"));
                times.get(1).add(rsSelectAllTime.getTime("start_time").toLocalTime());
                times.get(2).add(rsSelectAllTime.getTime("end_time").toLocalTime());
            }
            
            return times;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Course not found!\n" + e.getMessage(), "MySQL: Time", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static ArrayList<ArrayList> getFaculty() {
        try {
            ResultSet rsSelectAllFaculty = psSelectAllFaculty.executeQuery();

            ArrayList<ArrayList> faculties = new ArrayList<>();
            faculties.add(new ArrayList<>());
            faculties.add(new ArrayList<>());
            faculties.add(new ArrayList<>());
            
            while(rsSelectAllFaculty.next()) {
                faculties.get(0).add(rsSelectAllFaculty.getString("psu_id"));
                faculties.get(1).add(rsSelectAllFaculty.getString("last_name"));
                faculties.get(2).add(rsSelectAllFaculty.getString("first_name"));
            }
            
            return faculties;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Faculty not found!\n" + e.getMessage(), "MySQL: Faculty", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static ArrayList<ArrayList> getRooms() {
        try {
            ResultSet rsSelectAllRooms = psSelectAllRoom.executeQuery();

            ArrayList<ArrayList> rooms = new ArrayList<>();
            rooms.add(new ArrayList<>());
            rooms.add(new ArrayList<>());
            rooms.add(new ArrayList<>());
            rooms.add(new ArrayList<>());
            
            while(rsSelectAllRooms.next()) {
                rooms.get(0).add(rsSelectAllRooms.getString("building"));
                rooms.get(1).add(rsSelectAllRooms.getString("room_id"));
                rooms.get(2).add(rsSelectAllRooms.getString("Lab_Type"));
                rooms.get(3).add(rsSelectAllRooms.getString("occupancy"));                
            }
            
            return rooms;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Faculty not found!\n" + e.getMessage(), "MySQL: Faculty", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static ArrayList<Object> getSingleCourse(String course_id) {
        try {
            psSelectCourseByID.setString(1, course_id);
            
            ResultSet rsSelectAllCourses = psSelectCourseByID.executeQuery();

            ArrayList<Object> courses = new ArrayList<>();
            
            while(rsSelectAllCourses.next()) {
                courses.add(rsSelectAllCourses.getString("sub"));
                courses.add(rsSelectAllCourses.getString("course_num"));
                courses.add(rsSelectAllCourses.getString("course_id"));
                courses.add(rsSelectAllCourses.getString("course_name"));
                courses.add(rsSelectAllCourses.getString("Description"));
                courses.add(rsSelectAllCourses.getDouble("Units"));
            }
            
            return courses;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Faculty not found!\n" + e.getMessage(), "MySQL: Faculty", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static ArrayList<ArrayList> getCourses() {
        try {
            ResultSet rsSelectAllCourses = psSelectAllCourse.executeQuery();

            ArrayList<ArrayList> courses = new ArrayList<>();
            courses.add(new ArrayList<>());
            courses.add(new ArrayList<>());
            courses.add(new ArrayList<>());
            courses.add(new ArrayList<>());
            courses.add(new ArrayList<>());
            courses.add(new ArrayList<>());
            
            while(rsSelectAllCourses.next()) {
                courses.get(0).add(rsSelectAllCourses.getString("sub"));
                courses.get(1).add(rsSelectAllCourses.getString("course_num"));
                courses.get(2).add(rsSelectAllCourses.getString("course_id"));
                courses.get(3).add(rsSelectAllCourses.getString("course_name"));
                courses.get(4).add(rsSelectAllCourses.getString("Description"));
                courses.get(5).add(rsSelectAllCourses.getDouble("Units"));
            }
            
            return courses;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Faculty not found!\n" + e.getMessage(), "MySQL: Faculty", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static boolean addNewFCA(String room_num, String room_building, String session_num, String course_id, String faculty_id, int time_period, int days, LocalDate start_date, LocalDate end_date, int capacity, int enrollment, String type) {
        boolean success;
        
        try {
            psInsertFinalCourseAssignment.setString(1, room_num);
            psInsertFinalCourseAssignment.setString(2, room_building);
            psInsertFinalCourseAssignment.setString(3, session_num);
            psInsertFinalCourseAssignment.setString(4, course_id);
            psInsertFinalCourseAssignment.setString(5, faculty_id);
            psInsertFinalCourseAssignment.setInt(6, time_period);
            psInsertFinalCourseAssignment.setInt(7, days);
            psInsertFinalCourseAssignment.setDate(8, Date.valueOf(start_date));
            psInsertFinalCourseAssignment.setDate(9, Date.valueOf(end_date));
            psInsertFinalCourseAssignment.setInt(10, capacity);
            psInsertFinalCourseAssignment.setInt(11, enrollment);
            psInsertFinalCourseAssignment.setString(12, type);
            
            success = psInsertFinalCourseAssignment.execute();
            JOptionPane.showMessageDialog(null, "FCA information is saved.", "MySQL: FCA", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! FCA NOT CREATED!\n" + e.getMessage(), "MySQL: FCA", JOptionPane.ERROR_MESSAGE);
            success = false;
        }
        
        return success;
    }
    
    public static ArrayList<Object> getProfPrefTimes(String psu_id) {
        try {
            psSelectFacultyTimeByPsuID.setString(1, psu_id);
            ResultSet rsTimesOfFaculty = psSelectFacultyTimeByPsuID.executeQuery();
            
            ArrayList<Object> times = new ArrayList<>();
            
            while(rsTimesOfFaculty.next()) {
                times.add(rsTimesOfFaculty.getInt("TimePeriod_Period"));                
            }
            
            return times;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Time not found!\n" + e.getMessage(), "MySQL: Time", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
    public static void resetDB() {
        String s = "";
        StringBuffer sb = new StringBuffer();
        try {
            FileReader fr = new FileReader(new File("IST261DBTables.sql"));

            BufferedReader br = new BufferedReader(fr);

            while((s = br.readLine()) != null) {
                sb.append(s);
            }
            
            br.close();
            
            String[] inst = sb.toString().split(";");
            
            Statement st = c.createStatement();
 
            for(int i = 0; i<inst.length; i++) {
                if(!inst[i].trim().equals("")) {
                    st.executeUpdate(inst[i]);
                    //System.out.println(">>"+inst[i]);
                }
            }
   
            JOptionPane.showMessageDialog(null, "DB reset!", "MySQL: Reset", JOptionPane.INFORMATION_MESSAGE);
        } catch(HeadlessException | IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! DB not reset!\n" + e.getMessage(), "MySQL: Reset", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ArrayList<String> getCoursePrereqs(String course_id) {
        try {
            psSelectPreReqByCourseID.setString(1, course_id);
            ArrayList<String> prereqs = new ArrayList<>();
            
            ResultSet rsPreReqs = psSelectPreReqByCourseID.executeQuery();
            
            while(rsPreReqs.next()) {
                prereqs.add(rsPreReqs.getString("prereq_course_id"));
            }
            return prereqs;
            
        } catch (SQLException e) {
            Logger.getLogger(SQLPreparedStatements.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public static ArrayList<Object> getSingleFaculty(String psu_id) {
        try {
            psSelectFacultyByPsuID.setString(1, psu_id);
            
            ResultSet rsSelectSingleFaculty = psSelectFacultyByPsuID.executeQuery();

            ArrayList<Object> courses = new ArrayList<>();
            
            while(rsSelectSingleFaculty.next()) {
                courses.add(rsSelectSingleFaculty.getString("psu_id"));
                courses.add(rsSelectSingleFaculty.getString("last_name"));
                courses.add(rsSelectSingleFaculty.getString("first_name"));
                courses.add(rsSelectSingleFaculty.getString("major_college"));
                courses.add(rsSelectSingleFaculty.getInt("preferred_days"));
            }
            
            return courses;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Faculty not found!\n" + e.getMessage(), "MySQL: Faculty", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static ArrayList<Object> getSingleRoom(String building, String number) {
        try {
            psSelectRoomByBuildingAndNumber.setString(1, building);
            psSelectRoomByBuildingAndNumber.setString(2, number);
            
            ResultSet rsSelectSingleRoom = psSelectRoomByBuildingAndNumber.executeQuery();
            
            ArrayList<Object> rooms = new ArrayList<>();
            
            while(rsSelectSingleRoom.next()) {
                rooms.add(rsSelectSingleRoom.getString("building"));
                rooms.add(rsSelectSingleRoom.getString("room_id"));
                rooms.add(rsSelectSingleRoom.getInt("occupancy"));
                rooms.add(rsSelectSingleRoom.getInt("num_of_computers"));
                rooms.add(rsSelectSingleRoom.getString("lab_type"));
            }
            
            return rooms;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Room not found!\n" + e.getMessage(), "MySQL: Faculty", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
    }
    
    public static ArrayList<Object> getSingleTime(int period) {
        try {
            psSelectTimePeriodByID.setInt(1, period);
            
            ResultSet rsSelectSingleTime = psSelectTimePeriodByID.executeQuery();
            
            ArrayList<Object> times = new ArrayList<>();
            
            while(rsSelectSingleTime.next()) {
                times.add(rsSelectSingleTime.getInt("period"));
                times.add(rsSelectSingleTime.getTime("start_time"));
                times.add(rsSelectSingleTime.getTime("end_time"));
            }
            
            return times;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! Time not found!\n" + e.getMessage(), "MySQL: Faculty", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static ArrayList<ArrayList> getFCA() {
        try {
            ResultSet rsSelectAllFaculty = psSelectAllFinalCourseAssignment.executeQuery();

            ArrayList<ArrayList> fcas = new ArrayList<>();
            for(int i = 0; i < 12; i++)
                fcas.add(new ArrayList<>());
            
            
            
            while(rsSelectAllFaculty.next()) {
                fcas.get(0).add(rsSelectAllFaculty.getString("room_room_id"));
                fcas.get(1).add(rsSelectAllFaculty.getString("room_building"));
                fcas.get(2).add(rsSelectAllFaculty.getString("section_num"));
                fcas.get(3).add(rsSelectAllFaculty.getString("course_course_id"));
                fcas.get(4).add(rsSelectAllFaculty.getString("faculty_psu_id"));
                fcas.get(5).add(rsSelectAllFaculty.getInt("time_period"));
                fcas.get(6).add(rsSelectAllFaculty.getDate("start_date"));
                fcas.get(7).add(rsSelectAllFaculty.getDate("end_date"));
                fcas.get(8).add(rsSelectAllFaculty.getInt("days"));
                fcas.get(9).add(rsSelectAllFaculty.getInt("class_capacity"));
                fcas.get(10).add(rsSelectAllFaculty.getInt("enrollment"));
                fcas.get(11).add(rsSelectAllFaculty.getString("course_type"));
            }
            
            return fcas;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! FCA not found!\n" + e.getMessage(), "MySQL: FCA", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static ArrayList<Object> getSingleFCA(String course_id, String section_num) {
        try {
            psSelectFCAByCourseAndSection.setString(1, course_id);
            psSelectFCAByCourseAndSection.setString(2, section_num);
            ResultSet rsSelectSingleFCA = psSelectFCAByCourseAndSection.executeQuery();
            ArrayList<Object> fca = new ArrayList<>();
            while(rsSelectSingleFCA.next()) {
                fca.add(rsSelectSingleFCA.getString("Room_Room_ID"));
                fca.add(rsSelectSingleFCA.getString("Room_building"));
                fca.add(rsSelectSingleFCA.getString("section_num"));
                fca.add(rsSelectSingleFCA.getString("course_course_id"));
                fca.add(rsSelectSingleFCA.getString("faculty_psu_id"));
                fca.add(rsSelectSingleFCA.getInt("time_period"));
                fca.add(rsSelectSingleFCA.getDate("start_date"));
                fca.add(rsSelectSingleFCA.getDate("end_date"));
                fca.add(rsSelectSingleFCA.getInt("days"));
                fca.add(rsSelectSingleFCA.getInt("class_capacity"));
                fca.add(rsSelectSingleFCA.getInt("enrollment"));
                fca.add(rsSelectSingleFCA.getString("course_type"));
            }
            
            return fca;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR! FCA not found!\n" + e.getMessage(), "MySQL: FCA", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static String getSubNameByCourseId(String course_id) {
        String courseInfo = "";
        
        try {
            psSelectSubNumByCourseId.setString(1, course_id);
            
            ResultSet rsSelectSubNum = psSelectSubNumByCourseId.executeQuery();
            ArrayList<Object> course = new ArrayList<>();
            while(rsSelectSubNum.next()) {
                course.add(rsSelectSubNum.getString("sub"));
                course.add(rsSelectSubNum.getString("course_num"));
            }
            
            courseInfo = course.get(0) + " " + course.get(1);
            
            return courseInfo;
        } catch (SQLException ex) {
            Logger.getLogger(SQLPreparedStatements.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return courseInfo;
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
    private static PreparedStatement psSelectFCAByCourseAndSection;

    //Other
    private static PreparedStatement psSelectSubNumByCourseId;
    
    
    //Conflict
    private static PreparedStatement psConflictFaculty;
}
