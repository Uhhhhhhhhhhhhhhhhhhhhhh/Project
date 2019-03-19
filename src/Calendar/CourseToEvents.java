/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendar;

import Model.Final_Course_Assignment;
import java.awt.Color;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Derek
 */
public class CourseToEvents {
    
    public static ArrayList<CalendarEvent> fcaToCalendarEvent(Final_Course_Assignment fca, Color course_color, LocalDate semester_start, LocalDate semester_end){
        ArrayList<CalendarEvent> classes = new ArrayList<>();
        semester_end = semester_end.plusDays(1);
        
        if(fca.getDays()[0]) {
            LocalDate tempLD = LocalDate.of(semester_start.getYear(), semester_start.getMonth(), semester_start.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.MONDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(semester_end)){
                classes.add(new CalendarEvent(tempLD, fca.getPeriod().getStart_time(), fca.getPeriod().getEnd_time(), fca.toEventString(), course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(fca.getDays()[1]) {
            LocalDate tempLD = LocalDate.of(semester_start.getYear(), semester_start.getMonth(), semester_start.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.TUESDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(semester_end)){
                classes.add(new CalendarEvent(tempLD, fca.getPeriod().getStart_time(), fca.getPeriod().getEnd_time(), fca.toEventString(), course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(fca.getDays()[2]) {
            LocalDate tempLD = LocalDate.of(semester_start.getYear(), semester_start.getMonth(), semester_start.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.WEDNESDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(semester_end)){
                classes.add(new CalendarEvent(tempLD, fca.getPeriod().getStart_time(), fca.getPeriod().getEnd_time(), fca.toEventString(), course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(fca.getDays()[3]) {
            LocalDate tempLD = LocalDate.of(semester_start.getYear(), semester_start.getMonth(), semester_start.getDayOfMonth());
            while(tempLD.getDayOfWeek() != DayOfWeek.THURSDAY) {
                tempLD = tempLD.plusDays(1);
            }
            while(tempLD.isBefore(semester_end)){
                classes.add(new CalendarEvent(tempLD, fca.getPeriod().getStart_time(), fca.getPeriod().getEnd_time(), fca.toEventString(), course_color));
                tempLD = tempLD.plusDays(7);
            }
        }
        
        if(fca.getDays()[4]) {
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
