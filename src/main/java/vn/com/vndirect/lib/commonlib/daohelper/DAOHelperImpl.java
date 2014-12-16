package vn.com.vndirect.lib.commonlib.daohelper;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import oracle.sql.BLOB;
import oracle.sql.CLOB;

import org.springframework.jdbc.core.RowMapper;

import vn.com.web.commons.dao.jdbc.OracleDAOHelper;
import vn.com.web.commons.domain.db.PagingInfo;
import vn.com.web.commons.domain.db.SearchResult;
import vn.com.web.commons.exception.SystemException;

public class DAOHelperImpl implements DAOHelper {
	
	private DataSource dataSource;
	
	public DAOHelperImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public long nextval(String seq) throws SystemException {
		return OracleDAOHelper.nextval(dataSource, seq);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int query4Int(String sql, Map paramMap) throws SystemException {
		return OracleDAOHelper.query4Int(dataSource, sql, paramMap);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public long query4Long(String sql, Map paramMap) throws SystemException {
		return OracleDAOHelper.query4Long(dataSource, sql, paramMap);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public double query4Double(String sql, Map paramMap) throws SystemException {
		return OracleDAOHelper.query4Double(dataSource, sql, paramMap);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String populateReplaceableParam(String sql, Map replareableParam) throws SystemException {
		return OracleDAOHelper.populateReplaceableParam(sql, replareableParam);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public SearchResult query(String sql, Map paramMap, RowMapper rowMapper) throws SystemException {
		return OracleDAOHelper.query(dataSource, sql, paramMap, rowMapper);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public SearchResult queryWithPagging(String sql, Map paramMap, RowMapper rowMapper,
			PagingInfo pagingInfo) throws SystemException {
		return OracleDAOHelper.queryWithPagging(dataSource, sql, paramMap, rowMapper, pagingInfo);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object querySingle(String sql, Map paramMap, RowMapper rowMapper) throws SystemException {
		return OracleDAOHelper.querySingle(dataSource, sql, paramMap, rowMapper);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public SearchResult query(String sql, Map paramMap, RowMapper rowMapper, PagingInfo pagingInfo)
			throws SystemException {
		return OracleDAOHelper.query(dataSource, sql, paramMap, rowMapper, pagingInfo);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int update(String sql, Map paramMap) throws SystemException {
		return OracleDAOHelper.update(dataSource, sql, paramMap);
	}

	@Override
	public byte[] getBlobColumn(ResultSet rs, int columnIndex) throws SQLException {
		return OracleDAOHelper.getBlobColumn(rs, columnIndex);
	}

	@Override
	public String getClobColumn(ResultSet rs, int columnIndex) throws SQLException {
		return OracleDAOHelper.getClobColumn(rs, columnIndex);
	}

	@Override
	public byte[] getBlobColumn(ResultSet rs, String column) throws SQLException {
		return OracleDAOHelper.getBlobColumn(rs, column);
	}

	@Override
	public String getClobColumn(ResultSet rs, String column) throws SQLException {
		return OracleDAOHelper.getClobColumn(rs, column);
	}

	@Override
	public String getClob(Clob clob) throws SQLException {
		return OracleDAOHelper.getClob(clob);
	}

	@Override
	public byte[] getBlob(Blob blob) throws SQLException {
		return OracleDAOHelper.getBlob(blob);
	}

	@Override
	public CLOB convert2CLOB(Connection con, String strContent) throws SystemException {
		return OracleDAOHelper.convert2CLOB(con, strContent);
	}

	@Override
	public BLOB convert2BLOB(Connection con, byte[] arrContent) throws SystemException {
		return OracleDAOHelper.convert2BLOB(con, arrContent);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public SearchResult queryPagingWithStartAndEndIndex(String sql, Map paramMap, RowMapper rowMapper, int startIndex, int offset) throws SystemException {
		PagingOverrideGetIndex pagingInfo = new PagingOverrideGetIndex(startIndex);
		pagingInfo.setOffset(offset);
		
		return queryWithPagging(sql, paramMap, rowMapper, pagingInfo);
	}
}
