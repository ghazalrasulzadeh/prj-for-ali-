package IELTS.model.bl;

import IELTS.model.da.FreeTimeDa;
import IELTS.model.entity.FreeTime;


import java.util.List;

public class FreeTimeBl {
    public static FreeTime save(FreeTime freeTime) throws Exception {
        try (FreeTimeDa freeTimeDa = new FreeTimeDa()) {
            return freeTimeDa.save(freeTime);
        }
    }

    public static List<FreeTime> findAll() throws Exception {
        try (FreeTimeDa freeTimeDa = new FreeTimeDa()) {
            return freeTimeDa.findAll();
        }
    }

    public static FreeTime findByDay(String day) throws Exception {
        try (FreeTimeDa freeTimeDa = new FreeTimeDa()) {
            return freeTimeDa.findByDay(day);
        }
    }
}
