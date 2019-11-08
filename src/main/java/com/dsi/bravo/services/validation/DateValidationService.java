package com.dsi.bravo.services.validation;

import java.time.LocalDate;

public interface DateValidationService {

    boolean validate(LocalDate fechaDesde, LocalDate fechaHasta);

}
