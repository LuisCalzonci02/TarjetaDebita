package com.nttData.TarjetasDebito.entity;

import com.nttData.TarjetasDebito.helper.MarcaTarjeta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TarjetaDebito")
@Getter @Setter
public class TarjetaDebito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTDebito;
    @Column(length = 16, unique = true)
    private Long numeroTarjeta;
    @Enumerated(EnumType.STRING)
    private MarcaTarjeta marcaTarjeta;
    private String estado;
    private String fechaVencimiento;
    private Float limiteExtraccion;
    private Integer numeroCuenta;
    private String tipoTarjeta;
}
