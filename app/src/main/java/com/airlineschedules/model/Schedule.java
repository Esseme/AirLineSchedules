package com.airlineschedules.model;

import java.time.LocalDateTime;

/**
 * Created by Ed Ssemuwemba on 5/13/19.
 * esseme@gmail.com
 */
public class Schedule {
    private String airPortCode;
    private String scheduleTime;
    private String terminal;

    public String getAirPortCode() {
        return airPortCode;
    }

    public void setAirPortCode(String airPortCode) {
        this.airPortCode = airPortCode;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }
}
