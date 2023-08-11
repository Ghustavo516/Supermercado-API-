package com.api.supermarket_api.Mercado.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "notaFiscal")
public class NotaFiscal {
    //Declaração da chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Declaração da coluna numeroNota
    @Column(name = "numeroNota")
    private Integer numeroNota;

    //Declaração da coluna dataCompra
    @Column(name = "dataCompra")
    private Date dataCompra;

    //Criando relacionamento para com tabela de cliente
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id") //SE NÃO FUNCIONAR USAR O FOREIGN KEY
    private Cliente cliente;

    //Declaração da coluna totalNota
    @Column(name = "totalNota")
    private BigDecimal totalNota;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itensNota_id") //SE NÃO FUNCIONAR USAR O FOREIGN KEY
    private ItensNota itensNota;


    public NotaFiscal() {
    }

    public NotaFiscal(Long id, Integer numeroNota, Date dataCompra, Cliente cliente, BigDecimal totalNota, ItensNota itensNota) {
        this.id = id;
        this.numeroNota = numeroNota;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
        this.totalNota = totalNota;
        this.itensNota = itensNota;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroNota() {
        return this.numeroNota;
    }

    public void setNumeroNota(Integer numeroNota) {
        this.numeroNota = numeroNota;
    }

    public Date getDataCompra() {
        return this.dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getTotalNota() {
        return this.totalNota;
    }

    public void setTotalNota(BigDecimal totalNota) {
        this.totalNota = totalNota;
    }

    public ItensNota getItensNota() {
        return this.itensNota;
    }

    public void setItensNota(ItensNota itensNota) {
        this.itensNota = itensNota;
    }  
}
