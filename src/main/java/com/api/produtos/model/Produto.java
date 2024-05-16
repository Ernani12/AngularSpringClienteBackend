

package com.api.produtos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// working jakarta
// entidade e tablea gerada
@Entity

@Table(name = "produtos")

//lombok generate setters and getters abstract
@Getter
@Setter

public class Produto {

    @Id // gerar id automatico com auto incremento
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Long codigo;
     private String nome;
     private String marca;
    
}