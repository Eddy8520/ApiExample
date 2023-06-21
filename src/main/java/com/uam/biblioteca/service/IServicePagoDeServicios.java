package com.uam.biblioteca.service;

import com.uam.biblioteca.model.PagoDeServicios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServicePagoDeServicios {

    public List<PagoDeServicios> getAll();

    public PagoDeServicios save(PagoDeServicios pds);

    public void deleteById(Long id);

}
