package com.uam.biblioteca.service;

import com.uam.biblioteca.model.PagoDeServicios;
import com.uam.biblioteca.repository.IRepositorioPagoDeServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePagoDeServicios implements IServicePagoDeServicios {

    @Autowired
    private IRepositorioPagoDeServicios repo;

    @Override
    public List<PagoDeServicios> getAll() {
        return repo.findAll();

    }

    @Override
    public PagoDeServicios save(PagoDeServicios pds) {
        return repo.save(pds);
    }

    @Override
    public void deleteById(Long id){
        repo.deleteById(id);
    }

}
