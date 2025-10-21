package com.biit.form.submitted;

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

import com.biit.form.jackson.serialization.ObjectMapperFactory;
import com.biit.form.submitted.implementation.SubmittedForm;
import com.biit.form.submitted.implementation.SubmittedQuestion;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Test(groups = "jacksonTests")
public class JacksonTests {

    private SubmittedForm submittedForm;

    @Test
    public void deserializeFile() throws URISyntaxException, IOException {
        final String baseFormAsJson = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader()
                .getResource("SerializedForm.json").toURI())));
        submittedForm = ObjectMapperFactory.getObjectMapper().readValue(baseFormAsJson, SubmittedForm.class);
        Assert.assertNotNull(submittedForm);
        Assert.assertEquals(submittedForm.getChildren().size(), 1);
        Assert.assertEquals(submittedForm.getChildren().get(0).getChildren().size(), 1);
        Assert.assertEquals(((SubmittedQuestion) (submittedForm.getChild("Category1", "Question1"))).getAnswers().size(), 2);
        Assert.assertTrue(((SubmittedQuestion) (submittedForm.getChild("Category1", "Question1"))).getAnswers().contains("answer1"));
    }

    @Test(dependsOnMethods = "deserializeFile")
    public void serializeFile() throws URISyntaxException, IOException {
        final String jsonText = ObjectMapperFactory.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(submittedForm);
        final String baseFormAsJson = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader()
                .getResource("SerializedForm.json").toURI())));
        Assert.assertEquals(jsonText, baseFormAsJson);
    }
}
