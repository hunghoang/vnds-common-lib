package vn.com.vndirect.lib.commonlib.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Load input stream from file in absolute directory or current class loader
 */
public class FileUtils {

	public static InputStream getInputStream(String configFile) throws IOException {
		File file = new File(configFile);
		if (file.exists()) {
			return new BufferedInputStream(new FileInputStream(file));
		}
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = cl.getResourceAsStream(configFile);
		if (inputStream == null) {
			throw new FileNotFoundException("File not found exception: " + configFile);
		}
		return inputStream;
	}
	
	public static List<String> readFileByLine(String file) throws IOException {
		BufferedReader br = null;
		try {
			InputStream input = getInputStream(file);
			List<String> lines = new ArrayList<String>();
			br = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			return lines;
		} finally {
			if (br != null)
				br.close();
		}
	}

}
