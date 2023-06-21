package com.uam.biblioteca.controler;

import com.uam.biblioteca.dto.SingUpResponse;
import com.uam.biblioteca.dto.TransaccionResponse;
import com.uam.biblioteca.model.Cuenta;
import com.uam.biblioteca.model.Transaccion;
import com.uam.biblioteca.service.IServiceTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaccion")
public class ControllerTransaccion {

    //cambiar iserviceLibro
    @Autowired
    private IServiceTransaccion serviceTransaccion;

    @GetMapping("/all")
    public List<Transaccion> getALl(){

        return serviceTransaccion.getAll();
    }

    /*@PostMapping(value = "/save")
    public Transaccion save(@RequestBody Transaccion transaccion){
        return serviceTransaccion.save(transaccion);
    }*/

    @PostMapping(value = "/save")
    public TransaccionResponse save(
            @Param("idTransaccionString")Long idTransaccionString,
            @Param("numeroDeCuentaEmisoraString")Long numeroDeCuentaEmisoraString,
            @Param("numeroDeCuentaReceptoraString") Long numeroDeCuentaReceptoraString,
            @Param("divisaDeCuentaReceptoraString")String divisaDeCuentaReceptoraString,
            @Param("divisaDeCuentaEmisorabyString")String divisaDeCuentaEmisorabyString,
            @Param("tipoDeCambioString")Float tipoDeCambioString,
            @Param("montoString")Float montoString,
            @Param("detalle")String detalle,
            @Param("fechaString")String fechaString

    ){
        System.out.println(numeroDeCuentaEmisoraString);
        System.out.println(numeroDeCuentaReceptoraString);
        System.out.println(montoString);
        System.out.println(fechaString);
        return serviceTransaccion.save(idTransaccionString,numeroDeCuentaEmisoraString,numeroDeCuentaReceptoraString,divisaDeCuentaReceptoraString,divisaDeCuentaEmisorabyString,tipoDeCambioString,montoString,detalle,fechaString);
    }

    @GetMapping("/transacionbycuenta")
    public List<Transaccion> getTransaccion(@Param("cuenta")Long cuenta){
        System.out.println("controller transaccion "+ cuenta);
        return serviceTransaccion.getTransaccionByCuenta(cuenta);
    }


  /*  @PutMapping(value = "/update")
    public Transaccion update(@RequestBody Transaccion transaccion)throws Exception{
        if(transaccion.getIdTransaccion() == null){
            throw new Exception("please, send the id value");
        }
        return serviceTransaccion.save(transaccion);
    }*/

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        serviceTransaccion.deleteById(id);
    }

}
