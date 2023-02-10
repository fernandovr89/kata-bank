package com.kata.bank;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
