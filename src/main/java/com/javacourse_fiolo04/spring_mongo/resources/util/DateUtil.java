package com.javacourse_fiolo04.spring_mongo.resources.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;

public class DateUtil {
    public static Instant convertDate(String textDate, Instant defaultValue) {
        try {
            LocalDate date = LocalDate.parse(textDate);

            return date
                .atStartOfDay(ZoneOffset.UTC)
                .toInstant();

        } catch (DateTimeParseException e) {
            return defaultValue;
        }
    }
}
