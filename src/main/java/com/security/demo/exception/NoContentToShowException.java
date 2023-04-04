package com.security.demo.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoContentToShowException extends RuntimeException {

    public NoContentToShowException(String message) {
        super(message);
    }
}
