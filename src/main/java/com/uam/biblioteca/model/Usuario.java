package com.uam.biblioteca.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Usuario",uniqueConstraints = {@UniqueConstraint(name = "uk_usuario_name",columnNames = ("name"))}
)
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries(value = {
        @NamedQuery(name = "Usuario.all", query ="select e from Usuario e")
})
public class Usuario {

    @Id
    @SequenceGenerator(name="usuario_seq",sequenceName = "usuario_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "usuario_seq")
    private Long id;

    @Column(name="name")
    private String name;
    private String password;
    private String nombre;
    private String apellido;
    private String mail;


}
