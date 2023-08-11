package com.api.supermarket_api.Mercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.supermarket_api.Mercado.entity.Cliente;
import com.api.supermarket_api.Mercado.entity.ItensNota;
import com.api.supermarket_api.Mercado.entity.NotaFiscal;
import com.api.supermarket_api.Mercado.repository.ClienteRepository;
import com.api.supermarket_api.Mercado.repository.ItensNotaRepository;
import com.api.supermarket_api.Mercado.repository.NotaFiscalRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ItensNotaRepository itensRepository;

    @GetMapping("/notaFiscal")
    public List<NotaFiscal> getAllNotasFiscais() {
        return notaFiscalRepository.findAll();
    }

    @GetMapping("/notaFiscal/{id}")
    public ResponseEntity<NotaFiscal> getNotaFiscalById(@PathVariable Long id) {
        Optional<NotaFiscal> notaFiscal = notaFiscalRepository.findById(id);
        return notaFiscal.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/notaFiscal")
    @ResponseStatus(HttpStatus.CREATED)
    public NotaFiscal createNotaFiscal(@RequestBody NotaFiscal notaFiscal) {
        // Certifique-se de que o cliente associado existe no banco de dados
        Optional<Cliente> cliente = clienteRepository.findById(notaFiscal.getCliente().getId());
        Optional<ItensNota> itensNota = itensRepository.findById(notaFiscal.getItensNota().getId());

        if (!cliente.isPresent()) {
            throw new RuntimeException("Cliente não encontrado");
        }
        
        if (!itensNota.isPresent()) {
            throw new RuntimeException("Itens Nota não encontrados");
        }

        notaFiscal.setCliente(cliente.get());
        notaFiscal.setItensNota(itensNota.get());
        return notaFiscalRepository.save(notaFiscal);      
    }

    // @PutMapping("/{id}")
    // public NotaFiscal updateNota(@PathVariable Long id, @RequestBody NotaFiscal notaFiscal) {
    //     NotaFiscal notaExistente = notaFiscalRepository.findById(id).orElse(null);
    //     if (notaExistente != null) {
    //         notaExistente.setNumeroNota(notaFiscal.getNumeroNota());
    //         notaExistente.setDataCompra(notaFiscal.getDataCompra());
    //         notaExistente.setCliente(notaFiscal.getCliente());
    //         notaExistente.setTotalNota(notaFiscal.getTotalNota());
    //         return notaFiscalRepository.save(notaExistente);
    //     } else {
    //         return null; // Nota não encontrada, pode ser tratado de outra forma
    //     }
    // }

    @PutMapping("/notaFiscal/{id}")
    public ResponseEntity<NotaFiscal> updateNotaFiscal(@PathVariable Long id, @RequestBody NotaFiscal notaFiscal) {
        Optional<NotaFiscal> existingNotaFiscal = notaFiscalRepository.findById(id);
        if (existingNotaFiscal.isPresent()) {
            NotaFiscal updatedNotaFiscal = existingNotaFiscal.get();
            updatedNotaFiscal.setNumeroNota(notaFiscal.getNumeroNota());
            updatedNotaFiscal.setDataCompra(notaFiscal.getDataCompra());
            updatedNotaFiscal.setTotalNota(notaFiscal.getTotalNota());
            
            // Certifique-se de que o cliente associado existe no banco de dados
            Optional<Cliente> cliente = clienteRepository.findById(notaFiscal.getCliente().getId());
            Optional<ItensNota> itensNota = itensRepository.findById(notaFiscal.getItensNota().getId());

            if(!cliente.isPresent()){
                throw new RuntimeException("Cliente não encontrado");
            }

            if(!itensNota.isPresent()){
                throw new RuntimeException("Itens Nota não encontrado");
            }

            updatedNotaFiscal.setCliente(cliente.get());
            updatedNotaFiscal.setItensNota(itensNota.get());

            return ResponseEntity.ok(notaFiscalRepository.save(updatedNotaFiscal));
            
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/notaFiscal/{id}")
    public ResponseEntity<String> deleteNotaFiscal(@PathVariable Long id) {
        Optional<NotaFiscal> notaFiscal = notaFiscalRepository.findById(id);
        if (notaFiscal.isPresent()) {
            notaFiscalRepository.delete(notaFiscal.get());
            return ResponseEntity.ok("Nota Fiscal deletada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}