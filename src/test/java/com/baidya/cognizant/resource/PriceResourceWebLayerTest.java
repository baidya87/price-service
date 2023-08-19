package com.baidya.cognizant.resource;

import com.baidya.cognizant.pojo.Price;
import com.baidya.cognizant.service.PriceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PriceResource.class)
public class PriceResourceWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    @Autowired
    private PriceResource priceResource;

    @Test
    public void testInitialization(){
        Assertions.assertNotNull(priceService);
        Assertions.assertNotNull(priceResource);
    }

    @Test
    public void testGet() throws Exception {
        Mockito.when(priceService.getPrice(Mockito.any())).thenReturn(new Price(2, "cricket", 12.3f, 10.2f));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices/cricket")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\" : 2, \"event\":\"cricket\", \"price\":12.3, \"tax\":10.2}"));
    }
}
