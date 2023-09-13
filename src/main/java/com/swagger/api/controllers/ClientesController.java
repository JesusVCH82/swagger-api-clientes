package com.swagger.api.controllers;

import com.swagger.api.models.Clientes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@Api(tags = "API REST de Clientes")
public class ClientesController {

    private List<Clientes> clientes= new ArrayList<>();

    public ClientesController() {
        clientes.add(new Clientes(1,"Jesus", "Vazquez", "M", 30));
        clientes.add(new Clientes(2,"marco", "perezz", "M", 30));
        clientes.add(new Clientes(3,"juan", "Lopez", "M", 30));
    }

    @GetMapping("/inicio")
    public String holaMundo(){
        return "hola mundo";
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Clientes>> all(){
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @ApiOperation(value = "Guardar un cliente en memoria", notes = "Devuelve el cliente guardado    ")
    @PostMapping("")
    public ResponseEntity<Clientes> guardarCliente(@RequestBody Clientes c){
        Clientes cliente = new Clientes(c.getId(), c.getNombre(), c.getApellido(), c.getGenero(), c.getEdad());
        clientes.add(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> getClienteByid(@PathVariable int id){
        Clientes cliente = clientes.get(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

}
