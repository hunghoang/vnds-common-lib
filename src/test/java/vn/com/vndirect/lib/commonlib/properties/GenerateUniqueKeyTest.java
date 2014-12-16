package vn.com.vndirect.lib.commonlib.properties;

import org.junit.Assert;
import org.junit.Test;

public class GenerateUniqueKeyTest {
	
	@Test
	public void testGetUUID() throws Exception{
		GenerateUniqueKey generateProperty = new GenerateUniqueKey();
		generateProperty.setGeneratedPropertyName("aaaa");
		generateProperty.afterPropertiesSet();
		
		Assert.assertNotNull(System.getProperty("aaaa"));
	}
}
