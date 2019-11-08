package com.dsi.bravo.services.format.impl;

import com.dsi.bravo.services.format.DateFormatter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DateFormatterImpl implements DateFormatter {

    public LocalDate formatString(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyyy");

        return LocalDate.parse(fecha, formatter);
    }
}
