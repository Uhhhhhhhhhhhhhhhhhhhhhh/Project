/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendar;

import Main.SQLPreparedStatements;
import java.awt.Color;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Derek
 */
public class CourseToEvents {
    
    public static ArrayList<CalendarEvent> fcaToCalendarEvent(String course_id, String section_num, String text, LocalDate start_date, LocalDate end_date, LocalTime start_time, LocalTime end_time, int dates){
        return fcaToCalendarEvent(course_id, section_num, text, start_date, end_date, start_time, end_time, dates, new Color((int) (Math.random() * 180) + 75,(int)  (Math.random() * 180) + 75,(int)  (Math.random() * 180) + 75));
    }
    
    public static ArrayList<CalendarEvent> fcaToCalendarEvent(String course_id, String section_num, String text, LocalDate start_date, LocalDate end_date, LocalTime start_time, LocalTime end_time, int dates, Color course_color){
        ArrayList<CalendarEvent> classes = new ArrayList<>();
        end_date = end_date.plusDays(1);
        
        boolean[] days = SQLPreparedStatements.intToArray(dates);
        
        if(days[0]) {
            LocalDate tempLD = LocalDate.of(start_date.getYear(), start_date.getMonth(), start_date.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.MONDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(end_date)){
                classes.add(new CalendarEvent(tempLD, start_time, end_time, text, course_id, section_num, course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(days[1]) {
            LocalDate tempLD = LocalDate.of(start_date.getYear(), start_date.getMonth(), start_date.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.TUESDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(end_date)){
                classes.add(new CalendarEvent(tempLD, start_time, end_time, text, course_id, section_num, course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(days[2]) {
            LocalDate tempLD = LocalDate.of(start_date.getYear(), start_date.getMonth(), start_date.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.WEDNESDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(end_date)){
                classes.add(new CalendarEvent(tempLD, start_time, end_time, text, course_id, section_num, course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(days[3]) {
            LocalDate tempLD = LocalDate.of(start_date.getYear(), start_date.getMonth(), start_date.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.THURSDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(end_date)){
                classes.add(new CalendarEvent(tempLD, start_time, end_time, text, course_id, section_num, course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(days[4]) {
            LocalDate tempLD = LocalDate.of(start_date.getYear(), start_date.getMonth(), start_date.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.FRIDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(end_date)){
                classes.add(new CalendarEvent(tempLD, start_time, end_time, text, course_id, section_num, course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(days[5]) {
            LocalDate tempLD = LocalDate.of(start_date.getYear(), start_date.getMonth(), start_date.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.SATURDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(end_date)){
                classes.add(new CalendarEvent(tempLD, start_time, end_time, text, course_id, section_num, course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        
        if(days[6]) {
            LocalDate tempLD = LocalDate.of(start_date.getYear(), start_date.getMonth(), start_date.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.SUNDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(end_date)){
                classes.add(new CalendarEvent(tempLD, start_time, end_time, text, course_id, section_num, course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        return classes;
    }
    
}
