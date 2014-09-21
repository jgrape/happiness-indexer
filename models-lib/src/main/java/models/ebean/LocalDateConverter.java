package models.ebean;

import com.avaje.ebean.config.ScalarTypeConverter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;


/**
 * Automagically used by Ebean (picked up during class pass scanning on startup)
 */
public class LocalDateConverter implements ScalarTypeConverter<LocalDate, Date> {
  @Override public LocalDate getNullValue() {
    return null;
  }
  @Override public LocalDate wrapValue(Date date) {
    return date.toLocalDate();
  }
  @Override public Date unwrapValue(LocalDate localDate) {
    return new Date(localDate.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli());
  }
}