package com.example.send_book_email_spring_batch.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public final class GenerateBookReturnDate {

    public static int numDaysToReturnBook = 7;
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static String getDate(LocalDate loanDate) {
        Calendar calendar = dateToCalendar(loanDate);
        calendar.add(Calendar.DATE, numDaysToReturnBook);
        String result = dateFormat.format(calendar.getTime());
        return result;
    }

    private static Calendar dateToCalendar(LocalDate loanDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(java.sql.Date.valueOf(loanDate));
        return calendar;
    }
}
