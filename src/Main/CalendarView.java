/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Calendar.Calendar;
import Calendar.CalendarEvent;
import Calendar.WeekCalendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Derek
 */
public class CalendarView {
    
    public static JPanel weeklyCalendar(ArrayList<CalendarEvent> events) {
        JPanel frm = new JPanel();

        WeekCalendar cal = new WeekCalendar(events);

        cal.addCalendarEventClickListener(e -> createEventPopUp(e.getCalendarEvent()));
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
        
        return frm;
    }
    
    private static void createEventPopUp(CalendarEvent e){
        ArrayList<Object> fca = SQLPreparedStatements.getSingleFCA(e.getCourseId(), e.getSectionNum());
        ApplicationFrame.createNewPanel(new View.Item.ItemFinalCourseAssignmentPanel(fca), "Item: Final Course Assignment", 10, 10);
    }
}
