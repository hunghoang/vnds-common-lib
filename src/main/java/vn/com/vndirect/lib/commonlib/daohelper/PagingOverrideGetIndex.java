package vn.com.vndirect.lib.commonlib.daohelper;

import vn.com.web.commons.domain.db.PagingInfo;

@SuppressWarnings("serial")
public class PagingOverrideGetIndex extends PagingInfo {

	private int startIndex;

	public PagingOverrideGetIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	@Override
	public int getIndex() {
		return startIndex;
	}

	@Override
	public String toString() {
		return super.toString().replace(" ", "");
	}
}
