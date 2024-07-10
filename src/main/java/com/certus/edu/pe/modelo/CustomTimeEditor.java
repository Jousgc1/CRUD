package com.certus.edu.pe.modelo;

import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomTimeEditor extends PropertyEditorSupport {

    private final SimpleDateFormat dateFormat;
    private final boolean allowEmpty;

    public CustomTimeEditor(SimpleDateFormat dateFormat, boolean allowEmpty) {
        this.dateFormat = dateFormat;
        this.allowEmpty = allowEmpty;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.length() == 0) {
            if (allowEmpty) {
                setValue(null);
            } else {
                throw new IllegalArgumentException("Time cannot be empty");
            }
        } else {
            try {
                // Asegúrate de que el formato sea HH:mm
                setValue(new Time(dateFormat.parse(text).getTime()));
            } catch (ParseException e) {
                throw new IllegalArgumentException("Could not parse time: " + e.getMessage(), e);
            }
        }
    }

    @Override
    public String getAsText() {
        Time value = (Time) getValue();
        return value != null ? dateFormat.format(value) : "";
    }
}
