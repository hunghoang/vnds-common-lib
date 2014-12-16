package vn.com.vndirect.lib.commonlib.dbconnection;

import org.junit.Assert;
import org.junit.Test;

public class ConnectionErrorTest {

	@Test
	public void testDetectDatabaseConnectionErrorWithIOException() {
		Exception exception = new Exception("Io exception: Connection reset by peer: socket write error");
		boolean connectionError = ConnectionError.isDatabaseConnectionError(exception);
		Assert.assertTrue("Connection is not lost", connectionError);
	}
	
	@Test
	public void testDetectDatabaseConnectionErrorWithNoDataReadFromSocket() {
		Exception exception = new Exception("No more data to read from socket");
		boolean connectionError = ConnectionError.isDatabaseConnectionError(exception);
		Assert.assertTrue("Connection is not lost", connectionError);
	}
	
	@Test
	public void testDetectDatabaseConnectionErrorWithBrokenPipe() {
		Exception exception = new Exception("Io exception: Broken pipe");
		boolean connectionError = ConnectionError.isDatabaseConnectionError(exception);
		Assert.assertTrue("Connection is not lost", connectionError);
	}
	
	@Test
	public void testDetectDatabaseConnectionErrorWithNoMessageDefinitionShouldFail() {
		Exception exception = new Exception("Socket error is not defined in file");
		boolean connectionError = ConnectionError.isDatabaseConnectionError(exception);
		Assert.assertFalse("Connection is lost", connectionError);
	}
	
	
}
