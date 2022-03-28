package com.biit.form.submitted;

import com.biit.form.submitted.implementation.SubmittedCategory;
import com.biit.form.submitted.implementation.SubmittedForm;
import com.biit.form.submitted.implementation.SubmittedQuestion;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

@Test(groups = "jsonTests")
public class JsonTests {
	private static final String OUTPUT_SERIALIZATION_PATH = System.getProperty("java.io.tmpdir") + File.separator
			+ "SerializedSubmittedForm.json";

	private SubmittedForm form;
	private String originalJsonText;

	private SubmittedForm createForm() {
		SubmittedForm form = new SubmittedForm();
		form.setText("This is a form");
		form.setTag("Form");

		SubmittedCategory category = new SubmittedCategory("Category1");
		category.setText("This is a category");
		form.addChild(category);

		SubmittedQuestion question = new SubmittedQuestion("Question1");
		question.setText("This is a question");
		question.setAnswers(new HashSet<>(Arrays.asList("Answer1", "Answer2", "Answer3")));
		category.addChild(question);

		return form;
	}

	@BeforeTest
	public void init() {
		form = createForm();
	}

	@Test
	public void serialize() throws IOException {
		originalJsonText = form.toJson();
		Assert.assertNotNull(originalJsonText);
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_SERIALIZATION_PATH)), true)) {
			out.println(originalJsonText);
		}
	}

	@Test(dependsOnMethods = "serialize")
	public void deserialize() throws IOException {
		final String jsonText = new String(Files.readAllBytes(Paths.get(OUTPUT_SERIALIZATION_PATH)),
				StandardCharsets.UTF_8.name());
		SubmittedForm form = SubmittedForm.getFromJson(jsonText);
		Assert.assertNotNull(form.getChild(SubmittedCategory.class, "Category1"));
		Assert.assertNotNull(form.getChild(SubmittedQuestion.class, "Question1"));
		Assert.assertTrue(form.getChild(SubmittedQuestion.class, "Question1").getAnswers().contains("Answer1"));
		Assert.assertTrue(form.getChild(SubmittedQuestion.class, "Question1").getAnswers().contains("Answer2"));
		Assert.assertTrue(form.getChild(SubmittedQuestion.class, "Question1").getAnswers().contains("Answer3"));
		Assert.assertEquals(jsonText.trim(), originalJsonText.trim());
	}
}
