/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Derek
 */
public class Section {
    private String class_num;
    private String section;
    private int capacity;
    private boolean[] days;
    private Course course;

    public Section(String class_num, String section, int capacity, boolean[] days, Course course) {
        this.class_num = class_num;
        this.section = section;
        this.capacity = capacity;
        this.days = days;
        this.course = course;
    }

    public String getClass_num() {
        return class_num;
    }

    public void setClass_num(String class_num) {
        this.class_num = class_num;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Section{" + "class_num=" + class_num + ", section=" + section + ", capacity=" + capacity + ", days=" + days + ", course=" + course + '}';
    }
    
}
