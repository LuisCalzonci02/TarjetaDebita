package com.nttData.TarjetasDebito.dto;

import com.NttData.CuentasSevice.dto.ClienteInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class TarjetasCliente {
    ClienteInfo clienteInfo;
    List<List<TarjetaInfo>> tarjetasInfo;

    public TarjetasCliente(ClienteInfo clienteInfo, List<List<TarjetaInfo>> tarjetasInfo) {
        this.clienteInfo = clienteInfo;
        this.tarjetasInfo = tarjetasInfo;
    }

    public TarjetasCliente() {
    }
}
