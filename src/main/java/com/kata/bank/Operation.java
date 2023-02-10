package com.kata.bank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
@NoArgsConstructor
public class Operation {

  @NotNull(message = "The field amount is mandatory")
  @Positive(message = "The operation amount must be greater than zero")
  private Double amount;
  private LocalDateTime date;
  private Double balance;
  private OperationType operationType;
}
