
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
        
        //Faculty
        Storage.addNewFaculty("pen1234", "Penny", "Salmon", "SRA", new boolean[]{false, false, true, true, true});
        Storage.addNewFaculty("jem1234", "James", "Waterson", "IST", new boolean[]{true, false, true, true, true});
        
        //Room
        Storage.addNewRoom("Gaige", "205", 40, 41, "Computer");
        Storage.addNewRoom("Gaige", "204", 25, 25, "Computer");
        
        //Course
        Storage.addNewCourse("14130", "IST", "411", 'P', "Distributed-Object Computing", "THIS IS A DESCRIPTION", 3);
        Storage.addNewCourse("13997", "IST", "261", 'P', "Application Development Design Studio I", "THIS IS A DESCRIPTION", 3);
        
        //Time_Period
        Storage.addNewTime_Period(LocalTime.of(15, 00), LocalTime.of(16, 15));
        Storage.addNewTime_Period(LocalTime.of(9, 00), LocalTime.of(11, 30));
        Storage.addNewTime_Period(LocalTime.of(12, 05), LocalTime.of(13, 20));
        
        //Start And End of Semester
        LocalDate startOfSemester = LocalDate.of(2019, 1, 7);
        LocalDate endOfSemester = LocalDate.of(2019, 4, 26);
        
        //Section
        Storage.addNewSection(0, "001", 15, 25, startOfSemester, endOfSemester, new boolean[]{true, false, true, false, false});
        Storage.addNewSection(1, "002", 10, 25, startOfSemester, endOfSemester, new boolean[]{true, false, true, false, false});
        Storage.addNewSection(0, "002", 12, 25, startOfSemester, endOfSemester, new boolean[]{false, true, false, true, true});
        Storage.addNewSection(1, "001", 6, 25, startOfSemester, endOfSemester, new boolean[]{false, true, false, true, true});
        
        //FCA
        Storage.addNewFCA(1, 1, 1, 1);
        Storage.addNewFCA(0, 0, 0, 0);
        
        
        
        //Events
        ArrayList<CalendarEvent> events = new ArrayList<>();
        events.addAll(fcaToCalendarEvent(Storage.getFCA(0), new Color(173, 216, 230), startOfSemester, endOfSemester));
        events.addAll(fcaToCalendarEvent(Storage.getFCA(1), new Color(216, 191, 216), startOfSemester, endOfSemester));
        
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
