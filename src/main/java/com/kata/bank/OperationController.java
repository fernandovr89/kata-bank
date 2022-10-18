package com.kata.bank;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class OperationController {

  @PostMapping(
    value = "/deposit",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<?> deposit(@Valid @RequestBody Operation operation, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) return new ResponseEntity<>(
            bindingResult.getAllErrors(),
            HttpStatus.BAD_REQUEST
    ); else return new ResponseEntity<>(
      "{ \"responseMessage\": \"Success\", \"amount\": \"" + operation.getAmount() + "\"}",
      HttpStatus.OK
    );
  }
}
