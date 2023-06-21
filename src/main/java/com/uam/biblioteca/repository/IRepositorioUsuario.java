package com.uam.biblioteca.repository;

import com.uam.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface






IRepositorioUsuario extends JpaRepository<Usuario, Long> {

    @Query("select e from Usuario e where e.name = :user and e.password = :password")
    public Usuario getUserByUser(@Param("user") String user, @Param("password") String password);

    @Query("select e from Usuario e where e.name = :user ")
    public Usuario getUser(@Param("user") String user);

}
