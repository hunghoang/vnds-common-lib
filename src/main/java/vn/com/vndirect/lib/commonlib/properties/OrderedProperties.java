package vn.com.vndirect.lib.commonlib.properties;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * load properties sequential
 * 
 * @author Brian Wing Shun Chan
 */
@SuppressWarnings("serial")
public class OrderedProperties extends Properties {

	private Vector<String> vector;
	
	public OrderedProperties() {
		super();

		vector = new Vector<String>();
	}

	public Enumeration<String> propertyNames() {
		return vector.elements();
	}

	public Object put(Object key, Object value) {
		if (vector.contains(key)) {
			vector.remove(key);
		}

		vector.add(String.valueOf(key));

		return super.put(key, value);
	}

	public Object remove(Object key) {
		vector.remove(key);

		return super.remove(key);
	}


}
