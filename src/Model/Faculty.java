package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Derek
 */
public class Faculty {
    
    private String psu_id;
    private String first_name;
    private String last_name;
    private String major_college;
    private boolean[] preferred_days;

    public Faculty(String psu_id, String first_name, String last_name, String major_college, boolean[] preferred_days) {
        this.psu_id = psu_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.major_college = major_college;
        this.preferred_days = preferred_days;
    }

    public String getPsu_id() {
        return psu_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMajor_college() {
        return major_college;
    }

    public boolean[] getPreferred_days() {
        return preferred_days;
    }
    
    public void setPsu_id(String psu_id) {
        this.psu_id = psu_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setMajor_college(String major_college) {
        this.major_college = major_college;
    }

    public void setPreferred_days(boolean[] preferred_days) {
        this.preferred_days = preferred_days;
    }

    @Override
    public String toString() {
        return "Faculty{" + "psu_id=" + psu_id + ", first_name=" + first_name + ", last_name=" + last_name + ", major_college=" + major_college + ", preferred_days=" + preferred_days + '}';
    }
    
}
