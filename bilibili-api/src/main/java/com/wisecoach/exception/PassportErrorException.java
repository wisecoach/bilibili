package com.wisecoach.exception;

import static com.wisecoach.config.ExceptionConfig.*;

public class PassportErrorException extends ResponseException{
    public PassportErrorException() {
        super();
        this.code = PASSPORT_ERROR_CODE;
        this.msg = PASSPORT_ERROR_MSG;
    }
}
