package com.uam.biblioteca.controler;

import com.uam.biblioteca.model.Cuenta;
import com.uam.biblioteca.service.IServiceCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class ControllerCuenta {

    //cambiar iserviceLibro
    @Autowired
    private IServiceCuenta serviceCuenta;

    @GetMapping("/cuentabyname")
    public List<Cuenta> getCuenta(@Param("name")String name){
        System.out.println("controller recive name "+ name);
        return serviceCuenta.getCuentaByName(name);
    }
    @GetMapping("/cuentabynumerodecuenta")
    public Cuenta getCuentabyncuenta(@Param("ncuenta")Long ncuenta){

        System.out.println("cuenta destino recive "+ ncuenta);
        return serviceCuenta.getCuentaByNCuenta(ncuenta);
    }

    @PostMapping(value = "/save")
    public Cuenta save(@Param("numeroDeCuenta")Long numeroDeCuenta,
                       @Param("userID")Long userID,
                       @Param("divisaCuenta")String divisaCuenta,
                       @Param("saldoCuenta")Float saldoCuenta,
                       @Param("tipoInteres")Float tipoInteres,
                       @Param("tipoCuenta")String tipoCuenta

    ){
       Cuenta cuenta = new Cuenta();
       cuenta.setNumeroDeCuenta(numeroDeCuenta);
       cuenta.setUserID(userID);
       cuenta.setDivisaCuenta(divisaCuenta);
       cuenta.setSaldoCuenta(saldoCuenta);
       cuenta.setTipoInteres(tipoInteres);
       cuenta.setTipoCuenta(tipoCuenta);

        return serviceCuenta.save(cuenta);
    }


    @PutMapping(value = "/update")
    public Cuenta update(@RequestBody Cuenta cuenta)throws Exception{
        if(cuenta.getNumeroDeCuenta() == null){
            throw new Exception("please, send the id value");
        }
        return serviceCuenta.save(cuenta);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        serviceCuenta.deleteById(id);
    }

}
