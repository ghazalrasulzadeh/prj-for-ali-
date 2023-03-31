package IELTS.model.bl;

import IELTS.model.da.ExamDa;
import IELTS.model.entity.Exam;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamBl {
    public static Exam save(Exam exam) throws Exception {
        try (ExamDa examDa = new ExamDa()) {
            return examDa.save(exam);
        }
    }

    public static List<Exam> findAll() throws Exception {
        try (ExamDa examDa = new ExamDa()) {
            return examDa.findAll();
        }
    }

    public static Exam findQuestionById(int id) throws Exception {
        try (ExamDa examDa = new ExamDa()) {
            return examDa.findById(id);
        }
    }

    public static int getScore(int id, int answer) throws Exception {
        Exam exam = null;
        try (ExamDa examDa = new ExamDa()) {
            exam = examDa.findById(id);
        }
        if (exam != null) {
            if (exam.getCorrectAnswer() == answer) {
                return exam.getScore();
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }

    public static int getSumScore(Map<Integer, Integer> answers) throws Exception {
        Exam exam = null;
        int sumScore = 0;
        for (Integer id : answers.keySet()) {
            try (ExamDa examDa = new ExamDa()) {
                exam = examDa.findById(id);
            }
            if (exam != null) {
                if (exam.getCorrectAnswer() == answers.get(id)) {
                    sumScore += exam.getScore();
                }
            }
        }
        return sumScore;
    }
}