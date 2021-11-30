package com.nttData.TarjetasDebito.dto;

import com.NttData.CuentasSevice.dto.ClienteInfo;
import com.example.EquipoC.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TarjetasClientePosicion {

    ClienteInfo clienteInfo;
    List<TarjetaInfo> tarjetasInfo;

    public TarjetasClientePosicion(ClienteInfo clienteInfo, List<TarjetaInfo> tarjetasInfo) {
        this.clienteInfo = clienteInfo;
        this.tarjetasInfo = tarjetasInfo;
    }

    public TarjetasClientePosicion() {
    }
}
