package vn.com.vndirect.lib.commonlib.velocity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VelocityTemplateDemo implements Serializable {
	private String name;

	public VelocityTemplateDemo(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}