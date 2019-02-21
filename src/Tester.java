
import Model.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** 
*
 * @author Derek
 */
public class Tester {
    
    
    
    public static void main(String[] args) {
        
        ArrayList<Student> alStudent = new ArrayList<>();
        ArrayList<Room> alRoom = new ArrayList<>();
        ArrayList<Faculty> alFaculty = new ArrayList<>();
        ArrayList<Section> alSection = new ArrayList<>();
        ArrayList<Course> alCourse = new ArrayList<>();
        ArrayList<Time_Period> alTime = new ArrayList<>();
        ArrayList<Final_Course_Assignment> alFCA = new ArrayList<>();
        
        //Students
        alStudent.add(new Student("dsd5227", "Derek", "DeTommaso", "IST", 72));
        alStudent.add(new Student("abc1234", "John", "Doe", "SRA", 12));
        alStudent.add(new Student("def5678", "Jane", "Doe", "SRA", 12));
        
        //Faculty
        alFaculty.add(new Faculty("jem1234", "James", "Waterson", "IST", new boolean[]{true, false, true, true, true}));
        alFaculty.add(new Faculty("pen1234", "Penny", "Salmon", "SRA", new boolean[]{false, false, true, true, true}));
        
        //Room
        alRoom.add(new Room("Gaige", "205", 40, 41, "Computer"));
        alRoom.add(new Room("Gaige", "204", 25, 25, "Computer"));
        
        alCourse.add(new Course("13997", "IST", "261", 'P', "THIS IS A DESCRIPTION", 3));
        alCourse.add(new Course("14130", "IST", "411", 'P', "THIS IS A DESCRIPTION", 3));
        
        alTime.add(new Time_Period(1, LocalTime.of(12, 05), LocalTime.of(13, 20)));
        alTime.add(new Time_Period(2, LocalTime.of(15, 00), LocalTime.of(16, 15)));
        
        //alSection.add(new Section(, "001"));
    }
    
    
}
