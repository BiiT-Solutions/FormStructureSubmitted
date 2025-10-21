package com.biit.form.submitted.serialization.jackson;

/*-
 * #%L
 * Form Structure Submitted Answers
 * %%
 * Copyright (C) 2015 - 2025 BiiT Sourcing Solutions S.L.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

import com.biit.form.submitted.implementation.SubmittedObject;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class SubmittedObjectSerializer<T extends SubmittedObject> extends StdSerializer<T> {
    private static final String TIMESTAMP_FORMAT = "dd-MM-yyyy HH:mm:ss";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern(TIMESTAMP_FORMAT);
    private static final String OLD_TIMESTAMP_FORMAT = "MMM d, yyyy h:mm:ss a";
    private static final DateTimeFormatter OLD_TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern(OLD_TIMESTAMP_FORMAT);

    public SubmittedObjectSerializer() {
        this(null);
    }

    public SubmittedObjectSerializer(Class<T> aClass) {
        super(aClass);
    }

    @Override
    public void serialize(T src, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        serialize(src, jgen);
        jgen.writeEndObject();
    }

    public void serialize(T src, JsonGenerator jgen) throws IOException {
        jgen.writeStringField("class", src.getClass().getName());
        if (src.getTag() != null) {
            jgen.writeStringField("tag", src.getTag());
        }
        if (src.getText() != null) {
            jgen.writeStringField("text", src.getText());
        }

        jgen.writeFieldName("children");
        jgen.writeStartArray("children");
        for (SubmittedObject child : src.getChildren()) {
            jgen.writeObject(child);
        }
        jgen.writeEndArray();
    }
}
