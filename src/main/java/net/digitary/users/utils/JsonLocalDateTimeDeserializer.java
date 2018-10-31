package net.digitary.users.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.core.serializer.Deserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {


    /**
     * The date format of the json serialized datetime
     */
    private  static final String DATE_FORMAT="dd/MM/yyyy HH:mm:ss.S";
    /**
     * It translate the text in datetime object.
     */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);


    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String source= jp.getText();
       if ((source ==null) || ("".equals(source)))
            return null;
        LocalDateTime localDateTime=LocalDateTime.parse(source, FORMATTER);


        return localDateTime;

    }
}
