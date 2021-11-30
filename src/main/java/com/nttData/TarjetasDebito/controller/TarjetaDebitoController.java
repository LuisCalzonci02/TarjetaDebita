package com.nttData.TarjetasDebito.controller;

import com.nttData.TarjetasDebito.entity.TarjetaDebito;
import com.nttData.TarjetasDebito.repository.TarjetaDebitoDao;
import com.nttData.TarjetasDebito.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TarjetaDebitoController {

    @Autowired
    private TarjetaDebitoDao tarjetaDebitoDao;

    @GetMapping("/tarjetas")
    public List<TarjetaDebito> allTarjetasDebito(){
        return (List<TarjetaDebito>) tarjetaDebitoDao.findAll();
    }
//    @PostMapping("/tarjeta")
//    public TarjetaDebito solicitudTarjetaDebito(@RequestBody TarjetaDebito tarjetaDebito){
//        return tarjetaDebitoDao.save(tarjetaDebito);
//    }
        @PostMapping("/tarjeta")
        public Object solicitudTarjetaDebito(@Validated @RequestBody TarjetaDebito tarjetaDebito, BindingResult bindingResult){
            Response<TarjetaDebito>  response = new Response<TarjetaDebito>();
            if (bindingResult.hasErrors()){
                response.setSatatus(400);
                response.setStatus_text("bad request");
                response.setMessage("error al solicitar la tarjeta de debito"+bindingResult.getErrorCount());
                    return "error";
            }else{
                response.setSatatus(200);
                response.setStatus_text("ok");
                response.setMessage("Tarjeta creada esxitosamente");
                response.getData(tarjetaDebitoDao.save(tarjetaDebito));

            }
        return new ResponseEntity<Response<TarjetaDebito>>(response, HttpStatus.OK);
        }
}












