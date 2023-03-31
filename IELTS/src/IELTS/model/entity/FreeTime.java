package IELTS.model.entity;

import com.google.gson.Gson;

import java.time.LocalDateTime;

public class FreeTime {
    private int id;
    private String day;
    private int StartHour;
    private int EndHour;

    public FreeTime() {
    }

    public FreeTime(int id, String day, int startHour, int endHour) {
        this.id = id;
        this.day = day;
        StartHour = startHour;
        EndHour = endHour;
    }

    public FreeTime(String day, int startHour, int endHour) {
        this.day = day;
        StartHour = startHour;
        EndHour = endHour;
    }

    public int getId() {
        return id;
    }

    public FreeTime setId(int id) {
        this.id = id;
        return this;
    }

    public String getDay() {
        return day;
    }

    public FreeTime setDay(String day) {
        this.day = day;
        return this;
    }

    public int getStartHour() {
        return StartHour;
    }

    public FreeTime setStartHour(int startHour) {
        StartHour = startHour;
        return this;
    }

    public int getEndHour() {
        return EndHour;
    }

    public FreeTime setEndHour(int endHour) {
        EndHour = endHour;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
