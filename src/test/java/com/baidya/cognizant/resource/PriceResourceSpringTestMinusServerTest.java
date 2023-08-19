package com.baidya.cognizant.resource;

import com.baidya.cognizant.pojo.Price;
import com.baidya.cognizant.service.PriceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceResourceSpringTestMinusServerTest {

    @MockBean
    private PriceService priceService;

    @Autowired
    private MockMvc mockMvc;

   @Test
    public void testGet() throws Exception {
        Mockito.when(priceService.getPrice(Mockito.anyString())).thenReturn(new Price(1, "soccer", 20.9f, 13.0f));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices/soccer")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGet2() throws Exception {
        Mockito.when(priceService.getPrice(Mockito.anyString())).thenReturn(new Price(1, "soccer", 20.9f, 13.0f));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/prices/soccer")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "  \"id\" : 1,\n" +
                        "  \"event\" : \"soccer\",\n" +
                        "  \"price\" : 20.9,\n" +
                        "  \"tax\" : 13.0\n" +
                        "}"));
    }
    @Test
    public void testWelcome() throws Exception {
       this.mockMvc.perform(MockMvcRequestBuilders.get("/prices/test")).andDo(MockMvcResultHandlers.print())
               .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("Welcome test!"));
    }

}
