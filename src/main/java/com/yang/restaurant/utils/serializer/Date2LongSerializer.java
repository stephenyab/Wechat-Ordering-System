package com.yang.restaurant.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @ClassName Date2LongSerializer
 * @Author yang
 * @Date 2020/3/8 15:58
 * @Version 1.0
 */
public class Date2LongSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.getTime() / 1000);
    }
}
