package com.jetbrains.intern.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class Zodiac {

    private final int currentYear = 2016;

    private final List<GregorianCalendar> zodiacCalendarList = Arrays.asList(
        new GregorianCalendar(currentYear,0,21),
        new GregorianCalendar(currentYear,1,20),
        new GregorianCalendar(currentYear,2,21),
        new GregorianCalendar(currentYear,3,21),
        new GregorianCalendar(currentYear,4,22),
        new GregorianCalendar(currentYear,5,22),
        new GregorianCalendar(currentYear,6,23),
        new GregorianCalendar(currentYear,7,22),
        new GregorianCalendar(currentYear,8,24),
        new GregorianCalendar(currentYear,9,24),
        new GregorianCalendar(currentYear,10,23),
        new GregorianCalendar(currentYear,11,23)
    );

    private final List<String> zodiacNameList = Arrays.asList(
        "Водолей",
        "Рыбы",
        "Овен",
        "Телец",
        "Близнецы",
        "Рак",
        "Лев",
        "Дева",
        "Весы",
        "Скорпион",
        "Стрелец",
        "Козерог"
    );

    private int month, day;
    private String name;

    public Zodiac(int month, int day) {

        this.month = month;
        this.day = day;
        this.isDateValid();

        GregorianCalendar currentDate = new GregorianCalendar(currentYear, month - 1, day);

        if(currentDate.before(zodiacCalendarList.get(0)) ||
           currentDate.after(zodiacCalendarList.get(11)) ||
           currentDate.equals(zodiacCalendarList.get(0))
        ) {
            this.name = zodiacNameList.get(11);
        }

        for (int i = 0; i < zodiacCalendarList.size() - 1; i++)
            if (
                currentDate.equals(zodiacCalendarList.get(i)) ||
                (
                    currentDate.after(zodiacCalendarList.get(i)) &&
                    currentDate.before(zodiacCalendarList.get(i + 1))
                )
            ) {
                this.name = zodiacNameList.get(i);
            }

    }

    private boolean isDateValid() throws DateTimeException {
        LocalDate.of(2016, month, day);
        return true;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getName() {
        return name;
    }

}
