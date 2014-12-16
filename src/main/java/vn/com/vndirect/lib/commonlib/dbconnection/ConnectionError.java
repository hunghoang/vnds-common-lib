package vn.com.vndirect.lib.commonlib.dbconnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vn.com.vndirect.lib.commonlib.file.FileUtils;

public class ConnectionError {

	
	private static List<String> DATABASE_CONNECTION_ERROR_MESSAGES = new ArrayList<String>();
	
	static {
		try {
			List<String> lines = FileUtils.readFileByLine("connectionerror.txt");
			for (String line : lines) {
				DATABASE_CONNECTION_ERROR_MESSAGES.add(line);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static boolean isDatabaseConnectionError(Exception e) {
		String message = e.getMessage();
		for (String errorMessage : DATABASE_CONNECTION_ERROR_MESSAGES) {
			if (message.contains(errorMessage)) {
				return true;
			}
		}
		return false;
	}

}
