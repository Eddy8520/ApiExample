package com.uam.biblioteca.controler;

import com.uam.biblioteca.model.PagoDeServicios;
import com.uam.biblioteca.service.IServicePagoDeServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagodeservicios")
public class ControllerPagoDeServicios {

    //cambiar iserviceLibro
    @Autowired
    private IServicePagoDeServicios service;

    @GetMapping("/all")
    public List<PagoDeServicios> getALl(){

        return service.getAll();
    }

    @PostMapping(value = "/save")
    public PagoDeServicios savePagoDeServicios(@RequestBody PagoDeServicios pds){
        return service.save(pds);
    }


    @PutMapping(value = "/update")
    public PagoDeServicios updatePagoDeServicios(@RequestBody PagoDeServicios pds)throws Exception{
        if(pds.getIdPagoDeServicios() == null){
            throw new Exception("please, send the id value");
        }
        return service.save(pds);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePagoDeServicios(@PathVariable Long id){
        service.deleteById(id);
    }

}
