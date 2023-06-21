package com.uam.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Cuenta")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries(value = {
        @NamedQuery(name = "Cuenta.all", query ="select e from Cuenta e")
})
public class Cuenta {
    @Id
    @SequenceGenerator(name="cuenta_seq",sequenceName = "cuenta_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cuenta_seq")
    private Long numeroDeCuenta;
    private Long userID;
    private String divisaCuenta;
    private Float saldoCuenta;
    private Float tipoInteres;
    private String tipoCuenta;
}
