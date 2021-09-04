package com.example.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Generated
@AllArgsConstructor
public class ExceptionResponse {
    private LocalDate timeStamp;
    private String message;
    private String details;
    private String type;
}
