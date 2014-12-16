package vn.com.vndirect.lib.commonlib.properties;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.InitializingBean;

public class GenerateUniqueKey implements InitializingBean{

	private String generatedPropertyName;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty(generatedPropertyName, generateValue());
	}

	private String generateValue() throws UnknownHostException {
		StringBuilder uuid = new StringBuilder();
		uuid.append(UUID.randomUUID().toString()).append(new Date().getTime());
		uuid.append(InetAddress.getLocalHost().getHostName());
		return uuid.toString();
	}

	public void setGeneratedPropertyName(String generatedPropertyName) {
		this.generatedPropertyName = generatedPropertyName;
	}

}
