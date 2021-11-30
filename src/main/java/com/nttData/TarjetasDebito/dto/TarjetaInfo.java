package com.nttData.TarjetasDebito.dto;

import com.nttData.TarjetasDebito.helper.MarcaTarjeta;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter

public class TarjetaInfo {

    private Long numeroTarjeta;
    private MarcaTarjeta marcaTarjeta;
    private String estado;
    private String fechaVencimiento;
    private Float limiteExtraccion;

    public TarjetaInfo(Long numeroTarjeta, MarcaTarjeta marcaTarjeta, String estado, String fechaVencimiento, Float limiteExtraccion) {
        this.numeroTarjeta = numeroTarjeta;
        this.marcaTarjeta = marcaTarjeta;
        this.estado = estado;
        this.fechaVencimiento = fechaVencimiento;
        this.limiteExtraccion = limiteExtraccion;
    }

    public TarjetaInfo() {
    }
}


