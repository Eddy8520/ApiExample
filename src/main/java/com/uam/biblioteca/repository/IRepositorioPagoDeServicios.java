package com.uam.biblioteca.repository;

import com.uam.biblioteca.model.PagoDeServicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioPagoDeServicios extends JpaRepository<PagoDeServicios, Long> {
}
