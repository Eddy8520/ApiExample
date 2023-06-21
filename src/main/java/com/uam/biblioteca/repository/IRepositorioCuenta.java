package com.uam.biblioteca.repository;

import com.uam.biblioteca.model.Cuenta;
import com.uam.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositorioCuenta extends JpaRepository<Cuenta, Long> {


    @Query("SELECT e FROM Cuenta e WHERE e.userID = (SELECT u.id FROM Usuario u WHERE u.name = :user)")
    List<Cuenta> findByUserName(@Param("user") String user);

    @Query("SELECT e FROM Cuenta e WHERE e.numeroDeCuenta= :ncuenta")
    Cuenta findByNCuenta(@Param("ncuenta") Long ncuenta);


}
