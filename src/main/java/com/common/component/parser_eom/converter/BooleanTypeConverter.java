package com.common.component.parser_eom.converter;

import java.math.BigDecimal;

public class BooleanTypeConverter implements TypeConverter<Boolean> {

    public Boolean convert(Object value, String... pattern) {
        if (value == null) {
            return Boolean.FALSE;
        }

        if (value instanceof Boolean) {
            return (Boolean) value;
        }

        if (value instanceof Integer) {
            try {
                value = value.toString().trim();
            } catch (Exception ex) {
                return Boolean.FALSE;
            }
        }

        if (value instanceof String) {
            try {
                value = BigDecimal.valueOf(Long.parseLong(((String) value).trim()));
            } catch (Exception ex) {
                return Boolean.FALSE;
            }
        }

        if (value instanceof BigDecimal) {
            BigDecimal bd = (BigDecimal) value;
            int intValue = bd.intValue();
            return intValue == 1
                    ? Boolean.TRUE
                    : Boolean.FALSE;
        }

        return Boolean.FALSE;
    }

}
