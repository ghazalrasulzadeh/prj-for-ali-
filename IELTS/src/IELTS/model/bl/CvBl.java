package IELTS.model.bl;

import IELTS.model.da.CvDa;
import IELTS.model.da.PersonDa;
import IELTS.model.entity.Cv;
import IELTS.model.entity.Person;

import java.util.List;

public class CvBl {
    public static Cv save(Cv cv) throws Exception {
        try (CvDa cvDa = new CvDa()) {
            return cvDa.save(cv);
        }
    }

    public static List<Cv> findAll() throws Exception {
        try (CvDa cvDa = new CvDa()) {
            return cvDa.findAll();
        }
    }

    public static Cv findById(int id) throws Exception {
        try (CvDa cvDa = new CvDa()) {
            return cvDa.findById(id);
        }
    }

    public static Cv remove(int id) throws Exception {
        try (CvDa cvDa = new CvDa()) {
            return cvDa.remove(id);
        }
    }

    public static Cv edit(Cv cv) throws Exception {
        try (CvDa cvDa = new CvDa()) {
            return cvDa.edit(cv);
        }
    }


}
