package com.api.produtos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.produtos.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto,Long> {
    

}
