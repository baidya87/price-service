package com.baidya.cognizant.service;

import com.baidya.cognizant.pojo.Price;
import com.baidya.cognizant.repository.PriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PriceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceService.class);
    private final PriceRepository priceRepository;
    public PriceService(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }
    public Price getPrice(String event){
        Price price = null;
        try{
            price = priceRepository.fetchPrice(event);
        }catch(SQLException sqlException){
            LOGGER.error(sqlException.getMessage());
        }
        return price;
    }
}
