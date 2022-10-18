package com.kata.bank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Operation {

  @NotNull(message = "The field amount is mandatory")
  @Positive(message = "The operation amount must be greater than zero")
  private Double amount;

  public Operation() {}

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }
}
