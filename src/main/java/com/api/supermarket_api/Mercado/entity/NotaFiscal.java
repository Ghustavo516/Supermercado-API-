package com.api.supermarket_api.Mercado.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

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

    //Declaração da coluna nomeCliente
    @Column(name = "nomeCliente")
    private String nomeCliente;

    //Declaração da coluna totalNota
    @Column(name = "totalNota")
    private Double totalNota;



    //Generate getters and setters
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Integer getNumeroNota(){
        return numeroNota;
    }
    public void setNumeroNota(Integer numeroNota){
        this.numeroNota = numeroNota;
    }

    public Date getDataCompra(){
        return dataCompra;
    }
    public void setDataCompra(Date dataCompra){
        this.dataCompra = dataCompra;
    }

    public String getCliente(){
        return nomeCliente;
    }
    public void setCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }

    public Double getTotalNota(){
        return totalNota;
    }
    public void setTotalNota(Double totalNota){
        this.totalNota = totalNota;
    }
    
}
