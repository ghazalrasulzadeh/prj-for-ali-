package IELTS.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ExamController {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:xe", "javase", "java123");
        }

        catch (Exception e){
            System.out.println("Error:" + e.getMessage());
        }

    }
}
