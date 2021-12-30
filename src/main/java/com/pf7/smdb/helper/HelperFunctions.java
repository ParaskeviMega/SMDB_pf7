package com.pf7.smdb.helper;

import java.util.Random;

public abstract class HelperFunctions {

    public static GenreEnum randomGenre() {
        int pick = new Random().nextInt(GenreEnum.values().length);
        return GenreEnum.values()[pick];
    }

    public static PersonRoleEnum randomRole() {
        int pick = new Random().nextInt(PersonRoleEnum.values().length);
        return PersonRoleEnum.values()[pick];
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
