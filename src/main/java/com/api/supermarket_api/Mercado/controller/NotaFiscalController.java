package com.api.supermarket_api.Mercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.supermarket_api.Mercado.entity.NotaFiscal;
import com.api.supermarket_api.Mercado.repository.NotaFiscalRepository;

import java.util.List;

@RestController
@RequestMapping("/api/notaFiscal")
public class NotaFiscalController {

    private final NotaFiscalRepository notaFiscalRepository;
    
    @Autowired
    public NotaFiscalController(NotaFiscalRepository notaFiscalRepository){
        this.notaFiscalRepository = notaFiscalRepository;
    }

    @GetMapping
    //Obter os dados de todos os clientes
    public List<NotaFiscal> getAllNota(){
        return notaFiscalRepository.findAll();
    }

    //@GetMapping("/api/cliente/{id}")
    @GetMapping("/{id}")
    //Obter os dados de um cliente pelo id
    public NotaFiscal getNotaById(@PathVariable Long id){
        return notaFiscalRepository.findById(id).get();
    }

    @PostMapping
    //Inserir dados dentro de um cliente
    public NotaFiscal saveNota(@RequestBody NotaFiscal notaFiscal){
        return notaFiscalRepository.save(notaFiscal);
    }

    @PutMapping("/{id}")
    //Atualizar dados de um cliente pelo id
    public NotaFiscal updateNota(@PathVariable Long id, @RequestBody NotaFiscal notaFiscal){
        NotaFiscal notaExistente = notaFiscalRepository.findById(id).get(); //Obter os dados pelo id
        notaExistente.setNumeroNota(notaFiscal.getNumeroNota());
        notaExistente.setDataCompra(notaFiscal.getDataCompra());
        notaExistente.setCliente(notaFiscal.getCliente());
        notaExistente.setTotalNota(notaFiscal.getTotalNota());
        return notaFiscalRepository.save(notaExistente);
    }

    @DeleteMapping("/{id}")
    //Deletar um cliente pelo id
    public String deleteNota(@PathVariable Long id){
        try {
            notaFiscalRepository.findById(id).get();
            notaFiscalRepository.deleteById(id);
            return "Nota Fiscal deletada com sucesso";
        } catch (Exception e) {
            return "Nota Fiscal não encontrada";  
        }
    }   
}
