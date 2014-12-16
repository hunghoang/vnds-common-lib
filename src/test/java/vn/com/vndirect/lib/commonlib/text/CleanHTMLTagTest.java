package vn.com.vndirect.lib.commonlib.text;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CleanHTMLTagTest {

	private String contentAfterClear;
	private HtmlTagCleaner htmlTagCleaner;
	
	@Before
	public void setUp() {
		htmlTagCleaner = new HtmlTagCleanerImpl();
	}
	
	@Test
	public void testSimple() {
		String html = "<a>content</a>";

		contentAfterClear = htmlTagCleaner.clean(html);

		Assert.assertEquals("content", contentAfterClear);
	}

	@Test
	public void testSingleTag() {
		String html = "<a>content</a><br />";

		contentAfterClear = htmlTagCleaner.clean(html);

		Assert.assertEquals("content", contentAfterClear);
	}

	@Test
	public void testNbsp() {
		String html = "<a>content&nbsp;</a><br />";

		contentAfterClear = htmlTagCleaner.clean(html);

		Assert.assertEquals("content ", contentAfterClear);
	}

	@Test
	public void testDataHasGreaterThanSymbol() {
		String html = "<a>content<</a><br />";

		contentAfterClear = htmlTagCleaner.clean(html);

		Assert.assertEquals("content<", contentAfterClear);
	}

}
