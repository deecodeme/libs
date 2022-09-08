package com.deecodeme.datetime;

import java.time.LocalDateTime;

public final class DateTimeUtil {

    public static final int MINUTES_IN_ONE_HOUR = 60;

    private DateTimeUtil() {

    }

    public static int getMinutesOfDay() {
        return LocalDateTime.now().getHour() * MINUTES_IN_ONE_HOUR + LocalDateTime.now().getMinute();
    }

    public static int getHourOfTheDay() {
        return LocalDateTime.now().getHour();
    }
}
