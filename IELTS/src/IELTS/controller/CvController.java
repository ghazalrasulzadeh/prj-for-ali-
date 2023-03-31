package IELTS.controller;

import IELTS.model.da.CvDa;
import IELTS.model.entity.Cv;

import java.sql.SQLException;

public class CvController {
    public static String getMessage(Exception e) {
        if (e instanceof SQLException) {
            return "SQL Error" + e.getMessage();
        } else {
            return "Error";
        }
    }



    public String save(String goal, String gender){
        try{
            if(
                    !(gender.isEmpty())){

                CvDa cvDa = new CvDa();
                Cv cv = new Cv(goal,gender);
                cvDa.save(cv);
                System.out.println("Cv Saved");
            }else{
                System.out.println("Invalid Data");
            }
        } catch (Exception e) {
            return getMessage(e);

        }
        return goal;
    }
}
