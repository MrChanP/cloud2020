package com.cp.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommontResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommontResult(Integer code, String message) {
        this(code, message, null);
    }
}
