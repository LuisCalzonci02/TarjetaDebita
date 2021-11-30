package com.nttData.TarjetasDebito.repository;

import com.NttData.CuentasSevice.entity.Cuenta;
import com.nttData.TarjetasDebito.entity.TarjetaDebito;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TarjetaDebitoDao extends CrudRepository<TarjetaDebito, Integer> {

    @Query(value = "select * from tarjeta_debito where numero_cuenta= :num", nativeQuery = true)
    public List<TarjetaDebito> findTarjetasByNumCuenta(Integer num);



}
