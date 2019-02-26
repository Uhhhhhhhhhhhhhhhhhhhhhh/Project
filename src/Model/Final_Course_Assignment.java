/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

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

    public Final_Course_Assignment(Faculty faculty, Time_Period period, Room room, Section section) {
        this.faculty = faculty;
        this.period = period;
        this.room = room;
        this.section = section;
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
