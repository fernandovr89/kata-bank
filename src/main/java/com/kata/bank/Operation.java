package com.kata.bank;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Operation {

  @NotNull(message = "The field amount is mandatory")
  @Positive(message = "The operation amount must be greater than zero")
  private Double amount;

  private LocalDateTime date;

  private Double balance;

  private OperationType operationType;

  public Operation() {}

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public OperationType getOperationType() {
    return operationType;
  }

  public void setOperationType(OperationType operationType) {
    this.operationType = operationType;
  }
}
