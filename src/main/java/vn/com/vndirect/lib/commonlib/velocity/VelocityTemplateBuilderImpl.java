package vn.com.vndirect.lib.commonlib.velocity;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class VelocityTemplateBuilderImpl implements VelocityTemplateBuilder {

	private Map<String, Template> templateMap;
	
	public VelocityTemplateBuilderImpl(Map<String, String> templatePaths) {
		
		VelocityEngine velocityEngine = _createVelocityEngine();
		
		templateMap = new HashMap<String, Template>();
		
		for(Map.Entry<String, String> entry : templatePaths.entrySet()) {
			Template template = velocityEngine.getTemplate(entry.getValue());
			templateMap.put(entry.getKey(), template);
		}
	}

	public VelocityTemplateBuilderImpl(VelocityEngine velocityEngine, Map<String, String> templatePaths) {
		templateMap = new HashMap<String, Template>();
		
		for(Map.Entry<String, String> entry : templatePaths.entrySet()) {
			Template template = velocityEngine.getTemplate(entry.getValue());
			templateMap.put(entry.getKey(), template);
		}
	}

	public String buildMessage(String key, VelocityContext context) throws Exception {
		StringWriter writer = new StringWriter();
		Template template = templateMap.get(key);

		template.merge(context, writer);

		return writer.toString();
	}
	
	private VelocityEngine _createVelocityEngine() {
		Properties properties = _createProperties();
		
		return new VelocityEngine(properties);
	}
	
	private Properties _createProperties() {
		Properties properties = new Properties();
		properties.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		properties.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		
		return properties;
	}
}
