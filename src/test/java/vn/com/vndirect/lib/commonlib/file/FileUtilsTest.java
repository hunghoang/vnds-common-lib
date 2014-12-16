package vn.com.vndirect.lib.commonlib.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FileUtilsTest {
	
	@Test
	public void testLoadInputStreamInCurrentClassLoader() throws IOException {
		InputStream inputStream = FileUtils.getInputStream("file.properties");
		Assert.assertNotNull(inputStream);
		Assert.assertTrue("inputStream does not contain data", inputStream.available() > 0);
	}
	
	@Test(expected=IOException.class)
	public void testLoadInputStreamInWithNonExistedFileShouldThrowException() throws IOException {
		String nonExistedfile = "file.properties1";
		FileUtils.getInputStream(nonExistedfile);
	}
	
	@Test
	public void testLoadInputStreamInAbsoluteDirectory() throws IOException {
		File file = File.createTempFile("test", "txt");
		InputStream inputStream = FileUtils.getInputStream(file.getAbsolutePath());
		Assert.assertNotNull(inputStream);
		file.deleteOnExit();
	}
	
	@Test
	public void testLoadFileByLine() throws IOException {
		List<String> lines = FileUtils.readFileByLine("file.properties");
		Assert.assertEquals(4, lines.size());
		Assert.assertTrue("file does not contain line: propertyname2=propertyvalue2", lines.contains("propertyname2=propertyvalue2"));
		Assert.assertTrue("file does not contain line: propertyname1=propertyvalue1", lines.contains("propertyname1=propertyvalue1"));
		Assert.assertTrue("file does not contain line: propertyname3=propertyvalue3", lines.contains("propertyname3=propertyvalue3"));
		Assert.assertTrue("file does not contain line: property", lines.contains("property"));
	}
	
	@Test(expected=IOException.class)
	public void testLoadFileByLineWithFileNotFound() throws IOException {
		FileUtils.readFileByLine("file-not-found.properties");
	}

}
