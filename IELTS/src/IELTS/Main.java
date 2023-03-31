package IELTS;

import IELTS.model.bl.ExamBl;
import IELTS.model.entity.Exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> answers = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        for (Exam exam : ExamBl.findAll()) {
            System.out.println("Question : " + exam.getId());
            System.out.println(exam.getQuestion());
            System.out.println("1)" + exam.getAnswer1());
            System.out.println("2)" + exam.getAnswer2());
            System.out.println("3)" + exam.getAnswer3());
            System.out.println("4)" + exam.getAnswer4());
            System.out.print("Enter Answer : ");
            int answer = Integer.parseInt(scanner.nextLine());
            answers.put(exam.getId(), answer);
            System.out.println("----------------------------------------");
        }
        System.out.println("Score : " + ExamBl.getSumScore(answers));
    }
}
