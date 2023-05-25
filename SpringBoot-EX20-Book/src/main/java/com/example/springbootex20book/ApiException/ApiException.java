package com.example.springbootex20book.ApiException;

public class ApiException  extends RuntimeException{

    public ApiException(String message){
        super(message);
    }
}
