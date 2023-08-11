package com.api.supermarket_api.Mercado.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
//Entidade Produtos
@Entity
@Table(name = "produto")
public class Produto {
    //Declaração da chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    //Declaração da coluna codicoProduto
    @Column(name = "codicoProduto")
    private String codicoProduto;

    //Declaração da coluna descricao
    @Column(name = "descricao")
    private String descricao;

    //Declaração da coluna valorUnitario
    @Column(name = "valorUnitario")
    private BigDecimal valorUnitario;

    //Relacionamento produto - ItensNota
    @JsonIgnore
    @OneToMany(mappedBy = "produto", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItensNota> itensNotas = new ArrayList<ItensNota>();

    //getter and setters
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getCodicoProduto(){
        return codicoProduto;
    }
    public void setCodicoProduto(String codicoProduto){
        this.codicoProduto = codicoProduto;
    }

    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public BigDecimal getValorUnitario(){
        return valorUnitario;
    }
    public void setValorUnitario(BigDecimal valorUnitario){
        this.valorUnitario = valorUnitario;
    }

    //getter and setter para relacionamento com Produto - Cliente
    public void setItensNota(List<ItensNota> itensNotas){
        this.itensNotas = itensNotas;
    } 

    public List<ItensNota> getItensNotas(){
        return itensNotas;
    }
}
