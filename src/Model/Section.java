/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import static java.util.Comparator.comparing;

/**
 *
 * @author Derek
 */
public class Section implements Comparable<Section> {
    private Course course;
    private String section;
    private int enrollment;
    private int capacity;
    private LocalDate start_date;
    private LocalDate end_date;
    private boolean[] days;

    public Section(Course course, String section, int enrollment, int capacity, LocalDate start_date, LocalDate end_date, boolean[] days) {
        this.course = course;
        this.section = section;
        this.enrollment = enrollment;
        this.capacity = capacity;
        this.start_date = start_date;
        this.end_date = end_date;
        this.days = days;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean[] getDays() {
        return days;
    }

    public void setDays(boolean[] days) {
        this.days = days;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
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
        return "Section{" + "course=" + course + ", section=" + section + ", enrollment=" + enrollment + ", capacity=" + capacity + ", start_date=" + start_date + ", end_date=" + end_date + ", days=" + days + '}';
    }
    
    public String toEventString() {
        return course.toEventString() + " " + section;
    }
    
    @Override
    public int compareTo(Section other) {
        return comparing(Section::getCourse)
                .thenComparing(Section::getSection)
                .compare(this, other);
    }

}
