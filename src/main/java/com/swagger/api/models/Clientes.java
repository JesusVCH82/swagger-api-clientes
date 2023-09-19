package com.swagger.api.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "Modelo de datos para el Cliente")
public class Clientes {
    @ApiModelProperty(value = "Identificador del cliente")
    private  int id;
    @ApiModelProperty(value = "Campo nombre del cliente")
    private String nombre;
    @ApiModelProperty(value = "Campo apellido del cliente")
    private String apellido;
    @ApiModelProperty(value = "Campo genero del cliente")
    private String genero;
    @ApiModelProperty(value = "Campo edad del cliente")
    private int edad;
}
