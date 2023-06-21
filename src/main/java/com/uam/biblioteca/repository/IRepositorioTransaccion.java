package com.uam.biblioteca.repository;

import com.uam.biblioteca.model.Cuenta;
import com.uam.biblioteca.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositorioTransaccion extends JpaRepository<Transaccion, Long> {

    @Query("select e from Transaccion e where e.numeroDeCuentaEmisoara = :cuenta")
    List<Transaccion> getByCuenta (@Param("cuenta") Long cuenta);

}
