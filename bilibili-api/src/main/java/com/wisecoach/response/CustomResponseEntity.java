package com.wisecoach.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponseEntity implements Serializable {
    private int code;
    private String msg;
    private Object data;
}
