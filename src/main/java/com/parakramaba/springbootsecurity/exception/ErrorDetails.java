package com.parakramaba.springbootsecurity.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErrorDetails {

    private int status;
    private String error;
    private String message;
    private LocalDateTime dateTime;
    private Object data;

}
