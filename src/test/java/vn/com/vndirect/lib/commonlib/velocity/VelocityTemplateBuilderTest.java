package vn.com.vndirect.lib.commonlib.velocity;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.generic.DateTool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vn.com.vndirect.lib.commonlib.velocity.VelocityTemplateBuilderImpl;

public class VelocityTemplateBuilderTest {

	private static final String TEMPALTE_PATH_KEY_TEST = "keypath";
	private static final String TEMPALTE_PATH_TEST = "template/template.vm";

	private Map<String, String> templatePathMap;

	private VelocityTemplateBuilderImpl templateBuilder;

	@Before
	public void setUp() {
		templatePathMap = new HashMap<String, String>();
		templatePathMap.put(TEMPALTE_PATH_KEY_TEST, TEMPALTE_PATH_TEST);

		templateBuilder = new VelocityTemplateBuilderImpl(templatePathMap);
	}

	@Test(expected = Exception.class)
	public void testInvalidPath() throws Exception {
		templateBuilder.buildMessage("an invalid path", null);
	}

	@Test(expected = Exception.class)
	public void testNullVelocityEngine() throws Exception {
		templateBuilder = new VelocityTemplateBuilderImpl(null, templatePathMap);

		templateBuilder.buildMessage(TEMPALTE_PATH_KEY_TEST, null);
	}

	@Test(expected = Exception.class)
	public void testInvalidVelocityEngine() throws Exception {
		templateBuilder = new VelocityTemplateBuilderImpl(new VelocityEngine(), templatePathMap);

		templateBuilder.buildMessage(TEMPALTE_PATH_KEY_TEST, null);
	}

	@Test
	public void testTemplateBuilder() throws Exception {
		String name = "asdasdasdsa";

		VelocityContext context = new VelocityContext();
		context.put("model", new VelocityTemplateDemo(name));
		context.put("date", new DateTool());

		String result = templateBuilder.buildMessage(TEMPALTE_PATH_KEY_TEST, context);

		System.out.println(result);

		Assert.assertTrue(result.contains(name));
	}
}
