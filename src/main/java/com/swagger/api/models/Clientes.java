package com.swagger.api.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Clientes {
    private  int id;
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;
}
