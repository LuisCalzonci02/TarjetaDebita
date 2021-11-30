package com.nttData.TarjetasDebito.service;


import com.NttData.CuentasSevice.entity.Cuenta;
import com.nttData.TarjetasDebito.dto.TarjetaInfo;
import com.nttData.TarjetasDebito.entity.TarjetaDebito;
import com.nttData.TarjetasDebito.repository.TarjetaDebitoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarjetaService {

    @Autowired
    private TarjetaDebitoDao repo;
    RestTemplate restTemplate = new RestTemplate();

    public Cuenta getCuenta(int numCuenta) {
        return restTemplate.getForObject("http://localhost:8087/cuentaPorNumCuenta/" + numCuenta, Cuenta.class);
    }

    public boolean getAutentificacion(int numCuenta) {

        return restTemplate.getForObject("http://localhost:8087/autentificacionPorCuenta/" + numCuenta, Boolean.class);

    }
    public boolean getCuentaExiste(int numCuenta) {
        return restTemplate.getForObject("http://localhost:8087/cuentaExiste/" + numCuenta, Boolean.class);

    }
    public List<TarjetaInfo> getTarjetasPorCuenta (int numCuenta){
        return generarLista(repo.findTarjetasByNumCuenta(numCuenta));
    }

    private List<TarjetaInfo> generarLista(List<TarjetaDebito> tarjetasByNumCuenta) {
        List<TarjetaInfo> tarjetasInfo = new ArrayList<>();
         for (TarjetaDebito t:tarjetasByNumCuenta) {
            TarjetaInfo tarjetaInfo = new TarjetaInfo(t.getNumeroTarjeta(),t.getMarcaTarjeta(),t.getEstado(),t.getFechaVencimiento(),t.getLimiteExtraccion());
            tarjetasInfo.add(tarjetaInfo);
        }
         return  tarjetasInfo;
    }

}