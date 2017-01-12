package com.cgihosting.outils;

import java.util.Date;

/**
 * Created by garnons on 12/01/2017.
 */
public final class Dates {
    private Dates(){
        // Private constructor
    }

    // Renvoi la date au format TIMESTAMP
    public static Date aujourdhui(){
        return new java.util.Date();
    }

    // formatDate : "dd-MM-yyyy HH:mm:ss", "dd-MM-yyyy"
    // voir dans ConstantesDate
    public static String dateToString(Date date, String formatDate){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(formatDate);
        String dateString = sdf.format(date);

        return dateString;
    }
}
