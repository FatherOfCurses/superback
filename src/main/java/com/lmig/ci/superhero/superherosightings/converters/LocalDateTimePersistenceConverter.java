package com.lmig.ci.superhero.superherosightings.converters;

/*
 * Copyright (C) 2018, Liberty Mutual Group
 *
 * Created on Feb 7, 2018
 */


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author brianwachsmuth
 *
 */
@Converter(autoApply = true)
public class LocalDateTimePersistenceConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(final LocalDateTime entityValue) {
        if (entityValue == null) {
            return null;
        }

        return Timestamp.from(entityValue.toInstant(ZoneOffset.UTC));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(final Timestamp databaseValue) {
        if (databaseValue == null) {
            return null;
        }

        return ZonedDateTime.ofInstant(databaseValue.toInstant(), ZoneId.of("UTC")).toLocalDateTime();
    }
}
