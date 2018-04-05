package com.lmig.ci.superhero.superherosightings.converters;

/*
 * Copyright (C) 2018, Liberty Mutual Group
 *
 * Created on Feb 7, 2018
 */



import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author brianwachsmuth
 *
 */
@Converter(autoApply = true)
public class LocalDatePersistenceConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(final LocalDate entityValue) {
        if (entityValue == null) {
            return null;
        }

        return Date.valueOf(entityValue);
    }

    @Override
    public LocalDate convertToEntityAttribute(final Date databaseValue) {
        if (databaseValue == null) {
            return null;
        }

        return databaseValue.toLocalDate();
    }
}
