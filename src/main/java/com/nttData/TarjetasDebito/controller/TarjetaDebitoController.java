package com.nttData.TarjetasDebito.controller;

import com.nttData.TarjetasDebito.dto.TarjetaInfo;
import com.nttData.TarjetasDebito.entity.TarjetaDebito;
import com.nttData.TarjetasDebito.repository.TarjetaDebitoDao;
import com.nttData.TarjetasDebito.response.Response;
import com.nttData.TarjetasDebito.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TarjetaDebitoController {

    @Autowired
    private TarjetaDebitoDao tarjetaDebitoDao;

    @Autowired
    private TarjetaService services;


    @GetMapping("/tarjetas")
    public List<TarjetaDebito> allTarjetasDebito() {
        return (List<TarjetaDebito>) tarjetaDebitoDao.findAll();
    }


    @PostMapping("/agregarTarjeta")
    public ResponseEntity<String> solicitudTarjetaDebito(@Validated @RequestBody TarjetaDebito tarjetaDebito, BindingResult bindingResult) {
        Response<TarjetaDebito> response = new Response<TarjetaDebito>();

        if (services.getCuentaExiste(tarjetaDebito.getNumeroCuenta())) {
            if (services.getAutentificacion(tarjetaDebito.getNumeroCuenta())) {
                if (bindingResult.hasErrors()) {
                    return ResponseEntity.status(400).body("error al solicitar la tarjeta de debito");
                } else {
                    tarjetaDebitoDao.save(tarjetaDebito);
                    return ResponseEntity.ok("Tarjeta agregada exitosamente a la cuenta " + tarjetaDebito.getNumeroCuenta());
                }
            } else {
                return ResponseEntity.status(401).body("Debe de iniciar sesión.");
            }

        } else {
            return ResponseEntity.status(400).body("No tiene cuentas o el número no coincide con las cuentas relacionadas a su nombre.");

        }
    }

    @GetMapping("/tarjetasCuenta/{numCuenta}")
    public List<TarjetaInfo> getTarjetasCliente(@PathVariable("numCuenta") int numCuenta) {
        return services.getTarjetasPorCuenta(numCuenta);
    }


}












