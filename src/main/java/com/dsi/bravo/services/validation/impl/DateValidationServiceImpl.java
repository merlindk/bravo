package com.dsi.bravo.services.validation.impl;

import com.dsi.bravo.services.validation.DateValidationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DateValidationServiceImpl implements DateValidationService {

    public boolean validate(LocalDate fechaDesde, LocalDate fechaHasta) {
        return fechaDesde.isBefore(fechaHasta);
    }
}
