package com.uam.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "PagoDeServicios")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries(
        value = {@NamedQuery(name = "PagoDeServicios.all", query = "select e from PagoDeServicios e")}
)

public class PagoDeServicios {

    @Id
    @SequenceGenerator(name = "pagodeservicios_seq",sequenceName = "pagodeservicios_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pagodeservicios_seq")
    private Long idPagoDeServicios;
    private String nombreDeServicio;
    private Float montoAPagar;
    private Long cuentaDeServicio;
    private String divisaDeServicio;

}
