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
    

    public Section(Course course, String section) {
        this.course = course;
        this.section = section;       
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

    @Override
    public String toString() {
        return "Section{" + "course=" + course + ", section=" + section + '}';
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
