package com.ruben.AlfaBank.sevice;

import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class Calculator {

    public String getYesterdayDate () {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, - 1);
        return dateFormat.format(calendar.getTime());
    }

    public String calculate(double now, double after){
        return now >= after ? "rich" : "broke";
    }

}
