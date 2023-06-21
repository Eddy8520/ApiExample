package com.uam.biblioteca.service;

import com.uam.biblioteca.model.Cuenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceCuenta {

    public List<Cuenta> getCuentaByName(String name);
    public Cuenta getCuentaByNCuenta(Long ncuenta);


    public Cuenta save(Cuenta cuenta);

    public void deleteById(Long id);

}
