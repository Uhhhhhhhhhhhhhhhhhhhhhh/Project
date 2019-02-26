/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.util.Comparator.comparing;

/**
 *
 * @author Derek
 */
public class Section implements Comparable<Section> {
    private Course course;
    private String section;
    private int capacity;
    private boolean[] days;

    public Section(Course course, String section, int capacity, boolean[] days) {
        this.course = course;
        this.section = section;
        this.capacity = capacity;
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

    @Override
    public String toString() {
        return "Section{" + "course=" + course + ", section=" + section + ", capacity=" + capacity + ", days=" + days + '}';
    }
    
    public String toEventString() {
        return course.toEventString() + " " + section;
    }
    
    public int compareTo(Section other) {
        return comparing(Section::getCourse)
                .thenComparing(Section::getSection)
                .compare(this, other);
    }

}
