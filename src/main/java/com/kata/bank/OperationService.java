package com.kata.bank;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("application")
public class OperationService {

  List<Operation> operationHistory = new LinkedList<>();

  Double currentBalance = 0D;

  public void storeOperationWithType(Operation operation, OperationType operationType) {
    operation.setDate(LocalDateTime.now());
    operation.setAmount(operation.getAmount());
    operation.setOperationType(operationType);
    operation.setBalance(getUpdatedBalanceAfterOperation(operation));

    operationHistory.add(operation);
  }

  public List<Operation> getOperationHistory() {
    return Collections.unmodifiableList(operationHistory);
  }

  private Double getUpdatedBalanceAfterOperation(Operation operation) {
    if (operation.getOperationType() == OperationType.DEPOSIT) return (
      this.currentBalance += operation.getAmount()
    ); else if (operation.getOperationType() == OperationType.WITHDRAW) return (
      this.currentBalance -= operation.getAmount()
    ); else return this.currentBalance;
  }
}