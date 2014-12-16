package vn.com.vndirect.lib.commonlib.daohelper;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import oracle.sql.BLOB;
import oracle.sql.CLOB;

import org.springframework.jdbc.core.RowMapper;

import vn.com.web.commons.domain.db.PagingInfo;
import vn.com.web.commons.domain.db.SearchResult;
import vn.com.web.commons.exception.SystemException;

public interface DAOHelper {
	long nextval(String seq) throws SystemException;

	@SuppressWarnings("rawtypes")
	int query4Int(String sql, Map paramMap) throws SystemException;

	@SuppressWarnings("rawtypes")
	long query4Long(String sql, Map paramMap) throws SystemException;

	@SuppressWarnings("rawtypes")
	double query4Double(String sql, Map paramMap) throws SystemException;

	@SuppressWarnings("rawtypes")
	String populateReplaceableParam(String sql, Map replareableParam) throws SystemException;

	@SuppressWarnings("rawtypes")
	SearchResult query(String sql, Map paramMap, RowMapper rowMapper) throws SystemException;

	@SuppressWarnings("rawtypes")
	SearchResult queryWithPagging(String sql, Map paramMap, RowMapper rowMapper, PagingInfo pagingInfo)
			throws SystemException;

	@SuppressWarnings("rawtypes")
	Object querySingle(String sql, Map paramMap, RowMapper rowMapper) throws SystemException;

	@SuppressWarnings("rawtypes")
	SearchResult query(String sql, Map paramMap, RowMapper rowMapper, PagingInfo pagingInfo)
			throws SystemException;

	@SuppressWarnings("rawtypes")
	int update(String sql, Map paramMap) throws SystemException;

	byte[] getBlobColumn(ResultSet rs, int columnIndex) throws SQLException;

	String getClobColumn(ResultSet rs, int columnIndex) throws SQLException;

	byte[] getBlobColumn(ResultSet rs, String column) throws SQLException;

	String getClobColumn(ResultSet rs, String column) throws SQLException;

	String getClob(Clob clob) throws SQLException;

	byte[] getBlob(Blob blob) throws SQLException;

	CLOB convert2CLOB(Connection con, String strContent) throws SystemException;

	BLOB convert2BLOB(Connection con, byte[] arrContent) throws SystemException;
	
	/**
	 * endindex = startIndex + offset
	 */
	@SuppressWarnings("rawtypes")
	SearchResult queryPagingWithStartAndEndIndex(String string, Map paramMap, RowMapper rowMapper, int startIndex, int offset) throws SystemException;
}
