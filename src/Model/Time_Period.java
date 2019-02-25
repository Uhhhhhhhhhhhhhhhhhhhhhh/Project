/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.time.LocalTime;

/**
 * Date: Feb 21, 2019
 * @author dsd5227
 */
public class Time_Period {
    
    private int period;
    private LocalTime start_time;
    private LocalTime end_time;

    public Time_Period(int period, LocalTime start_time, LocalTime end_time) {
        this.period = period;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Time_Period{" + "period=" + period + ", start_time=" + start_time + ", end_time=" + end_time + '}';
    }
    
    public String toEventString() {
        return start_time.toString() + " - " + end_time.toString();
    }

} // Time_Period
