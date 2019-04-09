/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendar;

import Main.ApplicationFrame;
import Main.SQLPreparedStatements;
import View.Item.ItemFinalCourseAssignmentPanel;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Derek
 */
public class CreatePanels {
    
    public static WeekCalendar createWeekCalendarPanel(ArrayList<CalendarEvent> events) {
        WeekCalendar cal = new WeekCalendar(events);
        
        cal.addCalendarEventClickListener(e -> {
            ApplicationFrame.createNewPanel(new ItemFinalCourseAssignmentPanel(SQLPreparedStatements.getSingleFCA(e.getCalendarEvent().getCourseId(), e.getCalendarEvent().getSectionNum())), "Item: FCA " + e.getCalendarEvent().getCourseId() + " - " + e.getCalendarEvent().getSectionNum(), 400, 300);
        }); //Method to create new panel for course info
        
        cal.addCalendarEmptyClickListener((CalendarEmptyClickEvent e) -> {
            LocalDate date = e.getDateTime().toLocalDate();
            LocalTime time = e.getDateTime().toLocalTime();
            JOptionPane.showMessageDialog(null, date.getDayOfWeek() + " " + date.getMonth() + " " + date.getDayOfMonth() + "," + date.getYear() + "\n" + time.getHour() + ":" + time.getMinute(), "Time", JOptionPane.INFORMATION_MESSAGE);
        }); //Same here
        
        return cal;
    } 
    //WeekCalendar cal = createWeekCalendarPanel()
    //JPanel weekControls = createWeekControlPanel(cal)

    public static JPanel createWeekControlPanel(WeekCalendar cal){
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

        return weekControls;
    }
    
}
