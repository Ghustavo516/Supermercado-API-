package com.api.supermarket_api.Mercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.supermarket_api.Mercado.entity.ItensNota;
import com.api.supermarket_api.Mercado.repository.ItensNotaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/itensNota")
public class ItensNotaController {

    private final ItensNotaRepository itensNotaRepository;
    
    @Autowired
    public ItensNotaController(ItensNotaRepository itensNotaRepository){
        this.itensNotaRepository = itensNotaRepository;
    }

    @GetMapping
    //Obter os dados de todos os clientes
    public List<ItensNota> getAllItens(){
        return itensNotaRepository.findAll();
    }

    //@GetMapping("/api/cliente/{id}")
    @GetMapping("/{id}")
    //Obter os dados de um cliente pelo id
    public ItensNota getItensById(@PathVariable Long id){
        return itensNotaRepository.findById(id).get();
    }

    @PostMapping
    //Inserir dados dentro de um cliente
    public ItensNota saveItens(@RequestBody ItensNota itensNota){
        return itensNotaRepository.save(itensNota);
    }

    @PutMapping("/{id}")
    //Atualizar dados de um cliente pelo id
    public ItensNota updateItens(@PathVariable Long id, @RequestBody ItensNota itensNota){
        ItensNota itensExistente = itensNotaRepository.findById(id).get(); //Obter os dados pelo id
        itensExistente.setItensSequenciais(itensNota.getItensSequenciais());
        itensExistente.setProduto(itensNota.getProduto());
        itensExistente.setQuantProdutos(itensNota.getQuantProdutos());
        itensExistente.setValorTotal(itensNota.getValorTotal());
        return itensNotaRepository.save(itensExistente);
    }

    @DeleteMapping("/{id}")
    //Deletar um cliente pelo id
    public String deleteItens(@PathVariable Long id){
        try {
            itensNotaRepository.findById(id).get();
            itensNotaRepository.deleteById(id);
            return "Produto deletado com sucesso";
        } catch (Exception e) {
            return "Produto não encontrado";  
        }
    }   
}
