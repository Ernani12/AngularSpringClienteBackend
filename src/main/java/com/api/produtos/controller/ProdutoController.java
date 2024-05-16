package com.api.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.produtos.model.Produto;
import com.api.produtos.model.ResponseModel;
import com.api.produtos.repository.ProdutoRepository;
import com.api.produtos.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ProdutoController {

    @Autowired
    private ProdutoService S;

    @Autowired
    private ProdutoRepository R; 

    @GetMapping("/listar")
    public Iterable<Produto> listar() {
        return S.listar();
    }

    @GetMapping("/") //mapping default
    public String route(){
        return "API PIZZA";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Produto p) {
        return S.cadastrar(p);
    }
    
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Produto p) {
        return S.Alterar(p);
    }

    @DeleteMapping("/remover/{codigo}") //add variable 
    public ResponseEntity<ResponseModel> remover(@PathVariable long codigo) {
        return S.remover(codigo);
    }

}
