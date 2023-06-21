package com.uam.biblioteca.service;

import com.uam.biblioteca.dto.SingUpResponse;
import com.uam.biblioteca.dto.TransaccionResponse;
import com.uam.biblioteca.model.Transaccion;
import com.uam.biblioteca.model.Usuario;
import com.uam.biblioteca.repository.IRepositorioTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTransaccion implements IServiceTransaccion{


    @Autowired
    private IRepositorioTransaccion repo;

    @Override
    public List<Transaccion> getAll() {
        return repo.findAll();

    }
    public List<Transaccion> getTransaccionByCuenta(Long cuenta){
        System.out.println(cuenta);
        List<Transaccion> t=repo.getByCuenta(cuenta);
        return t;
    }

    @Override
    public TransaccionResponse save(Long idTransaccionString, Long numeroDeCuentaEmisoraString, Long numeroDeCuentaReceptoraString, String divisaDeCuentaReceptoraString, String divisaDeCuentaEmisorabyString, Float tipoDeCambioString, Float montoString,String detalle, String fechaString) {
        System.out.println(numeroDeCuentaEmisoraString);
        System.out.println(numeroDeCuentaReceptoraString);
        System.out.println(montoString);


        Transaccion u = new Transaccion();

        u.setIdTransaccion(idTransaccionString);
        u.setNumeroDeCuentaEmisoara(numeroDeCuentaEmisoraString);
        u.setNumeroDeCuentaReceptora(numeroDeCuentaReceptoraString);
        u.setDivisaDeCuentaEmisora(divisaDeCuentaEmisorabyString);
        u.setDivisaDeCuentaReceptora(divisaDeCuentaReceptoraString);
        u.setTipoDeCambio(tipoDeCambioString);
        u.setMonto(montoString);
        u.setDetalle(detalle);
        u.setFecha(fechaString);
        u = repo.save(u);

        TransaccionResponse lr =new TransaccionResponse(false,"No se realizo, Error con la cuenta");
        if (u != null){
            lr = new TransaccionResponse(true,"Transaccion Enviada");

        }
        System.out.println(lr.getMsg());
        System.out.println(lr.isSuccessMake());
        return lr ;
    }


    @Override
    public void deleteById(Long id){
        repo.deleteById(id);
    }


}
