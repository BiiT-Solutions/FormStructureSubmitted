package com.biit.form.submitted.serialization.jackson;

import com.biit.form.submitted.implementation.SubmittedQuestion;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubmittedQuestionSerializer extends SubmittedObjectSerializer<SubmittedQuestion> {

    @Override
    public void serialize(SubmittedQuestion src, JsonGenerator jgen) throws IOException {
        super.serialize(src, jgen);

        jgen.writeFieldName("answers");
        jgen.writeStartArray("answers");
        final List<String> answers = new ArrayList<>(src.getAnswers());
        Collections.sort(answers);
        for (String value : answers) {
            jgen.writeString(value);
        }
        jgen.writeEndArray();
    }
}
