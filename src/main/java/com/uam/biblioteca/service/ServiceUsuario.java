package com.uam.biblioteca.service;

import com.uam.biblioteca.dto.LoginResponse;
import com.uam.biblioteca.dto.SingUpResponse;
import com.uam.biblioteca.model.Usuario;
import com.uam.biblioteca.repository.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceUsuario implements IServiceUsuario {


    @Autowired
    private IRepositorioUsuario repo;

    @Override
    public Usuario getUserInfo(String user) {
        System.out.println(user);
         Usuario u = repo.getUser(user);

         return u;
    }
    @Override
    public LoginResponse getUser(String user, String password) {
        System.out.println(user);
        System.out.println(password);
        Usuario u = repo.getUserByUser(user,password);
        LoginResponse lr =  new LoginResponse(false,"Not Connect");
        if (u != null) {
            lr = new LoginResponse(true,"User connected");
        }
        return lr;
    }



    @Override
    public SingUpResponse save(String user, String password, String nombre, String apellido, String mail) {
        System.out.println(user);
        System.out.println(password);
        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(mail);

        Usuario u = new Usuario();

                u.setName(user);
                u.setPassword(password);
                u.setNombre(nombre);
                u.setApellido(apellido);
                u.setMail(mail);
                u = repo.save(u);
      SingUpResponse lr =new SingUpResponse(false,"No se guardo, Use otro UserName");
        if (u != null){
            lr = new SingUpResponse(true,"Usuario Guardado");

        }
        System.out.println(lr.getMsg());
        System.out.println(lr.isSingUpSuccess());
        return lr ;

    }
    @Override
    public void deleteById(Long id){
        repo.deleteById(id);
    }

}
