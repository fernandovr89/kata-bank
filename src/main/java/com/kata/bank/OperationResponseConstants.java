package com.kata.bank;

public class OperationResponseConstants {

  public static final String SUCCESS_RESPONSE = "{ \"responseMessage\": \"Operation completed successfully\" }";
  public static final String INVALID_DEPOSIT_RESPONSE =
    "{ \"responseMessage\": \"Deposit operation ist not valid. The account balance has reached the maximum value\" }";
  public static final String INVALID_WITHDRAW_RESPONSE =
    "{ \"responseMessage\": \"Withdraw operation ist not valid. The account balance is not enough\" }";
}
