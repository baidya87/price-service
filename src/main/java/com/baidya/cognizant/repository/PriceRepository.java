package com.baidya.cognizant.repository;

import com.baidya.cognizant.pojo.Price;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PriceRepository {

    private final DataSource dataSource;

    public PriceRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Price fetchPrice(String event) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from eventdb.price where event='"+event+"';");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
           return new Price(resultSet.getInt(1), resultSet.getString(2), resultSet.getFloat(3), resultSet.getFloat(4));
        }
        return null;
    }
}
