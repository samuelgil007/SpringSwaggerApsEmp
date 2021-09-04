package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.IM_USED)
public class ResourceAlreadyFound extends  Exception {
    public ResourceAlreadyFound(){
        super();
    }

    public ResourceAlreadyFound(String message, Throwable cause){
        super(message, cause);
    }

    public ResourceAlreadyFound(String message){
        super(message);
    }
}
