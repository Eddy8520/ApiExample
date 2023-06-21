package com.uam.biblioteca.service;

import com.uam.biblioteca.dto.LoginResponse;
import com.uam.biblioteca.dto.SingUpResponse;
import com.uam.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceUsuario {

    public Usuario getUserInfo(String name);

    LoginResponse getUser(String name, String password);

    SingUpResponse save(String user, String password, String nombre, String apellido, String mail);


    public void deleteById(Long id);

}
