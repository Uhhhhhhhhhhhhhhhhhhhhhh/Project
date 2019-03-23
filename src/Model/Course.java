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
public class Course implements Comparable<Course> {
    private String course_id;
    private String subject;
    private String course_num;
    private String name;
    private String description;
    private double units;
    private Course[] prereqs;

    public Course(String course_id, String subject, String course_num, String name, String description, double units) {
        this.course_id = course_id;
        this.subject = subject;
        this.course_num = course_num;
        this.name = name;
        this.description = description;
        this.units = units;
    }  

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCourse_num() {
        return course_num;
    }

    public void setCourse_num(String course_num) {
        this.course_num = course_num;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnits() {
        return units;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    public Course[] getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(Course[] prereqs) {
        this.prereqs = prereqs;
    }

    @Override
    public String toString() {
        return "Course{" + "course_id=" + course_id + ", subject=" + subject + ", course_num=" + course_num + ", name=" + name + ", description=" + description + ", units=" + units + ", prereqs=" + prereqs + '}';
    }
    
    public String toEventString() {
        return subject + " " + course_num;
    }

    @Override
    public int compareTo(Course other) {
        return comparing(Course::getSubject)
                .thenComparing(Course::getCourse_num)
                .compare(this, other);
    }
    
}
