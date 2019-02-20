/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Derek
 */
public class Student {
    
    private String psu_id;
    private String first_name;
    private String last_name;
    private String major;
    private String minor;
    private int credits;

    public Student(String psu_id, String first_name, String last_name, String major, int credits) {
        this.psu_id = psu_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.major = major;
        this.credits = credits;
    }

    public Student(String psu_id, String first_name, String last_name, String major, String minor, int credits) {
        this.psu_id = psu_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.major = major;
        this.minor = minor;
        this.credits = credits;
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Student{" + "psu_id=" + psu_id + ", first_name=" + first_name + ", last_name=" + last_name + ", major=" + major + ", minor=" + minor + ", credits=" + credits + '}';
    }
    
}
