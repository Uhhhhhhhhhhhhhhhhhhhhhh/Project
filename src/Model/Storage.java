package Model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Date: Feb 25, 2019
 *
 * @author dsd5227
 */
public class Storage {
    
    //TODO: Sort Lists after Adding new Items!!!

    private static ArrayList<Student> alStudent = new ArrayList<>();
    private static ArrayList<Room> alRoom = new ArrayList<>();
    private static ArrayList<Faculty> alFaculty = new ArrayList<>();
    private static ArrayList<Section> alSection = new ArrayList<>();
    private static ArrayList<Course> alCourse = new ArrayList<>();
    private static ArrayList<Time_Period> alTime = new ArrayList<>();
    private static ArrayList<Final_Course_Assignment> alFCA = new ArrayList<>();

    public static boolean addNewStudent(String psu_id, String first_name, String last_name, String major, int credits) {
        Student s = new Student(psu_id, first_name, last_name, major, credits);
        boolean add = alStudent.add(s);
        String message;
        if(add) {
            message = s.getFirst_name() + "'s information is saved.";
            Collections.sort(alStudent);
        } else {
            message = "ERROR! STUDENT NOT CREATED!";
        }
        JOptionPane.showMessageDialog(null, message, "Student", JOptionPane.INFORMATION_MESSAGE);
        
        return true;
    }

    public static boolean addNewStudent(String psu_id, String first_name, String last_name, String major, String minor, int credits) {
        Student s = new Student(psu_id, first_name, last_name, major, minor, credits);
        boolean add = alStudent.add(s);
        String message;
        if(add) {
            message = s.getFirst_name() + "'s information is saved.";
            Collections.sort(alStudent);
        } else {
            message = "ERROR! STUDENT NOT CREATED!";
        }
        JOptionPane.showMessageDialog(null, message, "Student", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public static Student getStudent(int index) {
        if (index < 0 || index > alStudent.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Student", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alStudent.get(index);
    }

    public static boolean addNewFaculty(String psu_id, String first_name, String last_name, String major_college, boolean[] preferred_days) {
        Faculty f = new Faculty(psu_id, first_name, last_name, major_college, preferred_days);
        boolean add = alFaculty.add(f);
        String message;
        if(add) {
            message = f.getFirst_name() + "'s information is saved.";
            Collections.sort(alFaculty);
        } else {
            message = "ERROR! FACULTY NOT CREATED!";
        }
        JOptionPane.showMessageDialog(null, message, "Faculty", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public static Faculty getFaculty(int index) {
        if (index < 0 || index > alFaculty.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Faculty", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alFaculty.get(index);
    }
    
    public static boolean addNewRoom(String building, String room_id, int occupancy, int computers, String lab_type){
        Room r = new Room(building, room_id, occupancy, computers, lab_type);
        boolean add = alRoom.add(r);
        String message;
        if(add) {
            message = r.toEventString() + " saved.";
            Collections.sort(alRoom);
        } else {
            message = "ERROR! ROOM NOT CREATED!";
        }
        JOptionPane.showMessageDialog(null, message, "Room", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public static Room getRoom(int index) {
        if (index < 0 || index > alRoom.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Room", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alRoom.get(index);
    }
    
    public static boolean addNewCourse(String course_id, String subject, String course_num, char session, String name, String description, double units){
        Course c = new Course(course_id, subject, course_num, session, name, description, units);
        boolean add = alCourse.add(c);
        String message;
        if(add) {
            message = c.toEventString() + " saved.";
            Collections.sort(alCourse);
        } else {
            message = "ERROR! COURSE NOT CREATED!";
        }
        JOptionPane.showMessageDialog(null, message, "Course", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public static boolean addNewCourse(String course_id, String subject, String course_num, char session, String name, String description, double units, int recommended_academic_planner_priority){
        Course c = new Course(course_id, subject, course_num, session, name, description, units, recommended_academic_planner_priority);
        boolean add = alCourse.add(c);
        String message;
        if(add) {
            message = c.toEventString() + " saved.";
            Collections.sort(alCourse);
        } else {
            message = "ERROR! COURSE NOT CREATED!";
        }
        JOptionPane.showMessageDialog(null, message, "Course", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public static boolean addNewCourse(String course_id, String subject, String course_num, char session, String name, String description, double units, Course[] prereqs){
        Course c = new Course(course_id, subject, course_num, session, name, description, units, prereqs);
        boolean add = alCourse.add(c);
        String message;
        if(add) {
            message = c.toEventString() + " saved.";
            Collections.sort(alCourse);
        } else {
            message = "ERROR! COURSE NOT CREATED!";
        }
        JOptionPane.showMessageDialog(null, message, "Course", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public static boolean addNewCourse(String course_id, String subject, String course_num, char session, String name, String description, double units, int recommended_academic_planner_priority, Course[] prereqs){
        Course c = new Course(course_id, subject, course_num, session, name, description, units, recommended_academic_planner_priority, prereqs);
        boolean add = alCourse.add(c);
        String message;
        if(add) {
            message = c.toEventString() + " saved.";
            Collections.sort(alCourse);
        } else {
            message = "ERROR! COURSE NOT CREATED!";
        }
        JOptionPane.showMessageDialog(null, message, "Course", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public static Course getCourse(int index) {
        if (index < 0 || index > alCourse.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Course", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alCourse.get(index);
    }
    
    public static boolean addNewTime_Period(LocalTime start_time, LocalTime end_time){
        Time_Period t = new Time_Period(start_time, end_time);
        boolean add = alTime.add(t);
        String message;
        if(add) {
            message = t.toEventString() + " saved.";
            Collections.sort(alTime);
        } else {
            message = "ERROR! COURSE NOT CREATED!";
        }
        JOptionPane.showMessageDialog(null, message, "Time", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public static Time_Period getTime_Period(int index) {
        if (index < 0 || index > alTime.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Time", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alTime.get(index);
    }
    
    public static boolean addNewSection(int courseIndex, String section, int capacity, boolean[] days){
        Section s = new Section(getCourse(courseIndex), section, capacity, days);
        boolean add = alSection.add(s);
        String message;
        if(add) {
            message = s.toEventString() + " saved.";
            Collections.sort(alSection);
        } else {
            message = "ERROR! COURSE NOT CREATED!";
        }
        JOptionPane.showMessageDialog(null, message, "Section", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public static Section getSection(int index) {
        if (index < 0 || index > alSection.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Section", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alSection.get(index);
    }
    
    public static boolean addNewFCA(int facultyIndex, int timeIndex, int roomIndex, int sectionIndex){
        Final_Course_Assignment fca = new Final_Course_Assignment(alFaculty.get(facultyIndex), alTime.get(timeIndex), alRoom.get(roomIndex), alSection.get(sectionIndex));
        boolean add = alFCA.add(fca);
        String message;
        if(add) {
            message = "Final Course Assignment for " + fca.toEventString();
            Collections.sort(alFCA);
        } else {
            message = "ERROR! COURSE NOT CREATED!";
        }
        JOptionPane.showMessageDialog(null, message, "Final Course Assignment", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public static Final_Course_Assignment getFCA(int index) {
        if (index < 0 || index > alFCA.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Final Course Assignment", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alFCA.get(index);
    }

} // Storage
