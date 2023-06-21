package com.uam.biblioteca.service;

import com.uam.biblioteca.model.Cuenta;
import com.uam.biblioteca.repository.IRepositorioCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCuenta implements IServiceCuenta {

    @Autowired
    private IRepositorioCuenta repo;

    @Override
    public List<Cuenta> getCuentaByName(String name) {
        System.out.println("name"+ name);
        List<Cuenta> c = repo.findByUserName(name);
        //System.out.println(c.get(1).getSaldoCuenta().toString());
        return c;

    }
    public Cuenta getCuentaByNCuenta(Long ncuenta){
        System.out.println("ncuenta"+ncuenta);
        Cuenta cuentaL=repo.findByNCuenta(ncuenta);
        return cuentaL;
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        return repo.save(cuenta);
    }
    @Override
    public void deleteById(Long id){
        repo.deleteById(id);
    }

}
