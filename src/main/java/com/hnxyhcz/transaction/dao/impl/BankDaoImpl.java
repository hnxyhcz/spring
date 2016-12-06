package com.hnxyhcz.transaction.dao.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.hnxyhcz.transaction.dao.BankDao;

public class BankDaoImpl implements BankDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setNamedParameterJdbcTemplate(
		NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void inMoney(int money, int userId) {
		String UPDATE_SQL = "update t_count2 set count = count+:money where userId = :userId";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("money", money);
		params.addValue("userId", userId);
		namedParameterJdbcTemplate.update(UPDATE_SQL, params);
	}

	@Override
	public void outMoney(int money, int userId) {
		String UPDATE_SQL = "update t_count set count = count-:money where userId = :userId";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("money", money);
		params.addValue("userId", userId);
		namedParameterJdbcTemplate.update(UPDATE_SQL, params);
	}

}
