package Calendar;

import Model.Final_Course_Assignment;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class CalendarEvent {

    private static final Color DEFAULT_COLOR = Color.PINK;

    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private String text;
    private Color color;
    private Final_Course_Assignment fca;

    public CalendarEvent(LocalDate date, LocalTime start, LocalTime end, String text, Final_Course_Assignment fca) {
        this(date, start, end, text, DEFAULT_COLOR, fca);
    }

    public CalendarEvent(LocalDate date, LocalTime start, LocalTime end, String text, Color color, Final_Course_Assignment fca) {
        this.date = date;
        this.start = start;
        this.end = end;
        this.text = text;
        this.color = color;
        this.fca = fca;
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

    public String toString() {
        return getDate() + " " + getStart() + "-" + getEnd() + ". " + getText();
    }

    public Color getColor() {
        return color;
    }
    
    public void setFCA(Final_Course_Assignment fca){
        this.fca = fca;
    }
    
    public Final_Course_Assignment getFCA() {
        return fca;
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
