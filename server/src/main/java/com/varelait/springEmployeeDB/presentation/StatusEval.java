package com.varelait.springEmployeeDB.presentation;

import org.springframework.http.HttpStatus;

public class StatusEval {
    public static HttpStatus object(Object object){
        if (object == null)
            return HttpStatus.BAD_REQUEST;
        else
            return HttpStatus.OK;
    }
}
