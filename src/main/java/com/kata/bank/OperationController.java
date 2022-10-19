package com.kata.bank;

import static com.kata.bank.OperationResponseConstants.*;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OperationController {

  @Autowired
  OperationService operationService;

  @PostMapping(
    value = "/deposit",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<?> deposit(@Valid @RequestBody Operation operation, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) return new ResponseEntity<>(
      bindingResult.getAllErrors(),
      HttpStatus.BAD_REQUEST
    ); else if (!operationService.isAValidDepositOperation(operation)) return new ResponseEntity<>(
      INVALID_DEPOSIT_RESPONSE,
      HttpStatus.BAD_REQUEST
    ); else {
      operationService.storeOperationWithType(operation, OperationType.DEPOSIT);
      return new ResponseEntity<>(SUCCESS_RESPONSE, HttpStatus.OK);
    }
  }

  @PostMapping(
    value = "/withdraw",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<?> withdraw(@Valid @RequestBody Operation operation, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) return new ResponseEntity<>(
      bindingResult.getAllErrors(),
      HttpStatus.BAD_REQUEST
    ); else if (!operationService.isAValidWithdrawOperation(operation)) return new ResponseEntity<>(
      INVALID_WITHDRAW_RESPONSE,
      HttpStatus.BAD_REQUEST
    ); else {
      operationService.storeOperationWithType(operation, OperationType.WITHDRAW);
      return new ResponseEntity<>(SUCCESS_RESPONSE, HttpStatus.OK);
    }
  }

  @GetMapping(value = "/history", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> history() {
    return new ResponseEntity<>(operationService.getOperationHistory(), HttpStatus.OK);
  }

  @GetMapping(value = "/reset", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> reset() {
    operationService.resetOperationHistory();
    return new ResponseEntity<>(SUCCESS_RESPONSE, HttpStatus.OK);
  }
}
