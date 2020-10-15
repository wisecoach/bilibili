package com.wisecoach.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponseEntity {
    private int code;
    private String msg;
    private Object data;
}
