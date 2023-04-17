package com.appdeveloperblog.estore.ProductsService.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProductAggregate {

  public ProductAggregate() {
  }

  @CommandHandler
  public ProductAggregate(CreateProductCommand createProductCommand) {
    // Validate CreateProductCommand
  }
}
