package com.pf7.smdb.helper;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class HelperFunctions {


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static String randomRole(){

        List<String > stringList = Arrays.asList("ACTOR",
                "DIRECTOR",
                "PRODUCER",
                "MANAGER",
                "WRITER");
        Random r = new Random();
        int randomitem = r.nextInt(stringList.size());

        return stringList.get(randomitem);
    }
}
