package com.uam.biblioteca.service;

import com.uam.biblioteca.dto.TransaccionResponse;
import com.uam.biblioteca.model.Transaccion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceTransaccion {

    public List<Transaccion> getAll();

    public TransaccionResponse save(Long idTransaccionString, Long numeroDeCuentaEmisoraString, Long numeroDeCuentaReceptoraString, String divisaDeCuentaReceptoraString, String divisaDeCuentaEmisorabyString, Float tipoDeCambioString, Float montoString,String detalle, String fechaString);

    public List<Transaccion> getTransaccionByCuenta (Long cuenta);


    public void deleteById(Long id);

}
