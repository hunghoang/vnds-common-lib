package vn.com.vndirect.lib.commonlib.properties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vn.com.vndirect.lib.commonlib.file.FileUtils;
import vn.com.vndirect.lib.commonlib.properties.OrderedProperties;

public class OrderedPropertiesTest {
	
	private Properties properties;
	@Before
	public void setUp() throws IOException {
		 properties = new OrderedProperties();
		 properties.load(FileUtils.getInputStream("file.properties"));
	}
	
	@Test
	public void testOrderedProperties() {
		List<String> propsList = new ArrayList<String>();
		for (Enumeration e = properties.propertyNames(); e.hasMoreElements();) {
			String name =(String) e.nextElement();
			propsList.add(name);
		}
		
		Assert.assertEquals("propertyname2", propsList.get(0));
		Assert.assertEquals("propertyname1", propsList.get(1));
		Assert.assertEquals("propertyname3", propsList.get(2));
		
	}

}
