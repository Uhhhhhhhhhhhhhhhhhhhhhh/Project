
import Model.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.ArrayList;
import Calendar.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.Month;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

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
        
        alCourse.add(new Course("13997", "IST", "261", 'P', "Application Development Design Studio I", "THIS IS A DESCRIPTION", 3));
        alCourse.add(new Course("14130", "IST", "411", 'P', "Distributed-Object Computing", "THIS IS A DESCRIPTION", 3));
        
        alTime.add(new Time_Period(1, LocalTime.of(12, 05), LocalTime.of(13, 20)));
        alTime.add(new Time_Period(2, LocalTime.of(15, 00), LocalTime.of(16, 15)));
        
        alSection.add(new Section(alCourse.get(0), "001", 25, new boolean[]{true, false, true, false, false}));
        alSection.add(new Section(alCourse.get(1), "001", 25, new boolean[]{false, true, false, true, true}));
        alSection.add(new Section(alCourse.get(0), "002", 25, new boolean[]{false, true, false, true, true}));
        alSection.add(new Section(alCourse.get(1), "002", 25, new boolean[]{true, false, true, false, false}));
        
        alFCA.add(new Final_Course_Assignment(alFaculty.get(0), alTime.get(0), alRoom.get(0), alSection.get(0)));
        
        weeklyCalendar(fcaToCalendarEvent(alFCA.get(0), new Color(173, 216, 230), LocalDate.of(2019, 1, 7), LocalDate.of(2019, 4, 26)));
        
    }
    
    public static void weeklyCalendar(ArrayList<CalendarEvent> events) {
        JFrame frm = new JFrame();

        WeekCalendar cal = new WeekCalendar(events);

        cal.addCalendarEventClickListener(e -> System.out.println(e.getCalendarEvent()));
        cal.addCalendarEmptyClickListener(e -> {
            System.out.println(e.getDateTime());
            System.out.println(Calendar.roundTime(e.getDateTime().toLocalTime(), 30));
        });

        JButton goToTodayBtn = new JButton("Today");
        goToTodayBtn.addActionListener(e -> cal.goToToday());

        JButton nextWeekBtn = new JButton(">");
        nextWeekBtn.addActionListener(e -> cal.nextWeek());

        JButton prevWeekBtn = new JButton("<");
        prevWeekBtn.addActionListener(e -> cal.prevWeek());

        JButton nextMonthBtn = new JButton(">>");
        nextMonthBtn.addActionListener(e -> cal.nextMonth());

        JButton prevMonthBtn = new JButton("<<");
        prevMonthBtn.addActionListener(e -> cal.prevMonth());

        JPanel weekControls = new JPanel();
        weekControls.add(prevMonthBtn);
        weekControls.add(prevWeekBtn);
        weekControls.add(goToTodayBtn);
        weekControls.add(nextWeekBtn);
        weekControls.add(nextMonthBtn);

        frm.add(weekControls, BorderLayout.NORTH);

        frm.add(cal, BorderLayout.CENTER);
        frm.setSize(1000, 900);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public static ArrayList<CalendarEvent> fcaToCalendarEvent(Final_Course_Assignment fca, Color course_color, LocalDate semester_start, LocalDate semester_end){
        ArrayList<CalendarEvent> classes = new ArrayList<>();
        semester_end = semester_end.plusDays(1);
        
        if(fca.getSection().getDays()[0]) {
            LocalDate tempLD = LocalDate.of(semester_start.getYear(), semester_start.getMonth(), semester_start.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.MONDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(semester_end)){
                classes.add(new CalendarEvent(tempLD, fca.getPeriod().getStart_time(), fca.getPeriod().getEnd_time(), fca.toEventString(), course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(fca.getSection().getDays()[1]) {
            LocalDate tempLD = LocalDate.of(semester_start.getYear(), semester_start.getMonth(), semester_start.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.TUESDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(semester_end)){
                classes.add(new CalendarEvent(tempLD, fca.getPeriod().getStart_time(), fca.getPeriod().getEnd_time(), fca.toEventString(), course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(fca.getSection().getDays()[2]) {
            LocalDate tempLD = LocalDate.of(semester_start.getYear(), semester_start.getMonth(), semester_start.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.WEDNESDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(semester_end)){
                classes.add(new CalendarEvent(tempLD, fca.getPeriod().getStart_time(), fca.getPeriod().getEnd_time(), fca.toEventString(), course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(fca.getSection().getDays()[3]) {
            LocalDate tempLD = LocalDate.of(semester_start.getYear(), semester_start.getMonth(), semester_start.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.THURSDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(semester_end)){
                classes.add(new CalendarEvent(tempLD, fca.getPeriod().getStart_time(), fca.getPeriod().getEnd_time(), fca.toEventString(), course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(fca.getSection().getDays()[4]) {
            LocalDate tempLD = LocalDate.of(semester_start.getYear(), semester_start.getMonth(), semester_start.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.FRIDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(semester_end)){
                classes.add(new CalendarEvent(tempLD, fca.getPeriod().getStart_time(), fca.getPeriod().getEnd_time(), fca.toEventString(), course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        return classes;
    }
    
}
