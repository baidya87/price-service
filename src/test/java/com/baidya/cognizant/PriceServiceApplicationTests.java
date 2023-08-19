package com.baidya.cognizant;

import com.baidya.cognizant.pojo.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class PriceServiceApplicationTests {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void testMySqlConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		String query = """
    					select * from eventdb.ticket;
				""";
		ResultSet resultSet = connection.prepareStatement(query).executeQuery();
		while (resultSet.next()){
			System.out.printf(String.format("Ticket[ID: %d, Ticket #: %s, Event: %s, Count: %d, Price: %.2f ]\n", resultSet.getInt(1), resultSet.getString(2),
					resultSet.getString(3), resultSet.getInt(4), resultSet.getFloat(5)));
		}
	}

	@Test
	public void testMySqlConnectionWithJdbcTemplate(){
		String query = """
    					select * from eventdb.price;
				""";
		List<Price> prices = jdbcTemplate.query(query, (rs, row) -> new Price(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4))).stream().collect(Collectors.toList());
		System.out.println(prices);
	}

}
