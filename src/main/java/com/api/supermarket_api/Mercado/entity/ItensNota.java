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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "itensNota")
public class ItensNota {
    //Declaração da chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Declaração da coluna totalNota
    @Column(name = "itensSequenciais")
    private String itensSequenciais;

    //Criando relacionamento ManyToOne para produtos
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    //Declaração da coluna quantProdutos
    @Column(name = "quantProdutos")
    private Integer quantProdutos;

    //Declaração da coluna valorTotal
    @Column(name = "valorTotal")
    private BigDecimal valorTotal;

    //Relacionamento ItensNota - Notas
    @OneToMany(mappedBy = "itensNota", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NotaFiscal> notaFiscals = new ArrayList<NotaFiscal>();

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

    public Produto getProduto(){
        return produto;
    }
    public void setProduto(Produto produto){
        this.produto = produto;
    }

    public Integer getQuantProdutos(){
        return quantProdutos;
    }
    public void setQuantProdutos(Integer quantProdutos){
        this.quantProdutos = quantProdutos;
    }

    public BigDecimal getValorTotal(){
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal){
        this.valorTotal = valorTotal;
    } 

    public void setNotaFiscal(List<NotaFiscal> notaFiscals){
        this.notaFiscals = notaFiscals;
    }

    public List<NotaFiscal> getNotaFiscal(){
        return notaFiscals;
    }
}
