package IELTS.model.bl;


import IELTS.model.da.PersonDa;
import IELTS.model.entity.Person;

import java.util.List;

public class PersonBl {
    public static Person save(Person person) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            return personDa.save(person);
        }
    }

    public static Person edit(Person person) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            return personDa.edit(person);
        }
    }

    public static Person remove(int id) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            return personDa.remove(id);
        }
    }



    public static List<Person> findAll() throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            return personDa.findAll();
        }
    }

    public static Person findByUserName(String userName) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            return personDa.findByUserName(userName);
        }
    }


}
