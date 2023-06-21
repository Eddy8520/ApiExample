package com.uam.biblioteca.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Transaccion")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries(value = {
        @NamedQuery(name = "Transaccion.all", query ="select e from Transaccion e")
})
public class Transaccion {

    @Id
    @SequenceGenerator(name="Transaccion_seq",sequenceName = "Transaccion_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Transaccion_seq")
    private Long idTransaccion;
    private String detalle;
    private Float monto;
    private Long numeroDeCuentaEmisoara;
    private Long numeroDeCuentaReceptora;
    private String divisaDeCuentaReceptora;
    private String divisaDeCuentaEmisora;
    private Float tipoDeCambio;
    //temp string
    private String fecha;






}
