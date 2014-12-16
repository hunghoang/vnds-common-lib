package vn.com.vndirect.lib.commonlib.velocity;

import org.apache.velocity.VelocityContext;

public interface VelocityTemplateBuilder {

	String buildMessage(String templateFilePath, VelocityContext context) throws Exception;
}
