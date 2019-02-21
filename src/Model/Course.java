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
public class Course {
    private String course_id;
    private String subject;
    private String course_num;
    private String session;
    private String description;
    private int units;
    private int recommended_academic_planner_priority;
    private Course[] prereqs;

    public Course(String course_id, String subject, String course_num, String session, String description, int units, int recommended_academic_planner_priority, Course[] prereqs) {
        this.course_id = course_id;
        this.subject = subject;
        this.course_num = course_num;
        this.session = session;
        this.description = description;
        this.units = units;
        this.recommended_academic_planner_priority = recommended_academic_planner_priority;
        this.prereqs = prereqs;
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

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getRecommended_academic_planner_priority() {
        return recommended_academic_planner_priority;
    }

    public void setRecommended_academic_planner_priority(int recommended_academic_planner_priority) {
        this.recommended_academic_planner_priority = recommended_academic_planner_priority;
    }

    public Course[] getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(Course[] prereqs) {
        this.prereqs = prereqs;
    }

    @Override
    public String toString() {
        return "Course{" + "course_id=" + course_id + ", subject=" + subject + ", course_num=" + course_num + ", session=" + session + ", description=" + description + ", units=" + units + ", recommended_academic_planner_priority=" + recommended_academic_planner_priority + ", prereqs=" + prereqs + '}';
    }
    
}
