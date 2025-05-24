package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

public class DataUtil {

    public static final String FORMATO_DTH_PADRAO = "dd/MM/yyyy HH:mm:ss";
    public static final String FORMATO_DT_PADRAO = "dd/MM/yyyy";

    public static String getDataFormatada(LocalDate data) {
        return data.format(ofPattern(FORMATO_DT_PADRAO));
    }

    public static String getDataFormatada(LocalDateTime data) {
        return data.format(ofPattern(FORMATO_DTH_PADRAO));
    }
    public static LocalDateTime dataStringToLocalDateTime(String data) {
         return LocalDateTime.parse(data,ofPattern(FORMATO_DTH_PADRAO));
    }
}
