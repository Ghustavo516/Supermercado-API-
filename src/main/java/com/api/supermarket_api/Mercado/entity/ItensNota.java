package com.api.supermarket_api.Mercado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itensNota")
public class ItensNota {
    //Declaração da chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Declaração da coluna totalNota
    @Column(nullable = false)
    private String itensSequenciais;

    //Declaração da coluna produto
    @Column(nullable = false)
    private String produto;

    //Declaração da coluna quantProdutos
    @Column(nullable = false)
    private Integer quantProdutos;

    //Declaração da coluna valorTotal
    @Column(nullable = false)
    private Double valorTotal;

    //Generate getters and setters
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getItensSequenciais(){
        return itensSequenciais;
    }
    public void setItensSequenciais(String itensSequenciais){
        this.itensSequenciais = itensSequenciais;
    }

    public String getProduto(){
        return produto;
    }
    public void setProduto(String produto){
        this.produto = produto;
    }

    public Integer getQuantProdutos(){
        return quantProdutos;
    }
    public void setQuantProdutos(Integer quantProdutos){
        this.quantProdutos = quantProdutos;
    }

    public Double getValorTotal(){
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal){
        this.valorTotal = valorTotal;
    } 
}
