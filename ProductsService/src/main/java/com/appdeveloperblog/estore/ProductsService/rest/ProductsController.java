package com.appdeveloperblog.estore.ProductsService.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdeveloperblog.estore.ProductsService.command.CreateProductCommand;

// @RestController is a convenience annotation that combines @Controller and @ResponseBody
@RestController
@RequestMapping("/products") // http://localhost:8080/products
public class ProductsController {

  @Autowired
  private Environment env;

  @PostMapping
  public String createProduct(@RequestBody CreateProductRestModel createProductRestModel) {

    CreateProductCommand createProductCommand = CreateProductCommand.builder()
        .price(createProductRestModel.getPrice())
        .quantity(createProductRestModel.getQuantity())
        .title(createProductRestModel.getTitle())
        .productId(UUID.randomUUID().toString())
        .build();

    return "HTTP POST Handled " + createProductRestModel.getTitle();
  }

  @GetMapping
  public String getProduct() {
    return "HTTP GET Handled " + env.getProperty("local.server.port");
  }

  @PutMapping
  public String updateProduct() {
    return "HTTP PUT Handled";
  }

  @DeleteMapping
  public String deleteProduct() {
    return "HTTP DELETE Handled";
  }
}
