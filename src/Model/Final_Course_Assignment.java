/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.time.LocalDate;
import static java.util.Comparator.comparing;

/**
 * Date: Feb 21, 2019
 * @author dsd5227
 */
public class Final_Course_Assignment implements Comparable<Final_Course_Assignment> {

    private Faculty faculty;
    private Time_Period period;
    private Room room;
    private Section section;
    private LocalDate start_date;
    private LocalDate end_date;
    private boolean[] days;

    public Final_Course_Assignment(Faculty faculty, Time_Period period, Room room, Section section, LocalDate start_date, LocalDate end_date, boolean[] days) {
        this.faculty = faculty;
        this.period = period;
        this.room = room;
        this.section = section;
        this.start_date = start_date;
        this.end_date = end_date;
        this.days = days;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Time_Period getPeriod() {
        return period;
    }

    public void setPeriod(Time_Period period) {
        this.period = period;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
    
    public boolean[] getDays() {
        return days;
    }

    public void setDays(boolean[] days) {
        this.days = days;
    }
    
    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
    
    @Override
    public String toString() {
        return "Final_Course_Assignment{" + "faculty=" + faculty + ", period=" + period + ", room=" + room + ", section=" + section + '}';
    }
    
    public String toEventString() {
        return section.getCourse().getSubject() + " " 
                + section.getCourse().getCourse_num() + " "
                + section.getSection() + "\n" + section.getCourse().getName()
                + "\nProf. " + faculty.getLast_name();
    }
    
    @Override
    public int compareTo(Final_Course_Assignment other) {
        return comparing(Final_Course_Assignment::getSection)
                .compare(this, other);
    }
    
} // Final_Course_Assignment
