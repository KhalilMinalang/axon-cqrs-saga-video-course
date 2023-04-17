package com.appdeveloperblog.estore.ProductsService.command;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.appdeveloperblog.estore.ProductsService.core.events.ProductCreatedEvent;

@Aggregate
public class ProductAggregate {

  public ProductAggregate() {
  }

  @CommandHandler
  public ProductAggregate(CreateProductCommand createProductCommand) {
    // Validate CreateProductCommand

    if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Price cannot be less or equal than zero");
    }

    if (createProductCommand.getTitle() == null || createProductCommand.getTitle().isBlank()) {
      throw new IllegalArgumentException("Title cannot be empty");
    }

    ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();

    BeanUtils.copyProperties(createProductCommand, productCreatedEvent);

    AggregateLifecycle.apply(productCreatedEvent);

  }
}
