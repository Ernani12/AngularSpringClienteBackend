

package com.api.cliente.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// working jakarta
// entidade e tablea gerada
@Entity

@Table(name = "cliente")

//lombok generate setters and getters abstract
@Getter
@Setter
public class Cliente {

   
    @Id // gerar id automatico com auto incremento
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Long codigo;
     private String nome;
     private String cnpj;
     private String endereco;
  
    
}