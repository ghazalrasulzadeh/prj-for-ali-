package IELTS.model.entity;

import com.google.gson.Gson;

public class Cv {
    private int id;
    private String goal;
    private String gender;

    public Cv() {
    }

    public Cv(int id, String goal, String gender) {
        this.id = id;
        this.goal = goal;
        this.gender = gender;
    }

    public Cv(String goal, String gender) {
        this.goal = goal;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public Cv setId(int id) {
        this.id = id;
        return this;
    }

    public String getGoal() {
        return goal;
    }

    public Cv setGoal(String goal) {
        this.goal = goal;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Cv setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
