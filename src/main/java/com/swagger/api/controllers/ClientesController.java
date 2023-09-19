package com.swagger.api.controllers;

import com.swagger.api.models.Clientes;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @ApiOperation(value = "Obtener todos los clientes", notes = "Obtener todos los clientes")
    @GetMapping("/listar")
    public ResponseEntity<List<Clientes>> all(){
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @ApiOperation(value = "Guardar un cliente en memoria", notes = "Devuelve el cliente guardado")
    @PostMapping("")
    public ResponseEntity<Clientes> guardarCliente(@RequestBody Clientes c){
        Clientes cliente = new Clientes(c.getId(), c.getNombre(), c.getApellido(), c.getGenero(), c.getEdad());
        clientes.add(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Obtener un cliente por id", notes = "Obtener un cliente por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operacion exitosa"),
            @ApiResponse(code = 404, message = "Cliente No Encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Clientes> getClienteByid(@ApiParam(value = "Id por el cual se buscara el cliente") @PathVariable int id){
        Optional<Clientes> cliente = clientes.stream().filter(c -> c.getId() == id)
                .findFirst();
        if (cliente.isPresent()) {
            return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

}
