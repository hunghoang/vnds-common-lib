package vn.com.vndirect.lib.commonlib.text;

import org.jsoup.Jsoup;

public class HtmlTagCleanerImpl implements HtmlTagCleaner {

	@Override
	public String clean(String html) {
		return Jsoup.parse(html).text();
	}
}
