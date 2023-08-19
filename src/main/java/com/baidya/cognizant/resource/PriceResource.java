package com.baidya.cognizant.resource;

import com.baidya.cognizant.pojo.Price;
import com.baidya.cognizant.service.PriceService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "prices")
public class PriceResource {
    private final PriceService priceService;
    public PriceResource(PriceService priceService) {
        this.priceService = priceService;
    }
    @GetMapping(path = "/{event}")
    public ResponseEntity<EntityModel<Price>> get(@PathVariable("event") String event){
        Price price = priceService.getPrice(event);
        EntityModel<Price> entityModel = EntityModel.of(price);
        return ResponseEntity.ok(entityModel);
    }

    @GetMapping(path = "/test")
    public String welcome(){
        return "Welcome test!";
    }
}
