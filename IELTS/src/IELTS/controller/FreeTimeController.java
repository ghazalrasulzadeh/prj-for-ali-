package IELTS.controller;

import IELTS.model.da.FreeTimeDa;
import IELTS.model.entity.FreeTime;

import java.sql.SQLException;

public class FreeTimeController {
    public static String getMessage(Exception e) {
        if (e instanceof SQLException) {
            return "SQL Error" + e.getMessage();
        } else {
            return "Error";
        }
    }


    public String save(String day, int StartHour, int EndHour) {
        try {
            if (!(day.isEmpty())) {
                FreeTimeDa freeTimeDa = new FreeTimeDa();
                FreeTime freeTime = new FreeTime(day, StartHour, EndHour);
                return freeTimeDa.save(freeTime).toString();
//                System.out.println("FreeTime Saved");
            } else {
                System.out.println("Invalid Data");
            }
        } catch (Exception e) {
            return getMessage(e);
        }


        return day;
    }

}


