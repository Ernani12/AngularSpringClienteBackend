package com.api.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.cliente.model.Cliente;
import com.api.cliente.model.ResponseModel;
import com.api.cliente.service.ClienteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ClienteController {

    @Autowired
    private ClienteService S;



    @GetMapping("/listar")
    public Iterable<Cliente> listar() {
        return S.listar();
    }

    @GetMapping("/") //mapping default
    public String route(){
        return "API Cliente";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Cliente p) {
        return S.cadastrar(p);
    }
    
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Cliente p) {
        return S.Alterar(p);
    }

    @DeleteMapping("/remover/{codigo}") //add variable 
    public ResponseEntity<ResponseModel> remover(@PathVariable long codigo) {
        return S.remover(codigo);
    }

}
