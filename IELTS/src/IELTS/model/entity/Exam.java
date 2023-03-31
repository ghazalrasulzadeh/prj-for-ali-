package IELTS.model.entity;

/*
start prj : 2022-2-11
03:26 AM
Ghazal
Hesam
Arman
prj:speaking for IELTS
 */

import com.google.gson.Gson;

public class Exam {
    private int id;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int correctAnswer;
    private int score;

    public Exam() {
    }

    public Exam(int id, String question, String answer1, String answer2, String answer3, String answer4, int correctanswer, int score) {
        this.id = id;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctanswer;
        this.score = score;
    }

    public Exam(String question, String answer1, String answer2, String answer3, String answer4, int correctanswer, int score) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctanswer;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public Exam setId(int id) {
        this.id = id;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public Exam setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer1() {
        return answer1;
    }

    public Exam setAnswer1(String answer1) {
        this.answer1 = answer1;
        return this;
    }

    public String getAnswer2() {
        return answer2;
    }

    public Exam setAnswer2(String answer2) {
        this.answer2 = answer2;
        return this;
    }

    public String getAnswer3() {
        return answer3;
    }

    public Exam setAnswer3(String answer3) {
        this.answer3 = answer3;
        return this;
    }

    public String getAnswer4() {
        return answer4;
    }

    public Exam setAnswer4(String answer4) {
        this.answer4 = answer4;
        return this;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public Exam setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Exam setScore(int score) {
        this.score = score;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
