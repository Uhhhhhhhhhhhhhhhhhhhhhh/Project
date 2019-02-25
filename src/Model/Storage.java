package Model;

import java.time.LocalTime;
import java.util.ArrayList;
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

    ArrayList<Student> alStudent;
    ArrayList<Room> alRoom;
    ArrayList<Faculty> alFaculty;
    ArrayList<Section> alSection;
    ArrayList<Course> alCourse;
    ArrayList<Time_Period> alTime;
    ArrayList<Final_Course_Assignment> alFCA;

    public Storage() {
        alStudent = new ArrayList<>();
        alRoom = new ArrayList<>();
        alFaculty = new ArrayList<>();
        alSection = new ArrayList<>();
        alCourse = new ArrayList<>();
        alTime = new ArrayList<>();
        alFCA = new ArrayList<>();
    }

    public boolean addNewStudent(String psu_id, String first_name, String last_name, String major, int credits) {
        Student s = new Student(psu_id, first_name, last_name, major, credits);
        boolean add = alStudent.add(s);
        String message = add ? s.getFirst_name() + "'s information is saved." : "ERROR! STUDENT NOT CREATED!";
        JOptionPane.showMessageDialog(null, message, "Student", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public boolean addNewStudent(String psu_id, String first_name, String last_name, String major, String minor, int credits) {
        Student s = new Student(psu_id, first_name, last_name, major, minor, credits);
        boolean add = alStudent.add(s);
        String message = add ? s.getFirst_name() + "'s information is saved." : "ERROR! STUDENT NOT CREATED!";
        JOptionPane.showMessageDialog(null, message, "Student", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public Student getStudent(int index) {
        if (index < 0 || index > alStudent.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Student", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alStudent.get(index);
    }

    public boolean addNewFaculty(String psu_id, String first_name, String last_name, String major_college, boolean[] preferred_days) {
        Faculty f = new Faculty(psu_id, first_name, last_name, major_college, preferred_days);
        boolean add = alFaculty.add(f);
        String message = add ? f.getFirst_name() + "'s information is saved." : "ERROR! FACULTY NOT CREATED!";
        JOptionPane.showMessageDialog(null, message, "Faculty", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public Faculty getFaculty(int index) {
        if (index < 0 || index > alFaculty.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Faculty", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alFaculty.get(index);
    }
    
    public boolean addNewRoom(String building, String room_id, int occupancy, int computers, String lab_type){
        Room r = new Room(building, room_id, occupancy, computers, lab_type);
        boolean add = alRoom.add(r);
        String message = add ? r.getBuilding() + " " + r.getRoom_id() + " saved." : "ERROR! ROOM NOT CREATED!";
        JOptionPane.showMessageDialog(null, message, "Room", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public Room getRoom(int index) {
        if (index < 0 || index > alRoom.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Room", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alRoom.get(index);
    }
    
    public boolean addNewCourse(String course_id, String subject, String course_num, char session, String name, String description, int units){
        Course c = new Course(course_id, subject, course_num, session, name, description, units);
        boolean add = alCourse.add(c);
        String message = add ? c.toEventString() + " saved." : "ERROR! COURSE NOT CREATED!";
        JOptionPane.showMessageDialog(null, message, "Course", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public boolean addNewCourse(String course_id, String subject, String course_num, char session, String name, String description, int units, int recommended_academic_planner_priority){
        Course c = new Course(course_id, subject, course_num, session, name, description, units, recommended_academic_planner_priority);
        boolean add = alCourse.add(c);
        String message = add ? c.toEventString() + " saved." : "ERROR! COURSE NOT CREATED!";
        JOptionPane.showMessageDialog(null, message, "Course", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public boolean addNewCourse(String course_id, String subject, String course_num, char session, String name, String description, int units, Course[] prereqs){
        Course c = new Course(course_id, subject, course_num, session, name, description, units, prereqs);
        boolean add = alCourse.add(c);
        String message = add ? c.toEventString() + " saved." : "ERROR! COURSE NOT CREATED!";
        JOptionPane.showMessageDialog(null, message, "Course", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public boolean addNewCourse(String course_id, String subject, String course_num, char session, String name, String description, int units, int recommended_academic_planner_priority, Course[] prereqs){
        Course c = new Course(course_id, subject, course_num, session, name, description, units, recommended_academic_planner_priority, prereqs);
        boolean add = alCourse.add(c);
        String message = add ? c.toEventString() + " saved." : "ERROR! COURSE NOT CREATED!";
        JOptionPane.showMessageDialog(null, message, "Course", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public Course getCourse(int index) {
        if (index < 0 || index > alCourse.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Course", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alCourse.get(index);
    }
    
    public boolean addNewTime_Period(int period, LocalTime start_time, LocalTime end_time){
        Time_Period t = new Time_Period(period, start_time, end_time);
        boolean add = alTime.add(t);
        String message = add ? t.toEventString() + " saved." : "ERROR! COURSE NOT CREATED!";
        JOptionPane.showMessageDialog(null, message, "Time", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public Time_Period getTime_Period(int index) {
        if (index < 0 || index > alTime.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Time", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alTime.get(index);
    }
    
    public boolean addNewSection(int courseIndex, String section, int capacity, boolean[] days){
        Section s = new Section(getCourse(courseIndex), section, capacity, days);
        boolean add = alSection.add(s);
        String message = add ? s.getCourse().toEventString() + " " + s.getSection() + " saved." : "ERROR! COURSE NOT CREATED!";
        JOptionPane.showMessageDialog(null, message, "Section", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public Section getSection(int index) {
        if (index < 0 || index > alSection.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Section", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alSection.get(index);
    }
    
    public boolean addNewFCA(int facultyIndex, int timeIndex, int roomIndex, int sectionIndex){
        Final_Course_Assignment fca = new Final_Course_Assignment(alFaculty.get(facultyIndex), alTime.get(timeIndex), alRoom.get(roomIndex), alSection.get(sectionIndex));
        boolean add = alFCA.add(fca);
        String message = add ? "Final Course Assignment for " + fca.toEventString() + " saved." : "ERROR! COURSE NOT CREATED!";
        JOptionPane.showMessageDialog(null, message, "Final Course Assignment", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public Final_Course_Assignment getFCA(int index) {
        if (index < 0 || index > alFCA.size()) {
            JOptionPane.showMessageDialog(null, "Index Out of Bounds", "Final Course Assignment", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return alFCA.get(index);
    }

} // Storage
