package net.digitary.users.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * This class serialize the object LocalDateTime in proper json format
 */
public class JsonLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {


    /**
     * The date format of the json serialized datetime
     */
    private  static final String DATE_FORMAT="dd/MM/yyyy HH:mm:ss.S";
    /**
     * It translate the datetime in text format.
     */
       private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    @Override
    public void serialize(LocalDateTime dateTime,
                          JsonGenerator gen, SerializerProvider serializers) throws IOException,
            JsonProcessingException {
        if (dateTime==null){
            gen.writeNull();
        }else {

            gen.writeString(dateTime.format(FORMATTER));
        }

    }
}
