package com.api.supermarket_api.Mercado.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

//Entidade Clinte
@Entity
@Table(name = "cliente")
public class Cliente {
    //Declaração da chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; 

    //Declaração da coluna nome
    @Column(name = "nome")
    private String nome;

    //Declaração da coluna
    @Column(name = "codigo") 
    private String codigo;

    //Relacionamento Cliente - NotaFiscal
    @OneToMany(mappedBy = "cliente", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NotaFiscal> notaFiscals = new ArrayList<NotaFiscal>();


    public Cliente() {
    }

    public Cliente(Long id, String nome, String codigo, List<NotaFiscal> notaFiscals) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.notaFiscals = notaFiscals;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<NotaFiscal> getNotaFiscals() {
        return this.notaFiscals;
    }

    public void setNotaFiscals(List<NotaFiscal> notaFiscals) {
        this.notaFiscals = notaFiscals;
    }
}
