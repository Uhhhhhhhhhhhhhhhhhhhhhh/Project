package Model;

import static java.util.Comparator.comparing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Derek
 */
public class Student implements Comparable<Student> {
    
    private String psu_id;
    private String first_name;
    private String last_name;
    private String major;
    private String minor;
    private double credits;

    public Student(String psu_id, String first_name, String last_name, String major, double credits) {
        this.psu_id = psu_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.major = major;
        this.credits = credits;
    }

    public Student(String psu_id, String first_name, String last_name, String major, String minor, double credits) {
        this.psu_id = psu_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.major = major;
        this.minor = minor;
        this.credits = credits;
    }

    public String getPsu_id() {
        return psu_id;
    }
    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Student{" + "psu_id=" + psu_id + ", first_name=" + first_name + ", last_name=" + last_name + ", major=" + major + ", minor=" + minor + ", credits=" + credits + '}';
    }
    
    @Override
    public int compareTo(Student other) {
        return comparing(Student::getLast_name)
                .thenComparing(Student::getFirst_name)
                .compare(this, other);
    }
    
}
