
import Model.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.ArrayList;
import Calendar.*;
import java.awt.BorderLayout;
import java.awt.Color;
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
        
        Storage storage = new Storage();
        
        //Students
        storage.addNewStudent("dsd5227", "Derek", "DeTommaso", "IST", 72);
        storage.addNewStudent("jbd1234", "John", "Doe", "SRA", 12);
        storage.addNewStudent("jed5678", "Jane", "Doe", "SRA", 12);
        
        //Faculty
        storage.addNewFaculty("pen1234", "Penny", "Salmon", "SRA", new boolean[]{false, false, true, true, true});
        storage.addNewFaculty("jem1234", "James", "Waterson", "IST", new boolean[]{true, false, true, true, true});
        
        //Room
        storage.addNewRoom("Gaige", "205", 40, 41, "Computer");
        storage.addNewRoom("Gaige", "204", 25, 25, "Computer");
        
        //Course
        storage.addNewCourse("14130", "IST", "411", 'P', "Distributed-Object Computing", "THIS IS A DESCRIPTION", 3);
        storage.addNewCourse("13997", "IST", "261", 'P', "Application Development Design Studio I", "THIS IS A DESCRIPTION", 3);
        
        //Time_Period
        storage.addNewTime_Period(2, LocalTime.of(15, 00), LocalTime.of(16, 15));
        storage.addNewTime_Period(3, LocalTime.of(9, 00), LocalTime.of(11, 30));
        storage.addNewTime_Period(1, LocalTime.of(12, 05), LocalTime.of(13, 20));
        
        //Section
        storage.addNewSection(0, "001", 25, new boolean[]{true, false, true, false, false});
        storage.addNewSection(1, "002", 25, new boolean[]{true, false, true, false, false});
        storage.addNewSection(0, "002", 25, new boolean[]{false, true, false, true, true});
        storage.addNewSection(1, "001", 25, new boolean[]{false, true, false, true, true});
        
        //FCA
        storage.addNewFCA(1, 1, 1, 1);
        storage.addNewFCA(0, 0, 0, 0);
        
        //Start And End of Semester
        LocalDate startOfSemester = LocalDate.of(2019, 1, 7);
        LocalDate endOfSemester = LocalDate.of(2019, 4, 26);
        
        //Events
        ArrayList<CalendarEvent> events = new ArrayList<>();
        events.addAll(fcaToCalendarEvent(storage.getFCA(0), new Color(173, 216, 230), startOfSemester, endOfSemester));
        events.addAll(fcaToCalendarEvent(storage.getFCA(1), new Color(216, 191, 216), startOfSemester, endOfSemester));
        
        //Weekly Calendar
        weeklyCalendar(events);
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
