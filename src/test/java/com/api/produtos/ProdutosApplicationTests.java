package com.api.produtos;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.produtos.model.Produto;
import com.api.produtos.service.ProdutoService;

@SpringBootTest
class ProdutosApplicationTests {

	@Test
    public void testAddProduct() {
        // Criação de um objeto ProductService
        ProdutoService productService = new ProdutoService();

        // Criação de um objeto Product para teste
        Produto product = new Produto();
        product.setNome("PAstel 3");
        product.setMarca("Deoce leite");

        // Chamada do método addProduct
        try {
            productService.cadastrar(product);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Verificação se o método addProduct foi chamado com o objeto Product correto
        // Isso requer o uso de um framework de mock, como o Mockito
        Mockito.verify(productService).cadastrar(product);
    }

}
