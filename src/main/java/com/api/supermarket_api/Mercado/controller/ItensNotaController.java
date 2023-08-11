package com.api.supermarket_api.Mercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.supermarket_api.Mercado.entity.ItensNota;
import com.api.supermarket_api.Mercado.entity.Produto;
import com.api.supermarket_api.Mercado.repository.ItensNotaRepository;
import com.api.supermarket_api.Mercado.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItensNotaController {

    @Autowired
    private ItensNotaRepository itensNotaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/itensNota")
    //Obter os dados de todos os clientes
    public List<ItensNota> getAllItens(){
        return itensNotaRepository.findAll();
    }

    //@GetMapping("/api/cliente/{id}")
    @GetMapping("/{id}")
    //Obter os dados de um cliente pelo id
    public ResponseEntity<ItensNota> getNotaFiscalById(@PathVariable Long id) {
        Optional<ItensNota> itensNota = itensNotaRepository.findById(id);
        return itensNota.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/itensNota")
    @ResponseStatus(HttpStatus.CREATED)
    public ItensNota createNotaFiscal(@RequestBody ItensNota itensNota) {
        // Certifique-se de que o cliente associado existe no banco de dados
        Optional<Produto> produto = produtoRepository.findById(itensNota.getProduto().getId());
        if (produto.isPresent()) {
            itensNota.setProduto(produto.get());
            return itensNotaRepository.save(itensNota);
        } else {
            throw new RuntimeException("Produto não encontrado");
        }
    }

    @PutMapping("/itensNota/{id}")
    public ResponseEntity<ItensNota> updateItensNota(@PathVariable Long id, @RequestBody ItensNota itensNota) {
        Optional<ItensNota> existingItensNota = itensNotaRepository.findById(id);
        if (existingItensNota.isPresent()) {
            ItensNota updatedItensNota = existingItensNota.get();
            updatedItensNota.setItensSequenciais(itensNota.getItensSequenciais());
            updatedItensNota.setQuantProdutos(itensNota.getQuantProdutos());
            updatedItensNota.setValorTotal(itensNota.getValorTotal());
            //itensExistente.setProduto(itensNota.getProduto());
            
            // Certifique-se de que o cliente associado existe no banco de dados
            Optional<Produto> produto = produtoRepository.findById(itensNota.getProduto().getId());
            if (produto.isPresent()) {
                updatedItensNota.setProduto(produto.get());
                return ResponseEntity.ok(itensNotaRepository.save(updatedItensNota));
            } else {
                throw new RuntimeException("Produto não encontrado");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/itensNota/{id}")
    public ResponseEntity<String> deleteItensNota(@PathVariable Long id) {
        Optional<ItensNota> itensNota = itensNotaRepository.findById(id);
        if (itensNota.isPresent()) {
            itensNotaRepository.delete(itensNota.get());
            return ResponseEntity.ok("Nota Fiscal deletada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
