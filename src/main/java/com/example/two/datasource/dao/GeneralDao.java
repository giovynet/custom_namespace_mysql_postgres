package com.example.two.datasource.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GeneralDao {
	
	
	@Autowired
	@Qualifier("jdbcTemplateMysql")
    private JdbcTemplate jdbcTemplateMysql;
	
	@Autowired
	@Qualifier("jdbcTemplatePostgres")
    private JdbcTemplate jdbcTemplatePostgres;
	
	public List<String> selectColorsFromMysql() {
		String sql = "SELECT name FROM tbl_color";

		List<String> response = jdbcTemplateMysql.query(sql, new RowMapper<String>(){
            public String mapRow(ResultSet rs, int rowNum)  
                                         throws SQLException {
                    return rs.getString(1);
            }
       });

		return response;
	}
	
	
	public List<String> selectCitiesFromPostgres() {
		String sql = "SELECT tc.name FROM \"public\".tbl_cities tc";

		List<String> response = jdbcTemplatePostgres.query(sql, new RowMapper<String>(){
            public String mapRow(ResultSet rs, int rowNum) 
                                         throws SQLException {
                    return rs.getString(1);
            }
       });

		return response;
	}
	
	

}
