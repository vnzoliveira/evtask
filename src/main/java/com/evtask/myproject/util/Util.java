package com.evtask.myproject.util;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Util {

    /*
    Since all inputs from our jsp will be received as Strings (text),
    this little function here helps us, by the time the servlet receives the parameter,
    to format it to YearMonth based of the String inserted.
     */
    public YearMonth formatExpiryDate(String expirationDateString){
        return YearMonth.parse(expirationDateString, DateTimeFormatter.ofPattern("MM/yy"));
    }
}