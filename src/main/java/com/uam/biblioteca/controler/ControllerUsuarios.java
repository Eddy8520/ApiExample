package com.uam.biblioteca.controler;

import com.uam.biblioteca.dto.LoginResponse;
import com.uam.biblioteca.dto.SingUpResponse;
import com.uam.biblioteca.model.Usuario;
import com.uam.biblioteca.service.IServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("192.*.*.*")
public class ControllerUsuarios {


    @Autowired
    private IServiceUsuario serviceUsuario;

    @GetMapping("/user")
    public Usuario getInfo(@Param("name")String name){
        System.out.println(name);
        return serviceUsuario.getUserInfo(name);
    }

    @PostMapping("/login")
    public LoginResponse getLogin(@Param("name") String name,  @Param("password") String password) {
        System.out.println(name);
        System.out.println(password);
        return serviceUsuario.getUser(name, password);
    }

    @PostMapping(value = "/save")
    public SingUpResponse saveUsuario(@Param("name")String name, @Param("password")String password, @Param("nombre") String nombre, @Param("apellido")String apellido, @Param("mail")String mail){
        System.out.println(name);
        System.out.println(password);
        System.out.println(nombre);
        System.out.println(password);
        return serviceUsuario.save(name,password,nombre,apellido,mail);
    }


    /*@PutMapping(value = "/update")
    public Usuario updateUsuario(@RequestBody Usuario usuario)throws Exception{
        if(usuario.getId() == null){
            throw new Exception("please, send the id value");
        }
        return serviceUsuario.save(name,password,nombre,apellido,mail);
    }
      */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteUsuario(@PathVariable Long id){
        serviceUsuario.deleteById(id);
    }



}
