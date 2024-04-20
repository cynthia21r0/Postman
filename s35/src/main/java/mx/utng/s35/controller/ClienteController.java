package mx.utng.s35.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.utng.s35.model.Cliente;
import mx.utng.s35.persistence.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteRepository clienteRepository;

    //Inyeccion de dependencia con AUTOWIRED
    @Autowired
    public ClienteController(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    
    //metodo que permita crear un cliente, por medio del metodo POST
    @PostMapping
    public ResponseEntity<Void> crearCliente(@RequestBody Cliente cliente){
        //se crea un objeto para almacenar a un cliente
        Cliente clienteDB = clienteRepository.save(cliente);
        return ResponseEntity.created(URI.create(clienteDB.getId().toString())).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cliente gClienteById(@PathVariable String id){
        Long idLong = Long.parseLong(id);
        return clienteRepository.findById(idLong).get();
    }
}
