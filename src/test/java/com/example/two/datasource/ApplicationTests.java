package com.example.two.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.two.datasource.dao.GeneralDao;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	@Qualifier("ds-postgres")
	DataSource dsPostgres;
	
	@Autowired
	GeneralDao generalDao;

	@Autowired
	@Qualifier("ds-mysql")
	DataSource dsMysql;
	
	@Test
	void dsMysqlTest() throws SQLException {
		Connection connection = dsMysql.getConnection();
		Assert.notNull(connection, "Connection is NULL...");		
		
		List<String> lst = generalDao.selectColorsFromMysql();
		lst.forEach(System.out::println);
	
	}

	@Test
	void dsPostgresTest() throws SQLException {
		Connection connection = dsPostgres.getConnection();
		Assert.notNull(connection, "Connection is NULL...");		

		List<String> lst = generalDao.selectCitiesFromPostgres();
		lst.forEach(System.out::println);

	}

	
	
}
