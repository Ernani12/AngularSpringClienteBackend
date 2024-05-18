package com.api.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.cliente.model.Cliente;
import com.api.cliente.model.ResponseModel;
import com.api.cliente.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository pr;

    @Autowired
    private ResponseModel RM;

    //list all products
    public Iterable<Cliente> listar(){
        return pr.findAll();
 
   }

    public ResponseEntity<?> cadastrar(Cliente p){

        if(p.getNome().equals("")){
            RM.setMessage("Nome é Obrigatoria");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }
        else if(p.getCnpj().equals("")){
                RM.setMessage("Cnpj é Obrigatoria");
                return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }else{
            return new  ResponseEntity<Cliente>(pr.save(p),HttpStatus.CREATED);
        }
    }


    public ResponseEntity<?> Alterar(Cliente p){

       if(p.getNome().equals("")){
            RM.setMessage("Nome é Obrigatoria");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }
        else if(p.getCnpj().equals("")){
                RM.setMessage("Cnpj é Obrigatoria");
                return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }else{
            return new  ResponseEntity<Cliente>(pr.save(p),HttpStatus.OK);
        }
        
    }


    public ResponseEntity<ResponseModel> remover (Long codigo){
       pr.deleteById(codigo);

       RM.setMessage("produto removido");
       return new  ResponseEntity<ResponseModel>(RM,HttpStatus.OK);      

    }

}
