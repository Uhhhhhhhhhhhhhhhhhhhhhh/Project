package Calendar;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class CalendarEvent {

    private static final Color DEFAULT_COLOR = Color.PINK;

    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private String text;
    private String course_id;
    private String section_num;
    private Color color;

    public CalendarEvent(LocalDate date, LocalTime start, LocalTime end, String text) {
        this(date, start, end, text, "", "", DEFAULT_COLOR);
    }
    
    public CalendarEvent(LocalDate date, LocalTime start, LocalTime end, String text, Color color) {
        this(date, start, end, text, "", "", color);
    }
    
    public CalendarEvent(LocalDate date, LocalTime start, LocalTime end, String text, String course_id, String section_num) {
        this(date, start, end, text, course_id, section_num, DEFAULT_COLOR);
    }

    public CalendarEvent(LocalDate date, LocalTime start, LocalTime end, String text, String course_id, String section_num, Color color) {
        this.date = date;
        this.start = start;
        this.end = end;
        this.text = text;
        this.course_id = course_id;
        this.section_num = section_num;
        this.color = color;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getCourseId() {
        return course_id;
    }
    
    public void setCourseId(String course_id) {
        this.course_id = course_id;
    }
    
    public String getSectionNum() {
        return section_num;
    }
    
    public void setSectionNum(String section_num) {
        this.section_num = section_num;
    }

    public String toString() {
        return getDate() + " " + getStart() + "-" + getEnd() + ". " + getText();
    }

    public Color getColor() {
        return color;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalendarEvent that = (CalendarEvent) o;

        if (!date.equals(that.date)) return false;
        if (!start.equals(that.start)) return false;
        return end.equals(that.end);

    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }
}
