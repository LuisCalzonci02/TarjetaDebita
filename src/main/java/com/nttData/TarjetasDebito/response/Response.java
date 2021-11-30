package com.nttData.TarjetasDebito.response;

import com.nttData.TarjetasDebito.entity.TarjetaDebito;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Response <T> {
    private int satatus;
    private String status_text;
    private HashMap<String, String> errors;
    private String message;
    private String path;
    private  T data;


    public void getData(T save) {
    }
}
