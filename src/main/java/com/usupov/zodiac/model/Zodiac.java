package com.usupov.zodiac.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

/**
 * Знаки зодиака
 */
public class Zodiac {

    //Високосный год по умолчанию
    private final int currentYear = 2016;

    //Даты которые начинаются зодиаки
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

    //Список названий зодиаков
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


        //Дата по которому надо определить знака зодиака
        GregorianCalendar currentDate = new GregorianCalendar(currentYear, month - 1, day);

        this.name = zodiacNameList.get(zodiacNameList.size() - 1);
        for (int i = 0; i < zodiacCalendarList.size() - 1; i++) {

            GregorianCalendar dateFrom = zodiacCalendarList.get(i);
            GregorianCalendar dateTo   = zodiacCalendarList.get((i + 1));

            if (
                currentDate.equals(dateFrom) ||
                (
                    currentDate.after(dateFrom) &&
                    currentDate.before(dateTo)
                )
            ) {
                this.name = zodiacNameList.get(i);
            }

        }

    }

    /**
     * Проверяет месяц и день
     * на валидност
     * @return
     * @throws DateTimeException
     */
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
