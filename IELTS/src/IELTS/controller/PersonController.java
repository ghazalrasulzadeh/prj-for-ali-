package IELTS.controller;

import IELTS.model.bl.PersonBl;
import IELTS.model.da.PersonDa;
import IELTS.model.entity.Person;

import java.sql.SQLException;

public class PersonController {
    public static String getMessage(Exception e){
        if (e instanceof SQLException){
            return "SQL Error" + e.getMessage();
        }else{
            return "Error";
        }

    }

    public static String  save(String name,String family,String PhoneNumber,String UserName,String PassWord){
        try{
            //data validation
            if (
                    !(name.isEmpty()) &&
                    !(family.isEmpty()) &&
                    !(PhoneNumber.isEmpty()) &&
                    !(UserName.isEmpty()) &&
                    !(PassWord.isEmpty())){



                Person person = new Person(name,family,PhoneNumber,UserName,PassWord);
                PersonBl.save(person);

                System.out.println("Person Saved");
            }else{
                System.out.println("Invalid Data");
            }
        } catch (Exception e) {
            return getMessage(e);
        }
        return name;
    }


}
